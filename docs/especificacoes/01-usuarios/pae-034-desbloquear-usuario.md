# [PAE-034] Desbloquear usuário

### **Descrição:**

Um usuário é bloqueado automaticamente ao atingir o limite de tentativas de login (ver [PAE-007]). Para devolver o acesso, o administrador precisa desbloqueá-lo.

### **Objetivo:**

Permitir que o administrador desbloqueie um usuário, devolvendo o acesso, com registro da razão.

### **História:**

Como administrador do sistema,
Quero desbloquear um usuário bloqueado,
Para devolver o acesso a ele.

### **Fluxo principal:**

1. Administrador acessa a listagem de usuários ou os detalhes de um usuário.
2. Para um usuário com status bloqueado, é exibida a opção "Desbloquear".
3. O sistema exibe confirmação e exige informar a razão do desbloqueio (3 a 500 caracteres).
4. Confirmado:
   - O status do usuário volta para ativo.
   - O contador de tentativas de login é zerado.
   - A ação é registrada no histórico ([PAE-006]), incluindo a razão.
5. A listagem ou os detalhes refletem o novo status.

### **Critérios de aceite:**

- A opção de desbloquear está disponível na listagem e nos detalhes do usuário.
- Apenas administradores podem desbloquear.
- A opção aparece somente para usuários com status bloqueado.
- A ação exige confirmação antes de ser aplicada.
- A razão do desbloqueio é obrigatória (3 a 500 caracteres).
- Ao desbloquear, o status do usuário volta para ativo.
- Ao desbloquear, o contador de tentativas de login é zerado.
- A ação gera um registro no histórico de alterações ([PAE-006]), incluindo a razão.
- O novo status é refletido imediatamente na listagem e nos detalhes.
