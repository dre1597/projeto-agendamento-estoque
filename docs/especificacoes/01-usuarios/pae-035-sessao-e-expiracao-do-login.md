# [PAE-035] Sessão e expiração do login

### **Descrição:**

A sessão é criada no login e precisa expirar em algum momento para limitar o acesso. Também deve ser possível encerrá-la no logout e quando o usuário é inativado ou bloqueado.

### **Objetivo:**

Definir o ciclo de vida da sessão: criação no login, expiração por tempo fixo, encerramento no logout e revogação imediata quando o usuário é inativado ou bloqueado.

### **História:**

Como usuário do sistema,
Quero que minha sessão tenha validade limitada e possa ser encerrada,
Para que o acesso não fique válido indefinidamente.

### **Fluxo principal:**

1. No login, o sistema cria a sessão como um token JWT com expiração de tempo fixo, definida por variável de ambiente.
2. Enquanto a sessão for válida, o usuário acessa o sistema normalmente.
3. Quando a sessão expira, o usuário é levado de volta à tela de login e precisa autenticar de novo.
4. No logout, o sistema encerra a sessão.
5. Ao inativar ou bloquear um usuário, o sistema encerra imediatamente as sessões ativas dele.
6. Requisições com sessão expirada ou encerrada são rejeitadas.

### **Critérios de aceite:**

- A sessão é criada no login como um token JWT com expiração de tempo fixo, definida por variável de ambiente.
- Sessão expirada não atribui acesso: o usuário volta à tela de login.
- O logout encerra a sessão do usuário.
- Ao inativar um usuário, suas sessões ativas são encerradas imediatamente.
- Ao bloquear um usuário, suas sessões ativas são encerradas imediatamente.
- Requisições com sessão expirada ou encerrada são rejeitadas.
