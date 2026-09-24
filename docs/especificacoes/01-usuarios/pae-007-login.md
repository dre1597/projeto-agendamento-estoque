# [PAE-007] Login

### **Descrição:**

Usuários precisam acessar o sistema de forma segura, com validação de credenciais e controle para troca obrigatória de senha no primeiro acesso.

### **Objetivo:**

Garantir que apenas usuários válidos possam entrar no sistema e forçar troca de senha quando configurado.

### **História:**

Como usuário do sistema,
Quero realizar login com username e senha,
Para acessar minhas funcionalidades de forma segura.

### **Fluxo principal:**

1. Usuário acessa a tela de login.
2. Informa `username` e `senha`.
3. O sistema valida as credenciais.
4. Se inválidas, exibe mensagem de erro.
5. Se válidas:
   - Se o usuário está marcado para trocar senha no primeiro login, redireciona para a tela de alteração de senha.
   - Caso contrário, concede acesso ao sistema normalmente.
6. Usuário pode sair da sessão ao final.

### **Critérios de aceite:**

- O sistema valida username e senha corretamente.
- Senhas são armazenadas de forma segura (hash).
- Usuários inativos não podem realizar login.
- Se a flag de troca de senha no primeiro login estiver ativa, usuário é forçado a alterar a senha antes de prosseguir.
- Mensagens de erro são claras e não expõem detalhes sensíveis.
- Sessão do usuário é criada e encerrada corretamente.
