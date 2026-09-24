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

1. Usuário acessa a tela de listagem de setores.
2. A tabela exibe os setores paginados com os campos `nome`, `sigla`, `status` e `descrição`.
3. O usuário pode:
   - Filtrar os setores por `nome` ,`sigla` e `status`.
   - Ordenar por `nome` ou `sigla`, crescente ou decrescente.
   - Definir quantos itens deseja ver por página (ex: 10, 25, 50).
   - Navegar entre as páginas.
4. A listagem reflete essas escolhas com dados já tratados no servidor, garantindo performance mesmo com muitos registros.

### **Critérios de aceite:**

- A listagem é paginada.
- O usuário pode escolher a quantidade de itens exibidos por página (mínimo 10, opções como 10, 25, 50).
- É possível ordenar por `nome` ou `sigla`, em ordem crescente ou decrescente.
- É possível filtrar os setores por nome, sigla e status (busca parcial).
- A combinação de filtros, ordenação e paginação funciona de forma integrada.
- Toda a lógica de paginação, ordenação e filtros deve ocorrer no backend, evitando manipulações inconsistentes no frontend.
