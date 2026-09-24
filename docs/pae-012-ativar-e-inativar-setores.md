# [PAE-012] Ativar e inativar setores

- **Área:** SETORES
- **Lista:** Backlog
- **Trello:** https://trello.com/c/xgd7vwxf/6-pae-012-ativar-e-inativar-setores

---

### **Descrição:**

Nem sempre é possível excluir um setor do sistema, principalmente quando ele já está vinculado a outros dados. Para isso, o sistema deve permitir ativar ou inativar setores sem removê-los da base, apenas controlando seu uso.

### **Objetivo:**

Permitir que o administrador inative setores que não devem mais ser usados em novos cadastros, mas que precisam continuar existindo por já estarem associados a entidades no sistema.

### **História:**

Como administrador do sistema,
Quero ativar ou inativar setores,
Para impedir o uso de setores obsoletos sem precisar excluí-los quando ainda estão em uso.

### **Fluxo principal:**

1. Usuário acessa a listagem de setores.
2. Para cada setor listado, existe a opção de ativar ou inativar.
3. Ao clicar em "Inativar" ou "Ativar", o sistema exibe uma confirmação:
   "Tem certeza que deseja [inativar/ativar] este setor?"
4. Após confirmação:
   - O sistema atualiza o status do setor.
   - A ação é refletida imediatamente na listagem.

### **Critérios de aceite:**

- A listagem de setores exibe todos os setores, ativos e inativos.
- É possível inativar ou ativar um setor individualmente através da listagem.
- Ao acionar a ação, o sistema exibe uma confirmação antes de executar.
- Setores inativos não podem ser selecionados em novos cadastros de outras entidades.
- O status atualizado do setor (ativo/inativo) é refletido imediatamente na listagem.
- O sistema impede que a mesma ação seja executada duas vezes seguidas (ex: inativar um setor já inativo).
