# [PAE-038] Visualizar produto

### **Descrição:**

Além da listagem, é preciso uma tela de detalhes para consultar os dados de um produto em modo somente leitura, incluindo o acesso ao seu histórico de alterações.

### **Objetivo:**

Permitir que o usuário visualize os dados de um produto sem editá-los.

### **História:**

Como usuário do sistema,
Quero visualizar os detalhes de um produto,
Para consultar suas informações e o histórico de alterações.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem de produtos.
2. Seleciona um produto e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: `nome`, `descrição`, `quantidade atual`, `valor unitário` e os `setores relacionados`.
4. A tela dá acesso ao histórico de alterações do produto (ver [PAE-018]).
5. A partir da tela, o usuário pode acionar as ações já especificadas em outros cards (editar e excluir).

### **Critérios de aceite:**

- A tela de detalhes é acessível a qualquer usuário autenticado.
- Os dados são exibidos em modo somente leitura (não editáveis na tela).
- A tela exibe `nome`, `descrição`, `quantidade atual`, `valor unitário` e os `setores relacionados`.
- A tela dá acesso ao histórico de alterações do produto (ver [PAE-018]).
- Tendo permissão, o usuário pode executar qualquer ação da entidade a partir da tela de detalhes.
- As ações disponíveis na tela são as já especificadas (editar e excluir).
