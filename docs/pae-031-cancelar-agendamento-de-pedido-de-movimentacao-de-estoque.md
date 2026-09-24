# [PAE-031] Cancelar agendamento de pedido de movimentação de estoque

- **Área:** AGENDAMENTO
- **Lista:** Backlog
- **Trello:** https://trello.com/c/TzERz9ME/32-pae-031-cancelar-agendamento-de-pedido-de-movimenta%C3%A7%C3%A3o-de-estoque

---

**Descrição:**
Permitir que o criador do pedido cancele o agendamento para execução do pedido, retornando o status do pedido para **Pendente**, interrompendo o fluxo de execução agendada.

**Objetivo:**
Dar autonomia ao usuário para cancelar o agendamento do pedido, liberando a execução para um novo agendamento futuro.

**História:**
Como criador de um pedido agendado,
Quero cancelar o agendamento da execução,
Para poder reagendar ou manter o pedido pendente.

**Fluxo principal:**

1. Usuário acessa a tela de detalhes de um pedido com status **Agendado**.
2. O sistema exibe o botão “Cancelar agendamento”.
   **3. O sistema verifica se o pedido está agendado com pelo menos 1 dia de antecedência; se não, bloqueia a ação e informa o usuário.**
3. Usuário clica no botão e confirma a ação.
4. O sistema atualiza o status do pedido para **Pendente**.
5. O sistema registra data, hora, usuário e ação no histórico.
6. Pedido fica disponível para novo agendamento.

**Critérios de aceite:**

- Apenas pedidos com status **Agendado** podem ter o agendamento cancelado.
- Apenas o criador do pedido pode cancelar o agendamento.
- Não deve ser possível cancelar agendamentos que tenham menos de 1 dia de antecedência.
- O sistema exige confirmação antes de cancelar.
- O status do pedido muda para **Pendente** após o cancelamento.
- Histórico registra o cancelamento do agendamento.
- Pedido cancelado pode ser reagendado normalmente.
