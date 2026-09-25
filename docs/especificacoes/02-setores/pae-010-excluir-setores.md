# [PAE-010] Excluir setores

### **Descrição:**

Setores são categorias internas usadas para organizar produtos. Sua exclusão deve ser controlada para evitar perda de integridade nas informações do sistema.

### **Objetivo:**

Permitir que o administrador exclua setores não utilizados, com confirmação explícita e bloqueio em caso de vínculo com outras entidades.

### **História:**

Como administrador do sistema,
Quero excluir um setor que não está em uso,
Para manter a base limpa e organizada sem impactar outras partes do sistema.

### **Fluxo principal:**

1. Administrador acessa a listagem de setores.
2. Clica para excluir um setor individual.
3. O sistema exibe confirmação e exige informar a razão da exclusão (3 a 500 caracteres):
   **"Tem certeza que deseja excluir este setor? Esta ação não pode ser desfeita."**
4. Se confirmado:
   - O sistema verifica se o setor está em uso (relacionado a produtos).
   - Se estiver em uso, bloqueia a exclusão com a mensagem "Não é possível excluir: o setor está em uso".
   - Se não estiver, exclui o setor do banco e registra a exclusão no histórico de alterações ([PAE-013]), incluindo a razão informada.
5. Atualiza a listagem refletindo a exclusão.

### **Critérios de aceite:**

- Exclusão é individual, sem opção de múltiplas seleções.
- O sistema exige confirmação antes da exclusão.
- Impede a exclusão se o setor estiver vinculado a qualquer entidade.
- Exibe a mensagem "Não é possível excluir: o setor está em uso" ao bloquear a exclusão.
- Remove o setor corretamente quando permitido.
- A exclusão gera um registro no histórico de alterações ([PAE-013]).
- A razão da exclusão é obrigatória (3 a 500 caracteres) e fica registrada no histórico.
- A exclusão só pode ser feita por administradores.
- Atualiza a listagem imediatamente após a exclusão.
