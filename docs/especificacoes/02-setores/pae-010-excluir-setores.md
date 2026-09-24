# [PAE-010] Excluir setores

### **Descrição:**

Setores são categorias internas usadas para organizar fornecedores e produtos. Sua exclusão deve ser controlada para evitar perda de integridade nas informações do sistema.

### **Objetivo:**

Permitir que o administrador exclua setores não utilizados, com confirmação explícita e bloqueio em caso de vínculo com outras entidades.

### **História:**

Como administrador do sistema,
Quero excluir um setor que não está em uso,
Para manter a base limpa e organizada sem impactar outras partes do sistema.

### **Fluxo principal:**

1. Usuário acessa a listagem de setores.
2. Clica para excluir um setor individual.
3. Sistema exibe uma confirmação: "Tem certeza que deseja excluir este setor? Esta ação não poderá ser desfeita."
4. Se confirmado:
   - O sistema verifica se o setor está em uso (relacionado a fornecedores, produtos, etc).
   - Se estiver em uso, bloqueia a exclusão e informa o motivo.
   - Se não estiver em uso, remove o setor do banco.

### **Critérios de aceite:**

- A exclusão é feita individualmente, sem opção de múltiplas seleções.
- O sistema solicita confirmação antes de excluir.
- Se o setor estiver relacionado a qualquer outra entidade, a exclusão é impedida com mensagem clara.
- Se o setor não estiver em uso, ele é removido da base.
- A listagem é atualizada automaticamente após exclusão bem-sucedida.
- A interface deve ser intuitiva e responsiva a diversos tipos de dispositivos.
