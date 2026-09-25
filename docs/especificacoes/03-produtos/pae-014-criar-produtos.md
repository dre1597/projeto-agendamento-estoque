# [PAE-014] Criar produtos

### **Descrição:**

Produtos precisam ser registrados no sistema com suas informações básicas e vinculados a setores relacionados, para controle de estoque e organização operacional.

### **Objetivo:**

Permitir o cadastro de produtos com informações essenciais, incluindo os setores relacionados ao seu manuseio.

### **História:**

Como usuário do sistema,
Quero cadastrar produtos com nome, descrição, quantidade, valor e setores relacionados,
Para controlar melhor os itens no estoque e organizar sua gestão.

### **Fluxo principal:**

1. Usuário autenticado acessa a tela de cadastro de produto.
2. Preenche os campos obrigatórios: `nome`, `descrição`, `quantidade atual`, `valor unitário` e a lista de `setores relacionados` (de 1 a 3, apenas ativos).
3. Salva o cadastro.
4. O sistema:
   - Remove espaços nas pontas (trim) de `nome` e `descrição`.
   - Valida se já existe produto com o mesmo `nome` (ignorando maiúsculas/minúsculas) e, se sim, bloqueia com a mensagem correspondente.
   - Valida os campos obrigatórios, os tipos (quantidade inteira; valor decimal com 2 casas) e os limites: nome (3 a 50) e descrição (≤255).
   - Garante que há de 1 a 3 setores relacionados e que todos estão ativos.
   - Persiste o produto e os vínculos com os setores.
   - Registra a criação no histórico de alterações do produto (ver [PAE-018]).
   - Exibe o novo produto na listagem.

### **Critérios de aceite:**

- É possível cadastrar um produto com `nome`, `descrição`, `quantidade`, `valor unitário` e `setores relacionados` (de 1 a 3).
- `nome` é obrigatório, tem de 3 a 50 caracteres e é único, sem diferenciar maiúsculas de minúsculas (`Vendas` e `vendas` são considerados o mesmo nome).
- `descrição` é obrigatória e tem no máximo 255 caracteres.
- `quantidade` é um número inteiro, não negativo (pode ser zero).
- `valor unitário` é um número decimal com 2 casas, não negativo.
- De 1 a 3 setores relacionados devem ser selecionados, e apenas setores **ativos** podem ser escolhidos.
- `nome` e `descrição` são salvos sem espaços nas pontas (trim).
- O cadastro pode ser feito por qualquer usuário autenticado.
- A criação gera um registro no histórico de alterações do produto (ver [PAE-018]).
- Mensagens de erro:
  - nome duplicado: "Já existe um produto com este nome";
  - nome fora do tamanho: "O nome deve ter entre 3 e 50 caracteres";
  - descrição acima do limite: "A descrição deve ter no máximo 255 caracteres";
  - campo obrigatório vazio: "Preencha todos os campos obrigatórios";
  - quantidade inválida: "A quantidade deve ser um número inteiro maior ou igual a zero";
  - valor inválido: "O valor deve ser um número maior ou igual a zero, com no máximo 2 casas decimais";
  - setores fora do limite: "Selecione de 1 a 3 setores".
- O novo produto aparece corretamente na listagem após o cadastro.
