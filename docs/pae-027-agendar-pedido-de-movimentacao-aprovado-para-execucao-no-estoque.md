# [PAE-027] Agendar pedido de movimentação aprovado para execução no estoque

- **Área:** AGENDAMENTO
- **Lista:** Backlog
- **Trello:** https://trello.com/c/DhXMrtdZ/28-pae-027-agendar-pedido-de-movimenta%C3%A7%C3%A3o-aprovado-para-execu%C3%A7%C3%A3o-no-estoque

---

### Descrição:

Após a aprovação de um pedido de movimentação, o criador do pedido pode agendá-lo para execução respeitando as regras configuráveis do sistema, que definem a janela de horário permitida, os dias da semana em que agendamento é possível e a capacidade por horário. (até 15 dias do dia atual para frente)

### Objetivo:

Permitir que o usuário agende a execução do pedido aprovado dentro das janelas e dias permitidos, respeitando a configuração e garantindo o controle da capacidade por horário.

### História:

Como criador de um pedido aprovado,
Quero agendar a execução do meu pedido em um horário e dia permitido,
Para que ele seja executado no estoque dentro das regras definidas pelo sistema.

‌

### Fluxo principal:

1. Usuário acessa a tela de agendamento para um pedido com status `"Aprovado"`.
2. O sistema verifica a configuração vigente para:
   - Janela de horário permitida (ex: 20h às 4h).
   - Dias da semana permitidos para agendamento.
3. O sistema consulta e exibe os horários disponíveis dentro das regras acima, com o número de vagas restantes por hora.
4. O usuário escolhe um horário e dia disponível.
5. O sistema verifica se o horário ainda tem vagas (limitadas e configuradas pelo administrador).
6. Se disponível, o pedido é agendado para o horário escolhido.
7. O status do pedido muda para `"Agendado"`.
8. O sistema registra o horário, data, usuário e pedido.
9. Caso o horário esteja cheio ou fora das regras, o sistema rejeita e informa o usuário.

### Critérios de aceite:

- Apenas pedidos com status `"Aprovado"` podem ser agendados.
- Apenas o usuário criador do pedido pode agendar.
- O sistema aplica as configurações de janela de horário e dias permitidos.
- O sistema permite apenas agendar pedidos nos proxímos 15 dias, a partir do dia atual.
- O sistema não permite agendar pedidos para a janela vigente. (caso o usuário esteja dentro de uma janela de agendamentos)
- O sistema exibe corretamente horários disponíveis e vagas restantes.
- O sistema rejeita agendamentos fora da janela, dias não permitidos ou limite excedido.
- O status do pedido muda para `"Agendado"` após o agendamento.
- Registro completo do agendamento com data/hora, usuário e pedido.
- Nenhum pedido pode ser agendado duas vezes.
- Erros de concorrência são tratados no backend para evitar overbooking.
