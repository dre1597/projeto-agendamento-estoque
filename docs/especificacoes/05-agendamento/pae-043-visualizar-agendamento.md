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

1. Usuário autenticado acessa a listagem de agendamentos ([PAE-029]).
2. Seleciona um agendamento e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: `código` do agendamento, `código` do pedido, produto, quantidade, status do pedido, agendado para (data e hora), agendado por e data do agendamento.
4. A tela exibe a **trilha do fluxo do pedido**, com o **estado atual em destaque** e os ramos, visível a **todos** os usuários.
5. A tela dá acesso ao histórico do agendamento ([PAE-041]).
6. A tela oferece as ações cabíveis conforme o status e a permissão (ex.: cancelar agendamento [PAE-031] e registrar execução [PAE-026]/[PAE-030]).

### **Critérios de aceite:**

- A tela de detalhes é acessível a qualquer usuário autenticado.
- Os dados são exibidos em modo somente leitura.
- A tela exibe `código` do agendamento, `código` do pedido, produto, quantidade, status do pedido, agendado para, agendado por e data do agendamento.
- As datas e horários são exibidos no **horário do sistema** ([PAE-045]).
- A tela exibe a **trilha do fluxo do pedido** com o **estado atual destacado**, visível a todos os usuários (independentemente de permissão).
- A tela dá acesso ao histórico do agendamento ([PAE-041]).
- As ações disponíveis aparecem apenas quando o status e a permissão permitirem.
