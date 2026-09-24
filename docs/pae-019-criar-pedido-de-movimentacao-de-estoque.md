# [PAE-019] Criar pedido de movimentação de estoque

- **Área:** ESTOQUE
- **Lista:** Backlog
- **Trello:** https://trello.com/c/gvLzWOA2/18-pae-019-criar-pedido-de-movimenta%C3%A7%C3%A3o-de-estoque

---

### **Descrição:**

Movimentações no estoque devem passar por um processo de requisição e aprovação. O primeiro passo é permitir que usuários solicitem alterações no estoque indicando o produto, a quantidade e a razão da movimentação.

### **Objetivo:**

Registrar pedidos de movimentação de produtos no estoque, com status inicial controlado, para posterior verificação e aprovação.

### **História:**

Como usuário do sistema,
Quero criar um pedido de movimentação de estoque com quantidade, produto e razão,
Para registrar a solicitação de adição ou remoção de itens.

### **Fluxo principal:**

1. Usuário acessa a tela de nova movimentação.
2. Preenche os campos obrigatórios:
   - Tipo da movimentação: adição ou remoção.
   - Produto relacionado.
   - Quantidade.
   - Razão da movimentação (texto livre).
3. Submete o pedido.
4. O sistema salva com status inicial: **"Requisitado"**.
5. O pedido fica disponível para análise posterior.

### **Critérios de aceite:**

- O usuário pode criar uma movimentação do tipo **adição** ou **remoção**.
- Os campos obrigatórios são: tipo, produto, quantidade e razão.
- Quantidade deve ser numérica e positiva.
- O sistema salva a movimentação com status `"Em Preparação"` ao criar.
- O pedido é persistido com referência ao usuário que criou e à data/hora.
- O pedido fica disponível para o fluxo de verificação futura.
