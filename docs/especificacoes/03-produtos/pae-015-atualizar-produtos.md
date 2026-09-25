# [PAE-015] Atualizar produtos

### **Descrição:**

Produtos cadastrados podem precisar de ajustes em suas informações ou setores relacionados, permitindo que os dados se mantenham atualizados com a realidade operacional.

### **Objetivo:**

Permitir que qualquer usuário autenticado edite as informações de um produto existente, garantindo consistência nas operações.

### **História:**

Como usuário do sistema,
Quero editar os dados de um produto já cadastrado,
Para manter as informações corretas e atualizadas.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem de produtos (ou a tela de detalhes).
2. Seleciona um produto para edição.
3. Altera um ou mais dos seguintes campos: `nome`, `descrição`, `quantidade atual`, `valor unitário` e a lista de `setores relacionados`.
4. Salva as alterações.
5. O sistema:
   - Remove espaços nas pontas (trim) de `nome` e `descrição`.
   - Valida se já existe **outro** produto com o mesmo `nome` (ignorando maiúsculas/minúsculas) e, se sim, bloqueia com a mensagem correspondente.
   - Valida os campos obrigatórios, os tipos (quantidade inteira; valor decimal com 2 casas) e os limites: nome (3 a 50) e descrição (≤255).
   - Garante de 1 a 3 setores relacionados, sendo novos vínculos apenas com setores **ativos** (vínculos já existentes com setores inativados são mantidos).
   - Atualiza o produto e os vínculos com os setores.
   - Registra a alteração no histórico de alterações do produto (ver [PAE-018]).
   - Exibe os dados atualizados na listagem.

### **Critérios de aceite:**

- Qualquer usuário autenticado pode editar produtos.
- Os mesmos campos do cadastro podem ser alterados: `nome`, `descrição`, `quantidade atual`, `valor unitário` e `setores relacionados`.
- `nome` permanece obrigatório, com 3 a 50 caracteres e único, sem diferenciar maiúsculas de minúsculas; a comparação ignora o próprio produto que está sendo editado.
- `descrição` permanece obrigatória e com no máximo 255 caracteres.
- `quantidade atual` é um número inteiro, não negativo (pode ser zero).
- `valor unitário` é um número decimal com 2 casas, não negativo.
- De 1 a 3 setores relacionados devem permanecer associados, e novos vínculos só podem ser feitos com setores **ativos**.
- Um vínculo já existente com um setor que foi inativado é **mantido** na edição.
- `nome` e `descrição` são salvos sem espaços nas pontas (trim).
- A edição gera um registro no histórico de alterações do produto (ver [PAE-018]).
- Mensagens de erro:
  - nome duplicado: "Já existe um produto com este nome";
  - nome fora do tamanho: "O nome deve ter entre 3 e 50 caracteres";
  - descrição acima do limite: "A descrição deve ter no máximo 255 caracteres";
  - campo obrigatório vazio: "Preencha todos os campos obrigatórios";
  - quantidade inválida: "A quantidade deve ser um número inteiro maior ou igual a zero";
  - valor inválido: "O valor deve ser um número maior ou igual a zero, com no máximo 2 casas decimais";
  - setores fora do limite: "Selecione de 1 a 3 setores".
- Os dados atualizados aparecem corretamente na listagem após a edição.
