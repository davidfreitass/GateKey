document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("formFuncionario");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const nome = document.getElementById("nome").value.trim();
    const cpf = document.getElementById("cpf").value.trim();
    const telefone = document.getElementById("telefone").value.trim();
    const email = document.getElementById("email").value.trim();
    const status = document.getElementById("status").value;

    if (!nome || !cpf) {
      alert("Nome e CPF são obrigatórios.");
      return;
    }

    const body = {
      nome,
      cpf,
      telefone,
      email,
      status
    };

    try {
      const response = await fetch("http://localhost:8081/funcionarios", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
      });

      if (!response.ok) {
        throw new Error("Erro ao cadastrar funcionário");
      }

      alert("Funcionário cadastrado com sucesso!");
      form.reset();

    } catch (error) {
      console.error(error);
      alert("Erro ao cadastrar funcionário.");
    }
  });
});
