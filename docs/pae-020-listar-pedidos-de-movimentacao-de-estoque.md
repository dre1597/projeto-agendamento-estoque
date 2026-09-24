# [PAE-020]  Listar pedidos de movimentação de estoque

- **Área:** ESTOQUE
- **Lista:** Backlog
- **Trello:** https://trello.com/c/RDylemtu/21-pae-020-listar-pedidos-de-movimenta%C3%A7%C3%A3o-de-estoque

---

### **Descrição:**

A listagem de movimentações precisa ser flexível para atender tanto usuários que analisam os pedidos quanto aqueles que apenas acompanham suas próprias solicitações. Filtros e ordenações adicionais permitem maior controle e usabilidade.

### **Objetivo:**

Exibir todos os pedidos de movimentação de estoque com filtros por status e produto, ordenação e paginação no backend.

### **História:**

Como usuário do sistema,
Quero filtrar e ordenar os pedidos de movimentação por produto, status, criador, quantidade e data,
Para encontrar facilmente os pedidos que me interessam e acompanhar o andamento das solicitações.

### **Fluxo principal:**

1. Usuário acessa a listagem de pedidos de movimentação.
2. A tabela exibe as colunas: tipo, produto, quantidade, status, criado por, data de criação.
3. O usuário pode:
   - Filtrar por:
     - Produto
     - Status (`Em preparação`, `Requisitado`, `Em Verificação`, `Aprovado`, `Rejeitado`, `Agendado`, `Pendente`, `Negado`,  `Executado`).
     - Quem criou
     - Mostrar apenas os pedidos que ele mesmo criou (checkbox)
   - Ordenar por:
     - Nome do produto
     - Quantidade
     - Data de criação
     - (ordem ascendente/descendente)
   - Definir quantos itens por página (10, 25, 50)
   - Navegar entre páginas
4. O sistema retorna os resultados aplicando os filtros, ordenações e paginação no backend.

### **Critérios de aceite:**

- A listagem inclui colunas de tipo, produto, quantidade, status, criador e data de criação.
- É possível filtrar por status, produto, criador e mostrar apenas os pedidos do usuário autenticado.
- É possível ordenar por nome do produto, quantidade ou data de criação.
- Todos os filtros, ordenações e paginação são processados no backend.
- A experiência da listagem é fluida e atualiza dinamicamente os dados conforme os filtros são aplicados.
