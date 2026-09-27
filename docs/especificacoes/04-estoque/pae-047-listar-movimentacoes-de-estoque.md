# [PAE-047] Listar movimentações de estoque

### **Descrição:**

Uma **listagem geral** das movimentações aplicadas no estoque (entradas e saídas), pra visão consolidada e auditoria do que de fato mudou o saldo.

### **Objetivo:**

Exibir as movimentações de estoque com filtros, ordenação e paginação no backend.

### **História:**

Como usuário do sistema,
Quero listar as movimentações de estoque,
Para acompanhar o que entrou e o que saiu.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem de movimentações de estoque.
2. A tabela exibe as colunas: produto, tipo (entrada/saída), quantidade, data e pedido de origem.
3. O usuário pode:
   - Filtrar por produto (busca parcial, ignorando maiúsculas e minúsculas), por tipo e por período.
   - Ordenar por produto, quantidade ou data (crescente/decrescente).
   - Escolher quantos itens exibir por página (10, 25, 50).
   - Navegar entre as páginas.
4. O sistema processa filtros, ordenações e paginação no backend.
5. Quando não houver movimentações, o sistema exibe a mensagem "Nenhum resultado encontrado".

### **Critérios de aceite:**

- A listagem é acessível a qualquer usuário autenticado.
- A tabela exibe produto, tipo (entrada/saída), quantidade, data e pedido de origem.
- É possível filtrar por produto (busca parcial, ignorando maiúsculas e minúsculas), por tipo e por período.
- É possível ordenar por produto, quantidade ou data, em ordem crescente ou decrescente.
- O usuário controla os itens por página (10, 25, 50) e navega entre as páginas.
- As datas e horários são exibidos no **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).
- Quando não houver resultados, o sistema exibe a mensagem "Nenhum resultado encontrado".
- Todos os filtros, ordenações e paginação são feitos no backend.
