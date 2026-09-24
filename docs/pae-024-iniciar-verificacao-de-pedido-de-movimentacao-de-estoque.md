# [PAE-024] Iniciar verificação de pedido de movimentação de estoque

- **Área:** ESTOQUE
- **Lista:** Backlog
- **Trello:** https://trello.com/c/Qax5v0gW/25-pae-024-iniciar-verifica%C3%A7%C3%A3o-de-pedido-de-movimenta%C3%A7%C3%A3o-de-estoque

---

### **Descrição:**

Para garantir que cada pedido passe por uma análise controlada, administradores devem poder mover pedidos com status `"Requisitado"` para o status `"Em Verificação"`, sinalizando que estão sob análise antes de uma decisão.

### **Objetivo:**

Permitir que um administrador sinalize que um pedido está sendo analisado, evitando sobreposição de revisões e garantindo rastreabilidade do processo de verificação.

### **História:**

Como administrador do sistema,
Quero mover um pedido de movimentação para o status “Em Verificação”,
Para indicar que estou analisando a solicitação antes de aprová-la ou rejeitá-la.

### **Fluxo principal:**

1. Administrador acessa a tela de detalhes de um pedido com status `"Requisitado"`.
2. Um botão é exibido: **“Iniciar verificação”**.
3. Ao clicar, o sistema exibe uma confirmação:
   **"Deseja iniciar a verificação deste pedido? Isso indicará que está sob análise."**
4. Confirmando:
   - O status é alterado para `"Em Verificação"`.
   - A data/hora da ação e o usuário responsável são registrados.
5. O sistema passa a exibir o responsável pela verificação no histórico ou visualização.

### **Critérios de aceite:**

- Apenas usuários com perfil de administrador veem o botão “Iniciar verificação”.
- O botão só aparece se o status atual do pedido for `"Requisitado"`.
- O sistema exige confirmação antes da alteração de status.
- Ao confirmar, o status muda para `"Em Verificação"` e registra quem iniciou a análise.
- Não é possível editar ou excluir o pedido após essa transição.
- O status atualizado aparece corretamente na listagem e tela de detalhes.
