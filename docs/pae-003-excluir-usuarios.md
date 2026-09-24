# [PAE-003] Excluir usuários

- **Área:** USUÁRIOS
- **Lista:** Backlog
- **Trello:** https://trello.com/c/9CkdC2Ue/9-pae-003-excluir-usu%C3%A1rios

---

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
3. O sistema exibe confirmação:
   **"Tem certeza que deseja excluir este usuário? Esta ação não pode ser desfeita."**
4. Se confirmado:
   - O sistema verifica se o usuário está em uso (ex.: atribuído a tarefas, sessões ativas, etc).
   - Se estiver em uso, bloqueia a exclusão e informa o motivo.
   - Se não estiver, exclui o usuário do banco.
5. Atualiza a listagem refletindo a exclusão.

### **Critérios de aceite:**

- Exclusão é individual, sem opção de múltiplas seleções.
- O sistema exige confirmação antes da exclusão.
- Impede a exclusão se o usuário estiver vinculado a qualquer entidade ou processo.
- Exibe mensagem clara ao bloquear exclusão.
- Remove o usuário corretamente quando permitido.
- Atualiza a listagem imediatamente após exclusão.
