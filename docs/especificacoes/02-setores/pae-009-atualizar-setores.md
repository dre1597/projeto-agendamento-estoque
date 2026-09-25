# [PAE-009] Atualizar setores

### **Descrição:**

Setores são categorias internas usadas para organizar produtos. Servem para classificá-los de forma lógica e facilitar a consulta e a gestão do catálogo.

### **Objetivo:**

Permitir a edição de setores já cadastrados para corrigir ou atualizar informações como nome, sigla e descrição.

### **História:**

Como administrador do sistema,
Quero editar os dados de um setor existente,
Para manter as informações consistentes e atualizadas.

### **Fluxo principal:**

1. Administrador acessa a listagem de setores.
2. Seleciona o setor que deseja editar.
3. Altera um ou mais campos: `nome`, `sigla`, `descrição`.
4. Salva as alterações.
5. O sistema:
   - Remove espaços extras (trim) do `nome` e da `sigla`, e normaliza a `sigla` para maiúsculas.
   - Valida se o `nome` ou a `sigla` já pertencem a **outro** setor (ignorando maiúsculas/minúsculas) e, se sim, bloqueia com a mensagem correspondente.
   - Valida que nome e sigla continuam obrigatórios e que os tamanhos são respeitados: nome (≤100), sigla (≤10), descrição (≤255).
   - Persiste os dados atualizados.
   - Registra a alteração no histórico de alterações do setor (ver [PAE-013]).
   - Exibe a versão atualizada na listagem.

### **Critérios de aceite:**

- É possível editar o nome, sigla e descrição de um setor.
- Nome e sigla continuam obrigatórios após a edição.
- Nome e sigla permanecem únicos, sem diferenciar maiúsculas de minúsculas (`Vendas` e `vendas` são considerados o mesmo setor); a comparação ignora o próprio setor que está sendo editado.
- O nome é salvo sem espaços nas pontas (trim); a sigla é salva sem espaços nas pontas e normalizada para maiúsculas.
- A `descrição` pode ser deixada vazia/limpa na edição.
- Validações de tamanho continuam aplicadas: nome (≤100), sigla (≤10), descrição (≤255).
- A edição só pode ser feita por administradores.
- A atualização gera um registro no histórico de alterações do setor (ver [PAE-013]).
- Mensagens de erro:
  - nome duplicado: "Já existe um setor com este nome";
  - sigla duplicada: "Já existe um setor com esta sigla";
  - nome acima do limite: "O nome deve ter no máximo 100 caracteres";
  - sigla acima do limite: "A sigla deve ter no máximo 10 caracteres";
  - descrição acima do limite: "A descrição deve ter no máximo 255 caracteres".
- O sistema salva corretamente os dados atualizados e exibe a versão atualizada na listagem.
