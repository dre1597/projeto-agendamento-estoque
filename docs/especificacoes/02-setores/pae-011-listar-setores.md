# [PAE-011] Listar setores

### **Descrição:**

A listagem de setores deve oferecer uma visão organizada, com navegação fluida mesmo com grande volume de dados. O usuário deve ter controle sobre a quantidade de registros exibidos, ordenação e filtros básicos.

### **Objetivo:**

Fornecer uma visualização eficiente dos setores cadastrados, com ferramentas para localizar rapidamente informações específicas e evitar sobrecarga na interface.

### **História:**

Como administrador do sistema,
Quero visualizar os setores cadastrados com paginação, ordenação, filtros e controle de itens por página,
Para encontrar rapidamente o que preciso sem me perder em grandes volumes de dados.

### **Fluxo principal:**

1. Administrador acessa a tela de listagem de setores.
2. A tabela exibe os setores com as colunas `nome`, `sigla` e `status` (ativo/inativo).
3. O administrador pode:
   - Filtrar por `nome` e `sigla` (busca parcial, ignorando maiúsculas e minúsculas) e por `status` (ativo/inativo).
   - Ordenar por `nome` ou `sigla`, crescente ou decrescente.
   - Escolher quantos itens exibir por página (10, 25, 50).
   - Navegar entre as páginas.
4. O sistema retorna os dados paginados, filtrados e ordenados conforme a escolha do administrador.
5. Quando nenhum setor corresponder aos filtros, o sistema exibe a mensagem "Nenhum resultado encontrado".

### **Critérios de aceite:**

- A listagem é acessível apenas a administradores.
- A listagem é paginada.
- A tabela exibe as colunas `nome`, `sigla` e `status` (ativo/inativo).
- É possível filtrar por `nome` e `sigla` (busca parcial, ignorando maiúsculas e minúsculas) e por `status` (ativo/inativo).
- É possível ordenar por `nome` ou `sigla`, em ordem crescente ou decrescente.
- O administrador pode controlar a quantidade de itens por página (10, 25, 50).
- A combinação de filtros, ordenação e paginação funciona de forma integrada.
- Quando não houver resultados, o sistema exibe a mensagem "Nenhum resultado encontrado".
- Toda a lógica de paginação, ordenação e filtros ocorre no backend para garantir performance.
