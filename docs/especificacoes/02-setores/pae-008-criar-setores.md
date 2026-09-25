# [PAE-008] Criar setores

### **Descrição:**

Setores são categorias internas usadas para organizar produtos. Servem para classificá-los de forma lógica e facilitar a consulta e a gestão do catálogo.

### **Objetivo:**

Criar uma base de setores que sirva como referência para agrupar e filtrar produtos de forma estruturada.

### **História:**

Como administrador do sistema,
Quero cadastrar setores com nome, sigla e descrição,
Para organizar melhor os produtos.

### **Fluxo principal:**

1. Administrador acessa a tela de cadastro de setor.
2. Informa os campos obrigatórios: `nome`, `sigla`.
3. Opcionalmente, preenche a `descrição`.
4. Salva o setor.
5. O sistema:
   - Remove espaços extras (trim) do `nome` e da `sigla`, e normaliza a `sigla` para maiúsculas.
   - Valida se já existe setor com o mesmo `nome` ou a mesma `sigla` (ignorando maiúsculas/minúsculas) e, se sim, bloqueia com a mensagem correspondente.
   - Valida os tamanhos: nome (≤100), sigla (≤3), descrição (≤255).
   - Persiste o setor com status ativo.
   - Registra a criação no histórico de alterações do setor (ver [PAE-013]).
   - Exibe o novo setor na listagem.

### **Critérios de aceite:**

- É possível cadastrar um setor com nome, sigla e descrição.
- Nome e sigla são obrigatórios; descrição é opcional.
- Nome e sigla são únicos, sem diferenciar maiúsculas de minúsculas (`Vendas` e `vendas` são considerados o mesmo setor).
- O nome é salvo sem espaços nas pontas (trim); a sigla é salva sem espaços nas pontas e normalizada para maiúsculas.
- Validações de tamanho: nome (≤100), sigla (≤3), descrição (≤255).
- O setor é criado com status ativo.
- O cadastro só pode ser feito por administradores.
- A criação gera um registro no histórico de alterações do setor (ver [PAE-013]).
- Mensagens de erro:
  - nome duplicado: "Já existe um setor com este nome";
  - sigla duplicada: "Já existe um setor com esta sigla";
  - nome acima do limite: "O nome deve ter no máximo 100 caracteres";
  - sigla acima do limite: "A sigla deve ter no máximo 3 caracteres";
  - descrição acima do limite: "A descrição deve ter no máximo 255 caracteres".
- O novo setor aparece corretamente na listagem após o cadastro.
