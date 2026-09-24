# [PAE-021] Visualizar e editar pedido de movimentação de estoque

- **Área:** ESTOQUE
- **Lista:** Backlog
- **Trello:** https://trello.com/c/SB5GQUIa/22-pae-021-visualizar-e-editar-pedido-de-movimenta%C3%A7%C3%A3o-de-estoque

---

### **Descrição:**

Pedidos de movimentação de estoque devem ter uma tela de detalhes para visualização completa. Enquanto estiverem no status `"Em Preparação"`, podem ser editados exclusivamente pelo criador do pedido.

### **Objetivo:**

Permitir que o criador de um pedido edite suas informações enquanto o pedido estiver em preparação, e que demais usuários possam apenas visualizar os detalhes em modo somente leitura.

### **História:**

Como criador de um pedido de movimentação,
Quero acessar a tela de detalhes e poder editar enquanto estiver em preparação,
Para ajustar qualquer dado antes de enviar o pedido para verificação.

### **Fluxo principal:**

1. Usuário acessa a listagem de pedidos.
2. Clica em um pedido e é levado à tela de detalhes.
3. O sistema identifica se o pedido está em `"Em Preparação"` e se o usuário é o criador.
4. Se for o criador e o status for `"Em Preparação"`:
   - Os campos do pedido ficam editáveis:
     - Tipo (adição ou remoção)
     - Produto
     - Quantidade
     - Razão
   - Um botão permite salvar alterações.
5. Se não for o criador, ou o status não for `"Em Preparação"`:
   - Todos os campos são exibidos em modo somente leitura.
6. A tela também exibe quem criou, quando criou, e o status atual.

### **Critérios de aceite:**

- A tela de detalhes está acessível a todos os usuários autenticados.
- O criador do pedido pode editar o pedido **somente** se o status for `"Em Preparação"`.
- Outros usuários veem os dados em modo somente leitura, independentemente do status.
- Os campos editáveis são os mesmos do momento da criação: tipo, produto, quantidade e razão.
- O sistema salva corretamente as alterações feitas pelo criador enquanto o pedido estiver em preparação.
