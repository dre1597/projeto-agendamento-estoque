# [PAE-029] Listar agendamentos de execução de pedidos de movimentação

### **Descrição:**

A listagem de agendamentos permite que os usuários monitorem os agendamentos feitos para execução dos pedidos aprovados ou pendentes, facilitando o acompanhamento dos horários, de quem agendou e do status do pedido.

### **Objetivo:**

Exibir todos os agendamentos realizados com filtros, ordenação e paginação processados no backend.

### **História:**

Como usuário do sistema,
Quero filtrar, ordenar e navegar pelos agendamentos dos pedidos de movimentação,
Para acompanhar os agendamentos feitos e gerenciar os horários disponíveis.

### **Fluxo principal:**

1. Usuário autenticado acessa a tela de listagem de agendamentos.
2. A tabela exibe as colunas: `código` do agendamento, `código` do pedido, produto, quantidade, status do pedido, agendado para (data e hora da execução no estoque), agendado por (usuário), data do agendamento (quando o usuário agendou) e data de criação do pedido.
3. O usuário pode:
   - Filtrar por produto (busca parcial, ignorando maiúsculas e minúsculas), por status do pedido (`Agendado`, `Executado`, `Pendente`, `Negado`), por usuário que agendou e por período da data do agendamento.
   - Ordenar por nome do produto, quantidade, data do agendamento ou data de criação do pedido (crescente/decrescente).
   - Escolher quantos itens exibir por página (10, 25, 50).
   - Navegar entre as páginas.
4. O sistema processa filtros, ordenações e paginação no backend.
5. Quando nenhum agendamento corresponder aos filtros, o sistema exibe a mensagem "Nenhum resultado encontrado".

### **Critérios de aceite:**

- A listagem é acessível a qualquer usuário autenticado.
- A tabela inclui as colunas `código` do agendamento, `código` do pedido, produto, quantidade, status do pedido, agendado para, agendado por, data do agendamento e data de criação do pedido.
- É possível filtrar por produto (busca parcial, ignorando maiúsculas e minúsculas), por status do pedido, por usuário que agendou e por período da data do agendamento.
- É possível ordenar por nome do produto, quantidade, data do agendamento e data de criação do pedido, em ordem crescente ou decrescente.
- O usuário controla os itens por página (10, 25, 50) e navega entre as páginas.
- Todas as datas e horários são exibidos no **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).
- Quando não houver resultados, o sistema exibe a mensagem "Nenhum resultado encontrado".
- Todos os filtros, ordenações e paginação são feitos no backend.
