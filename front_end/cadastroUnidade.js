document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("formUnidade");

  form.addEventListener("submit", async (e) => {
    e.preventDefault();

    const numero = document.getElementById("numero").value.trim();
    const bloco = document.getElementById("bloco").value.trim();
    const tipo = document.getElementById("tipo").value.trim();

    if (!numero || !bloco) {
      alert("Número e Bloco são obrigatórios.");
      return;
    }

    const body = {
      numero,
      bloco,
      tipo
    };

    try {
      const response = await fetch("http://localhost:8081/unidades", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(body)
      });

      if (!response.ok) {
        throw new Error("Erro ao cadastrar unidade");
      }

      alert("Unidade cadastrada com sucesso!");
      form.reset();

    } catch (error) {
      console.error(error);
      alert("Erro ao cadastrar unidade.");
    }
  });
});
