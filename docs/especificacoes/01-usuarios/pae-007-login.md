# [PAE-007] Login

### **Descrição:**

Usuários precisam acessar o sistema de forma segura, com validação de credenciais.

### **Objetivo:**

Garantir que apenas usuários válidos possam entrar no sistema.

### **História:**

Como usuário do sistema,
Quero realizar login com username e senha,
Para acessar minhas funcionalidades de forma segura.

### **Fluxo principal:**

1. Usuário acessa a tela de login.
2. Informa `username` e `senha`.
3. O sistema valida as credenciais.
4. Se inválidas, incrementa o contador de tentativas, exibe "usuário ou senha inválidos" e, ao atingir o limite definido por variável de ambiente, muda o status do usuário para bloqueado.
5. Se válidas, o sistema verifica o estado da conta:
   - Ativo: zera o contador de tentativas e concede acesso; se o usuário está marcado para trocar senha no primeiro login, redireciona para a tela de alteração de senha.
   - Inativo: exibe "conta inativa, contate o administrador".
   - Bloqueado: exibe "conta bloqueada por excesso de tentativas, contate o administrador".
6. Usuário pode sair da sessão ao final.

### **Critérios de aceite:**

- O sistema valida username e senha corretamente.
- Senhas são armazenadas de forma segura (hash).
- Usuários inativos não podem realizar login.
- O limite de tentativas de login é definido por variável de ambiente.
- Ao atingir o limite de tentativas, o usuário passa ao status bloqueado.
- O contador de tentativas é zerado após um login bem-sucedido.
- Usuário bloqueado não pode realizar login e só é desbloqueado por ação do administrador.
- O estado da conta (ativo, inativo ou bloqueado) só é revelado após a validação das credenciais.
- Mensagens exibidas:
   - credenciais inválidas: "usuário ou senha inválidos";
   - conta inativa: "conta inativa, contate o administrador";
   - conta bloqueada: "conta bloqueada por excesso de tentativas, contate o administrador".
- Sessão do usuário é criada e encerrada corretamente.
