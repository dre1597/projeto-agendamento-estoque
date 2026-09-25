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

1. Administrador acessa a tela de listagem de usuários.
2. A tabela exibe usuários com colunas básicas: `username`, `status` (ativo/inativo/bloqueado) e `administrador`.
3. O administrador pode:
   - Filtrar por `username` (busca parcial, ignorando maiúsculas e minúsculas) e `status`.
   - Ordenar por `username` (asc/desc).
   - Escolher quantos itens exibir por página (ex.: 10, 25, 50).
   - Navegar entre páginas.
4. O sistema retorna os dados paginados, filtrados e ordenados conforme escolha do administrador.
5. Quando nenhum usuário corresponder aos filtros, o sistema exibe a mensagem "Nenhum resultado encontrado".

### **Critérios de aceite:**

- A listagem é acessível apenas a administradores.
- A listagem é paginada.
- A tabela exibe as colunas `username`, `status` (ativo/inativo/bloqueado) e `administrador`.
- É possível filtrar por `username` (busca parcial, ignorando maiúsculas e minúsculas) e `status` (ativo/inativo/bloqueado).
- A ordenação é possível por `username` em ordem crescente e decrescente.
- O administrador pode controlar a quantidade de itens por página (10, 25, 50).
- A listagem atualiza corretamente ao aplicar filtros, ordenação e navegação.
- Quando não houver resultados, o sistema exibe a mensagem "Nenhum resultado encontrado".
- Toda a lógica de paginação, ordenação e filtros ocorre no backend para garantir performance.
