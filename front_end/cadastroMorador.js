document.getElementById("btnCadastrar")
  .addEventListener("click", cadastrarMorador);

function cadastrarMorador() {
  const nome = document.getElementById("nome").value;
  const cpf = document.getElementById("cpf").value;
  const telefone = document.getElementById("telefone").value;
  const email = document.getElementById("email").value;

  if (!nome || !cpf || !telefone || !email) {
    alert("Preencha todos os campos");
    return;
  }

  fetch("http://localhost:8081/moradores", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
      nome: nome,
      cpf: cpf,
      telefone: telefone,
      email: email,
      ativo: true
    })
  })
    .then(res => {
      if (!res.ok) throw new Error("Erro ao cadastrar");
      return res.json();
    })
    .then(data => {
      alert("Morador cadastrado com sucesso!");
      console.log(data);
    })
    .catch(err => {
      console.error(err);
      alert("Erro ao cadastrar morador");
    });
}
