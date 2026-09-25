# [PAE-017] Listar produtos

### **Descrição:**

A listagem de produtos precisa permitir navegação eficiente, com filtros úteis, ordenação dinâmica e controle de quantidade por página para facilitar a consulta e a gestão do estoque.

### **Objetivo:**

Permitir que usuários visualizem os produtos cadastrados de forma eficiente, com ferramentas para localizar rapidamente itens específicos.

### **História:**

Como usuário do sistema,
Quero visualizar a lista de produtos com filtros e ordenação,
Para encontrar e analisar facilmente os itens registrados.

### **Fluxo principal:**

1. Usuário autenticado acessa a tela de listagem de produtos.
2. A tabela exibe os produtos com as colunas `nome`, `quantidade atual`, `valor unitário` e `setores relacionados`.
3. O usuário pode:
   - Filtrar por `nome` (busca parcial, ignorando maiúsculas e minúsculas).
   - Filtrar por `setores relacionados` (um ou mais; retorna os produtos que tenham qualquer um dos setores selecionados, ativos ou inativos).
   - Ordenar por `nome`, `quantidade atual` ou `valor unitário` (crescente/decrescente).
   - Escolher quantos itens exibir por página (10, 25, 50).
   - Navegar entre as páginas.
4. O sistema retorna os dados paginados, filtrados e ordenados conforme a escolha do usuário.
5. Quando nenhum produto corresponder aos filtros, o sistema exibe a mensagem "Nenhum resultado encontrado".

### **Critérios de aceite:**

- A listagem é acessível a qualquer usuário autenticado.
- A listagem é paginada e o usuário controla os itens por página (10, 25, 50).
- A tabela exibe as colunas `nome`, `quantidade atual`, `valor unitário` e `setores relacionados`.
- É possível filtrar por `nome` (busca parcial, ignorando maiúsculas e minúsculas).
- É possível filtrar por `setores relacionados` (um ou mais; retorna os produtos que tenham qualquer um dos setores selecionados, ativos ou inativos).
- É possível ordenar por `nome`, `quantidade atual` ou `valor unitário`, em ordem crescente ou decrescente.
- A combinação de filtros, ordenação e paginação funciona de forma integrada.
- Quando não houver resultados, o sistema exibe a mensagem "Nenhum resultado encontrado".
- Toda a lógica de filtro, ordenação e paginação é executada no backend.
