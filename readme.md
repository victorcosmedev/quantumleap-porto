# QuickFix - por QuantumLeap
Acesso para a conta do Figma:\
EMAIL: quantumleap_fiap@outlook.com\
SENHA: a48L75v88@2024

**Link para o Figma:** https://www.figma.com/file/XOgfUFXFA4ku5aN2Rvsa2C/Entrega-Sprint-1?type=design&node-id=0%3A1&mode=design&t=iLfPQlWxRBu70S4n-1

**Link para o vídeo de apresentação (CORRIGIDO SPRINT 4):** https://youtu.be/VVuCkCVGdzI


**Link para o repositório:**
https://github.com/victorcosmedev/quantumleap-porto

## Como manipular o sistema
### Cadastro
Inicialmente, os dados são inseridos e o sistema consulta se o registro já
existe, caso sim o usuário é enviado à página de login através do emissor, caso contrário os dados são armazenados no banco de
dados.

### Login
O usuário insere seus dados e o sistema faz a validação de registro no
banco para conferir se o usuário tem cadastro. <br/>
Caso ele não tenha, ele é enviado à
página de cadastro.
Caso ele tenha, sua senha é conferida até que ele insira a senha correta.
Então, ele é logado e redirecionado à home do site.

### Cadastrar veículo
Para realizar esta ação, o usuário precisa estar logado. Caso ele esteja logado, os dados serão inseridos e é realizada
a validação para evitar a duplicidade dos dados no banco. Feita a validação, o
usuário é redirecionado à área do cliente.

### Chatbot
O chatbot ainda não foi implementado por conta da dependência da disciplina de IA & Chatbot, mas optamos por permanecer com o template do chat no site para futura implementação.

### Chamar Guincho
A funcionalidade de chamar guincho é uma funcionalidade "oca", pois ela não está de fato inclusa no projeto, seria somente um ponto de entrada para o serviço da Porto Seguro para requisitar um guincho.
