# [PAE-003] Excluir usuários

### **Descrição:**

Excluir usuários deve ser controlado para evitar problemas de integridade e segurança, impedindo a remoção de usuários que estejam vinculados a registros ou processos ativos.

### **Objetivo:**

Permitir que o administrador exclua usuários que não estejam em uso, garantindo a segurança e integridade do sistema.

### **História:**

Como administrador do sistema,
Quero excluir usuários que não estão em uso,
Para manter o cadastro limpo sem comprometer dados ou processos vinculados.

### **Fluxo principal:**

1. Administrador acessa a listagem de usuários.
2. Clica para excluir um usuário individualmente.
3. O sistema exibe confirmação e exige informar a razão da exclusão (3 a 500 caracteres):
   **"Tem certeza que deseja excluir este usuário? Esta ação não pode ser desfeita."**
4. Se confirmado:
   - O sistema verifica se o usuário está em uso (ex.: criador de pedidos de movimentação, responsável por verificação ou por agendamento).
   - Se estiver em uso, bloqueia a exclusão com a mensagem "Não é possível excluir: o usuário está em uso".
   - Se não estiver, exclui o usuário do banco e registra a exclusão no histórico de alterações ([PAE-006]), incluindo a razão informada.
5. Atualiza a listagem refletindo a exclusão.

### **Critérios de aceite:**

- Exclusão é individual, sem opção de múltiplas seleções.
- O sistema exige confirmação antes da exclusão.
- Impede a exclusão se o usuário estiver vinculado a qualquer entidade ou processo.
- Exibe a mensagem "Não é possível excluir: o usuário está em uso" ao bloquear a exclusão.
- Remove o usuário corretamente quando permitido.
- A exclusão gera um registro no histórico de alterações ([PAE-006]).
- A razão da exclusão é obrigatória (3 a 500 caracteres) e fica registrada no histórico.
- Atualiza a listagem imediatamente após exclusão.
