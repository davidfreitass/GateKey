import { initializeApp } from "https://www.gstatic.com/firebasejs/9.22.1/firebase-app.js";
import {
    getAuth,
    signOut,
    onAuthStateChanged
} from "https://www.gstatic.com/firebasejs/9.22.1/firebase-auth.js";
import {
    getDatabase,
    ref,
    set,
    onValue
} from "https://www.gstatic.com/firebasejs/9.22.1/firebase-database.js";

const firebaseConfig = {
    apiKey: "AIzaSyBh9Iq2OGfM3FnBDXCrNMrvNjWGI910Go4",
    authDomain: "gatekey-9bb64.firebaseapp.com",
    databaseURL: "https://gatekey-9bb64-default-rtdb.firebaseio.com",
    projectId: "gatekey-9bb64",
    storageBucket: "gatekey-9bb64.firebasestorage.app",
    messagingSenderId: "933663081375",
    appId: "1:933663081375:web:06ef33ba01392a7e5c73aa"
};

const app = initializeApp(firebaseConfig);
const auth = getAuth(app);
const db = getDatabase(app);

const commandRef = ref(db, "/system/commands/command");
const userIdRef = ref(db, "/system/commands/userId");
const statusRef = ref(db, "/system/commands/status");

let usuarioConfirmado = null;
const UI_ELEMENTS = {};

function controlarUI(habilitar) {
    const estado = habilitar ? false : true;
    UI_ELEMENTS.startBiometric.disabled = estado;
    UI_ELEMENTS.deleteAll.disabled = estado;

    if (!habilitar) {
        document.getElementById("status-box").textContent =
            "⚠️ AGUARDANDO DISPOSITIVO... Não envie novos comandos.";
    }
}

async function confirmarUsuario() {
    const tipo = document.getElementById("tipoUsuario").value;
    const id = document.getElementById("usuarioId").value.trim();

    if (!tipo || !id || isNaN(id)) {
        alert("Informe um ID numérico válido.");
        return;
    }

    const endpoint =
        tipo === "morador"
            ? `http://localhost:8081/moradores/${id}`
            : `http://localhost:8081/funcionarios/${id}`;

    try {
        const response = await fetch(endpoint);

        if (!response.ok) {
            alert(`${tipo === "morador" ? "Morador" : "Funcionário"} não encontrado no backend.`);
            return;
        }

        const data = await response.json();

        usuarioConfirmado = {
            id: data.id
        };

        document.getElementById("tipoUsuario").disabled = true;
        document.getElementById("usuarioId").disabled = true;

        const biometriaBox = document.getElementById("biometria-box");
        biometriaBox.classList.remove("d-none");
        biometriaBox.scrollIntoView({ behavior: "smooth" });

        document.getElementById("status-box").textContent =
            `✔ ${tipo === "morador" ? "Morador" : "Funcionário"} confirmado: ${data.nome || data.email || id}`;

    } catch (err) {
        console.error("Erro ao conectar com o backend ou erro de CORS:", err);
        alert("Erro ao conectar com o backend. Verifique a porta (8081) e a configuração CORS (porta 81).");
    }
}

async function iniciarCadastro() {
    if (!usuarioConfirmado || !usuarioConfirmado.id) {
        alert("Confirme o ID do usuário antes de iniciar o cadastro.");
        return;
    }

    controlarUI(false);

    document.getElementById("status-box").textContent =
        `1/3: Enviando ID (${usuarioConfirmado.id})...`;

    await set(userIdRef, usuarioConfirmado.id);

    document.getElementById("status-box").textContent =
        `2/3: Enviando comando 'enroll'...`;

    await set(commandRef, "enroll");

    document.getElementById("status-box").textContent =
        `3/3: Esperando resposta do ESP32... (Veja o status abaixo)`;
}

async function apagarDigitais() {
    if (!confirm("Tem certeza que deseja apagar TODAS as digitais do dispositivo? Esta ação é irreversível.")) return;

    controlarUI(false);

    document.getElementById("status-box").textContent =
        "Enviando comando 'delete' (apagar todas digitais)...";

    await set(userIdRef, 0);
    await set(commandRef, "delete");

    document.getElementById("status-box").textContent =
        "Esperando resposta de limpeza do ESP32... (Veja o status abaixo)";
}

function monitorarStatus() {
    onValue(statusRef, (snapshot) => {
        const status = snapshot.val();
        const statusBox = document.getElementById("status-box");

        if (status && status !== "") {
            statusBox.textContent = "Status do Dispositivo: " + status;

            const statusFinal = status.toLowerCase();
            if (
                statusFinal.includes("concluido") ||
                statusFinal.includes("erro") ||
                statusFinal.includes("limpo")
            ) {
                controlarUI(true);
            }
        }
    });
}

window.addEventListener("DOMContentLoaded", () => {
    UI_ELEMENTS.confirmarUsuario = document.getElementById("confirmarUsuario");
    UI_ELEMENTS.startBiometric = document.getElementById("start-biometric");
    UI_ELEMENTS.deleteAll = document.getElementById("delete-all");

    UI_ELEMENTS.confirmarUsuario.addEventListener("click", confirmarUsuario);
    UI_ELEMENTS.startBiometric.addEventListener("click", iniciarCadastro);
    UI_ELEMENTS.deleteAll.addEventListener("click", apagarDigitais);

    monitorarStatus();
});
