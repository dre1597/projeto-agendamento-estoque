# [PAE-036] Visualizar usuário

### **Descrição:**

Além da listagem, é preciso uma tela de detalhes para consultar os dados de um usuário em modo somente leitura, incluindo o acesso ao seu histórico de alterações.

### **Objetivo:**

Permitir que o administrador visualize os dados de um usuário sem editá-los.

### **História:**

Como administrador do sistema,
Quero visualizar os detalhes de um usuário,
Para consultar suas informações e o histórico de alterações.

### **Fluxo principal:**

1. Administrador acessa a listagem de usuários.
2. Seleciona um usuário e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: `username`, `status` (ativo/inativo/bloqueado) e se o usuário é administrador.
4. A tela dá acesso ao histórico de alterações do usuário (ver [PAE-006]).
5. A partir da tela, o administrador pode acionar as ações já especificadas em outros cards (editar, ativar/inativar, desbloquear e excluir).

### **Critérios de aceite:**

- A tela de detalhes é acessível apenas a administradores.
- Os dados são exibidos em modo somente leitura (não editáveis na tela).
- A tela exibe `username`, `status` (ativo/inativo/bloqueado) e se o usuário é administrador.
- A tela dá acesso ao histórico de alterações do usuário (ver [PAE-006]).
- Tendo permissão, o administrador pode executar qualquer ação da entidade a partir da tela de detalhes.
- As ações disponíveis na tela são as já especificadas (editar, ativar/inativar, desbloquear e excluir).
