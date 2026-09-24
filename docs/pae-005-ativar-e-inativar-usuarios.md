# [PAE-005] Ativar e inativar usuários

- **Área:** USUÁRIOS
- **Lista:** Backlog
- **Trello:** https://trello.com/c/iAhWGVQw/10-pae-005-ativar-e-inativar-usu%C3%A1rios

---

### **Descrição:**

O sistema precisa controlar o acesso dos usuários sem removê-los do banco, permitindo ativar ou inativar contas conforme a necessidade administrativa.

### **Objetivo:**

Permitir que o administrador controle se um usuário está ativo (pode acessar o sistema) ou inativo (bloqueado, sem acesso), sem excluí-lo.

### **História:**

Como administrador do sistema,
Quero ativar ou inativar usuários,
Para gerenciar o acesso sem perder o histórico de cadastro.

### **Fluxo principal:**

1. Administrador acessa a listagem de usuários.
2. Para cada usuário, existe a opção de ativar ou inativar.
3. Ao clicar na opção, o sistema exibe confirmação:
   **"Tem certeza que deseja [ativar/inativar] este usuário?"**
4. Após confirmação, o sistema atualiza o status.
5. Usuários inativos ficam bloqueados para acesso ao sistema, mas permanecem listados.

### **Critérios de aceite:**

- A listagem exibe todos os usuários, ativos e inativos.
- É possível ativar ou inativar um usuário individualmente.
- A ação exige confirmação antes de ser aplicada.
- Usuários inativos não podem fazer login.
- O status é refletido imediatamente na listagem após a alteração.
- O sistema previne ações repetidas desnecessárias (ex: inativar usuário já inativo).
