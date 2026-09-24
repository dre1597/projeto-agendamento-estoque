# [PAE-023] Requisitar um pedido

### **Descrição:**

A submissão de um pedido de movimentação para o fluxo de verificação começa com o envio do pedido do status `"Em Preparação"` para `"Requisitado"`. Essa ação deve ser feita conscientemente, apenas pelo criador.

### **Objetivo:**

Permitir que o criador de um pedido finalize a preparação e envie a solicitação para o fluxo de validação, sinalizando que está pronto para ser avaliado.

### **História:**

Como criador de um pedido de movimentação,
Quero enviar o pedido para o status “Requisitado”,
Para iniciar o processo de verificação e aprovação da movimentação.

### **Fluxo principal:**

1. Usuário acessa a tela de detalhes do pedido.
2. Se o status atual for `"Em Preparação"` e o usuário for o criador:
   - Um botão é exibido: **“Enviar para requisição”**.
   - Ao clicar, o sistema exibe uma confirmação:
     **"Deseja enviar este pedido para requisição? Após isso, não será mais possível editar."**
   - Confirmando:
     - O status do pedido é alterado para `"Requisitado"`.
     - A data/hora da submissão é registrada.
     - As edições passam a ser bloqueadas.
3. Se o usuário não for o criador ou o status não for `"Em Preparação"`:
   - O botão não é exibido.

### **Critérios de aceite:**

- O botão “Enviar para requisição” aparece apenas para o criador e se o status for `"Em Preparação"`.
- O sistema exige confirmação antes de alterar o status.
- Ao confirmar, o status do pedido muda para `"Requisitado"` e bloqueia edições.
- Após o envio, o pedido aparece na listagem com o novo status.
- O sistema impede que qualquer outro usuário ou status realize essa ação.
