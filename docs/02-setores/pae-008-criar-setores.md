# [PAE-008] Criar setores

### **Descrição:**

Setores são categorias internas usadas para organizar fornecedores e produtos. Servem para classificar de forma lógica e facilitar a gestão de relacionamentos com contatos e estoques.

### **Objetivo:**

Criar uma base de setores que sirva como referência para agrupar e filtrar fornecedores e produtos de forma estruturada.

### **História:**

Como administrador do sistema,
Quero cadastrar setores com nome, sigla e descrição,
Para organizar melhor os contatos e relacioná-los com os produtos fornecidos.

### **Fluxo principal:**

1. Usuário acessa a tela de cadastro de setor.
2. Informa os campos obrigatórios: `nome`, `sigla`.
3. Opcionalmente, preenche a `descrição`.
4. Ao salvar, o sistema gera automaticamente um `ID` interno (UUID ou sequencial, a definir).
5. Validações:
   - Nome e sigla são obrigatórios.
   - Sigla e nome devem ser únicos.
   - Nome máximo 100 caracteres, sigla 10, descrição 255.
6. O setor é persistido no banco e listado na interface de consulta.
7. O setor é inicialmente criado com `status`ativo.

### **Critérios de aceite:**

- É possível cadastrar um setor com nome, sigla e descrição.
- O sistema gera automaticamente um ID único para cada setor.
- Nome e sigla não podem se repetir entre setores.
- Nome e sigla são obrigatórios; descrição é opcional.
- Interface permite visualizar os setores cadastrados.
- Validações de tamanho: nome (≤100), sigla (≤10), descrição (≤255).
- Caso um setor com nome ou sigla duplicada seja cadastrado, o sistema bloqueia a operação com mensagem adequada.
- O setor deve ser criado com status ativo.
