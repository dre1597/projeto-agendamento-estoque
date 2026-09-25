# [PAE-037] Visualizar setor

### **Descrição:**

Além da listagem, é preciso uma tela de detalhes para consultar os dados de um setor em modo somente leitura, incluindo o acesso ao seu histórico de alterações.

### **Objetivo:**

Permitir que o administrador visualize os dados de um setor sem editá-los.

### **História:**

Como administrador do sistema,
Quero visualizar os detalhes de um setor,
Para consultar suas informações e o histórico de alterações.

### **Fluxo principal:**

1. Administrador acessa a listagem de setores.
2. Seleciona um setor e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: `nome`, `sigla`, `descrição` e `status` (ativo/inativo).
4. A tela dá acesso ao histórico de alterações do setor (ver [PAE-013]).
5. A partir da tela, o administrador pode acionar as ações já especificadas em outros cards (editar, ativar/inativar e excluir).

### **Critérios de aceite:**

- A tela de detalhes é acessível apenas a administradores.
- Os dados são exibidos em modo somente leitura (não editáveis na tela).
- A tela exibe `nome`, `sigla`, `descrição` e `status` (ativo/inativo).
- A tela dá acesso ao histórico de alterações do setor (ver [PAE-013]).
- Tendo permissão, o administrador pode executar qualquer ação da entidade a partir da tela de detalhes.
- As ações disponíveis na tela são as já especificadas (editar, ativar/inativar e excluir).
