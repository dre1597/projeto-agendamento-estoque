# [PAE-043] Visualizar agendamento

### **Descrição:**

Tela de detalhes do agendamento, em modo somente leitura, com as informações, a trilha do pedido e o histórico do agendamento.

### **Objetivo:**

Permitir que o usuário consulte os detalhes de um agendamento.

### **História:**

Como usuário do sistema,
Quero visualizar os detalhes de um agendamento,
Para consultar suas informações e o histórico.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem de agendamentos ([PAE-029](pae-029-listar-agendamentos-de-execucao-de-pedidos-de-movimentacao.md)).
2. Seleciona um agendamento e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: `código` do agendamento, `código` do pedido, produto, quantidade, status do pedido, agendado para (data e hora), agendado por e data do agendamento.
4. A tela exibe a **trilha do fluxo do pedido**, com o **estado atual em destaque** e os ramos, visível a **todos** os usuários.
5. A tela dá acesso ao histórico do agendamento ([PAE-041](pae-041-rastrear-historico-do-agendamento.md)).
6. A tela oferece as ações cabíveis conforme o status e a permissão (ex.: cancelar agendamento [PAE-031](pae-031-cancelar-agendamento-de-pedido-de-movimentacao-de-estoque.md) e registrar execução [PAE-026](../04-estoque/pae-026-marcar-pedido-de-movimentacao-como-executado.md)/[PAE-030](pae-030-registrar-execucao-nao-realizada-do-pedido.md)).

### **Critérios de aceite:**

- A tela de detalhes é acessível a qualquer usuário autenticado.
- Os dados são exibidos em modo somente leitura.
- A tela exibe `código` do agendamento, `código` do pedido, produto, quantidade, status do pedido, agendado para, agendado por e data do agendamento.
- As datas e horários são exibidos no **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).
- A tela exibe a **trilha do fluxo do pedido** com o **estado atual destacado**, visível a todos os usuários (independentemente de permissão).
- A tela dá acesso ao histórico do agendamento ([PAE-041](pae-041-rastrear-historico-do-agendamento.md)).
- As ações disponíveis aparecem apenas quando o status e a permissão permitirem.
