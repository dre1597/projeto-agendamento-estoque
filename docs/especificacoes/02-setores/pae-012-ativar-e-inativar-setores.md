# [PAE-012] Ativar e inativar setores

### **Descrição:**

Nem sempre é possível excluir um setor do sistema, principalmente quando ele já está vinculado a outros dados. Para isso, o sistema deve permitir ativar ou inativar setores sem removê-los da base, apenas controlando seu uso.

### **Objetivo:**

Permitir que o administrador inative setores que não devem mais ser usados em novos cadastros, mas que precisam continuar existindo por já estarem associados a entidades no sistema.

### **História:**

Como administrador do sistema,
Quero ativar ou inativar setores,
Para impedir o uso de setores obsoletos sem precisar excluí-los quando ainda estão em uso.

### **Fluxo principal:**

1. Administrador acessa a listagem de setores.
2. Para cada setor listado, existe a opção de ativar ou inativar.
3. Ao clicar em "Inativar" ou "Ativar", o sistema exibe uma confirmação:
   **"Tem certeza que deseja [inativar/ativar] este setor?"**
   - Ao **inativar** um setor que possui produtos relacionados, a confirmação muda para alertar o usuário, informando quantos produtos e mostrando pelo menos um exemplo: **"Este setor está relacionado a [N] produtos (ex.: [produto]). Deseja inativar mesmo assim?"**
4. Após confirmação:
   - O sistema atualiza o status do setor.
   - Registra a alteração no histórico de alterações do setor ([PAE-013]).
   - A ação é refletida imediatamente na listagem.

### **Critérios de aceite:**

- A listagem de setores exibe todos os setores, ativos e inativos.
- É possível inativar ou ativar um setor individualmente através da listagem.
- A ação só pode ser feita por administradores.
- Ao acionar a ação, o sistema exibe uma confirmação antes de executar.
- Setores inativos não podem ser selecionados em novos cadastros de produtos, mas vínculos já existentes são mantidos.
- Ao inativar um setor com produtos relacionados, o sistema alerta o usuário (quantidade e um produto de exemplo), mas permite a inativação se ele confirmar.
- O status atualizado do setor (ativo/inativo) é refletido imediatamente na listagem.
- A ativação/inativação gera um registro no histórico de alterações do setor ([PAE-013]).
- O sistema impede que a mesma ação seja executada duas vezes seguidas (ex.: inativar um setor já inativo).
