# [PAE-029] Listar agendamentos de execução de pedidos de movimentação

### Descrição:

A listagem de agendamentos deve permitir que usuários monitorem os agendamentos feitos para execução dos pedidos aprovados, facilitando a gestão e o acompanhamento dos horários agendados, quem agendou e o status do pedido.

### Objetivo:

Exibir todos os agendamentos realizados com filtros, ordenação e paginação processados no backend para garantir performance e controle.

### História:

Como usuário do sistema,
Quero filtrar, ordenar e navegar pelos agendamentos dos pedidos de movimentação,
Para acompanhar os agendamentos feitos e gerenciar os horários disponíveis.

### Fluxo principal:

1. Usuário acessa a tela de listagem de agendamentos.
2. A tabela exibe as colunas: pedido, produto, quantidade, status do pedido, **agendado para (data e hora da execução real no estoque)**, agendado por (usuário), **data do agendamento (quando o usuário fez o agendamento)**.
3. O usuário pode:

- Filtrar por:
  - Produto
  - Status do pedido (Aprovado, Agendado, etc)
  - Usuário que agendou
  - Período da data do agendamento (ex: entre 01/06/2025 e 10/06/2025)
- Ordenar por:
  - Nome do produto
  - Quantidade
  - Data do agendamento
  - Data de criação do pedido
- Definir quantos itens quer ver por página (10, 25, 50)
- Navegar entre páginas

1. O sistema processa todos os filtros, ordenações e paginação no backend.
2. A listagem atualiza dinamicamente conforme o usuário interage.

### Critérios de aceite:

- A tabela inclui colunas: pedido, produto, quantidade, status do pedido, agendado para, agendado por, data do agendamento.
- É possível filtrar por produto, status do pedido, usuário que agendou e período da data do agendamento.
- É possível ordenar por nome do produto, quantidade, data do agendamento e data de criação do pedido.
- O sistema permite escolher itens por página e navegar entre páginas.
- Todos os filtros, ordenações e paginação são feitos no backend.
- A experiência é responsiva e atualiza os dados sem necessidade de reload completo da página.
