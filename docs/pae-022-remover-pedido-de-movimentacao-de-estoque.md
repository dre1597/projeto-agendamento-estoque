# [PAE-022] Remover pedido de movimentação de estoque

- **Área:** ESTOQUE
- **Lista:** Backlog
- **Trello:** https://trello.com/c/xWNYir4L/23-pae-022-remover-pedido-de-movimenta%C3%A7%C3%A3o-de-estoque

---

### **Descrição:**

Pedidos de movimentação podem ser removidos apenas enquanto estiverem em preparação e não tiverem iniciado o fluxo de aprovação. Isso garante flexibilidade durante a criação, mas bloqueia alterações destrutivas após o envio.

### **Objetivo:**

Permitir que o criador exclua um pedido de movimentação antes de submetê-lo para validação, evitando a existência de pedidos incorretos ou descartados.

### **História:**

Como criador de um pedido de movimentação,
Quero poder excluir meu pedido enquanto ele estiver em preparação,
Para corrigir erros ou remover pedidos indevidos antes de submetê-los.

### **Fluxo principal:**

1. Usuário acessa a listagem ou os detalhes do pedido.
2. Se o pedido estiver com status `"Em Preparação"` **e** nunca tiver sido alterado para outro status:
   - O botão de exclusão é exibido.
   - Ao clicar, o sistema exibe a confirmação:
     **"Tem certeza que deseja excluir este pedido? Esta ação não pode ser desfeita."**
   - Confirmando, o pedido é removido.
3. Se o pedido já tiver sido enviado (status diferente de `"Em Preparação"` em algum momento):
   - O botão de exclusão não aparece.
   - Nenhuma ação de exclusão é permitida, mesmo se tiver voltado ao status de preparação.

### **Critérios de aceite:**

- Apenas o criador do pedido pode ver e usar o botão de exclusão.
- A exclusão só é permitida se o status atual for `"Em Preparação"` **e** o pedido nunca tiver sido movido para outro status.
- O sistema exibe confirmação antes de excluir.
- Após a exclusão, o pedido desaparece da listagem.
- O sistema bloqueia qualquer tentativa forçada de excluir pedidos fora dessa regra.
