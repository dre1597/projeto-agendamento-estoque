# [PAE-025]  Avaliar pedido de movimentação: Aprovar, Rejeitar ou Ajustar

- **Área:** ESTOQUE
- **Lista:** Backlog
- **Trello:** https://trello.com/c/KACmIEa6/26-pae-025-avaliar-pedido-de-movimenta%C3%A7%C3%A3o-aprovar-rejeitar-ou-ajustar

---

### **Descrição:**

Após a análise de um pedido em verificação, o administrador pode aprová-lo, rejeitá-lo ou, caso encontre necessidade de correção, devolvê-lo ao estado de preparação para que o criador ajuste as informações.

### **Objetivo:**

Dar ao administrador três opções claras ao finalizar a análise de um pedido: aprovar, rejeitar ou devolver para ajustes, mantendo controle total do fluxo e garantindo rastreabilidade das decisões.

### **História:**

Como administrador do sistema,
Quero aprovar, rejeitar ou devolver pedidos em verificação,
Para concluir a análise ou solicitar ajustes antes da decisão final.

### **Fluxo principal:**

1. Administrador acessa a tela de detalhes de um pedido com status `"Em Verificação"`.
2. Três botões são exibidos:
   - **Aprovar pedido**
   - **Rejeitar pedido**
   - **Devolver para ajuste**
3. Para cada ação:
   - O sistema solicita confirmação com mensagem clara.
   - A ação é registrada com data/hora e quem realizou.
   - O status do pedido é alterado conforme a ação:
     - **Aprovado:** segue o fluxo para execução.
     - **Rejeitado:** o pedido é encerrado como inválido.
     - **Devolver para ajuste:** o status volta para `"Em Preparação"`, mas **o pedido não poderá ser deletado** mais, mesmo nesse estado.

### **Critérios de aceite:**

- Apenas administradores visualizam os três botões na tela de detalhes quando o pedido estiver em `"Em Verificação"`.
- Cada ação exige confirmação explícita antes de ser realizada.
- A ação executada é registrada com timestamp e usuário responsável.
- “Devolver para ajuste” volta o pedido para `"Em Preparação"`, mas bloqueia exclusão mesmo sendo esse o status atual.
- “Aprovar” altera o status para `"Aprovado"` e bloqueia edições/exclusão.
- “Rejeitar” altera o status para `"Rejeitado"` e bloqueia edições/exclusão.
- O status atual é refletido corretamente na listagem e detalhes.
- Nenhuma dessas ações pode ser realizada fora do status `"Em Verificação"`.
