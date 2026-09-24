# [PAE-030] Tentativa de execução do pedido

- **Área:** AGENDAMENTO
- **Lista:** Backlog
- **Trello:** https://trello.com/c/RF6wm5q6/31-pae-030-tentativa-de-execu%C3%A7%C3%A3o-do-pedido

---

**Descrição:**
Após a tentativa de executar um pedido agendado, o administrador deve registrar o resultado da operação, escolhendo entre:

- **Executado**: operação concluída com sucesso (status final).
- **Não realizado**: operação não concluída, pedido volta para status **Pendente** para possível reagendamento.
- **Execução negada**: operação recusada, pedido vai para status **Negado**, encerrando o fluxo.


**Objetivo:**
Permitir que o administrador controle o resultado da execução do pedido, garantindo que pedidos não realizados possam ser reagendados e pedidos negados sejam finalizados.

**História:**
Como administrador do sistema,
Quero marcar um pedido agendado como “Executado”, “Não realizado” ou “Execução negada”,
Para indicar o resultado da operação e controlar o fluxo conforme o resultado.

**Fluxo principal:**

1. Administrador acessa a tela de detalhes do pedido com status “Agendado”.
2. Sistema exibe os botões:
   - “Marcar como Executado”
   - “Marcar como Não realizado”
   - “Marcar como Execução negada”
3. Administrador escolhe uma opção e confirma a ação.
4. Sistema atualiza o status do pedido conforme a escolha:
   - Executado → status final, bloqueado para alterações.
   - Não realizado → volta para status **Pendente**, liberando reagendamento.
   - Execução negada → status **Negado**, encerrando o fluxo.
5. Sistema registra data, hora, usuário e ação realizada.


**Critérios de aceite:**

- Botões aparecem somente para pedidos no status “Agendado”.
- Apenas administradores podem executar essas ações.
- Sistema exige confirmação antes de mudar status.
- Status atualizado corretamente e registro salvo no histórico.
- Pedido marcado como Executado fica finalizado, sem alterações.
- Pedido marcado como Não realizado volta para Pendente para reagendamento.
- Pedido marcado como Execução negada vai para status Negado e fica finalizado.
