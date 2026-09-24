# [PAE-004] Listar usuários

### **Descrição:**

A listagem de usuários deve permitir uma navegação eficiente, com opções para ordenar, filtrar e controlar a quantidade de itens exibidos por página.

### **Objetivo:**

Facilitar a busca e organização dos usuários cadastrados, garantindo boa performance e usabilidade mesmo com grande volume de dados.

### **História:**

Como administrador do sistema,
Quero visualizar os usuários cadastrados com paginação, ordenação e filtros,
Para localizar rapidamente os usuários desejados e gerenciar o acesso.

### **Fluxo principal:**

1. Usuário acessa a tela de listagem de usuários.
2. A tabela exibe usuários com colunas básicas: `username`, `status` (ativo/inativo).
3. O usuário pode:
   - Filtrar por `username` e `status`.
   - Ordenar por `username` (asc/desc).
   - Escolher quantos itens exibir por página (ex: 10, 25, 50).
   - Navegar entre páginas.
4. O sistema retorna os dados paginados, filtrados e ordenados conforme escolha do usuário.

### **Critérios de aceite:**

- A listagem é paginada.
- É possível filtrar por `username` (busca parcial) e `status` (ativo/inativo).
- A ordenação é possível por `username` em ordem crescente e decrescente.
- O usuário pode controlar a quantidade de itens por página (10, 25, 50).
- A listagem atualiza corretamente ao aplicar filtros, ordenação e navegação.
- Toda a lógica de paginação, ordenação e filtros ocorre no backend para garantir performance.
