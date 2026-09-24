# [PAE-014] Cadastrar produtos

### **Descrição:**

Produtos precisam ser registrados no sistema com suas informações básicas e vinculados a setores responsáveis, para controle de estoque e organização operacional.

### **Objetivo:**

Permitir o cadastro de produtos com informações essenciais, incluindo os setores responsáveis ou relacionados ao seu manuseio.

### **História:**

Como usuário do sistema,
Quero cadastrar produtos com nome, descrição, quantidade, valor e setores relacionados,
Para controlar melhor os itens no estoque e organizar sua gestão.

### **Fluxo principal:**

1. Usuário acessa a tela de cadastro de produto.
2. Preenche os campos obrigatórios:
   - Nome do produto
   - Descrição
   - Quantidade atual
   - Valor unitário
   - Lista de setores relacionados (um ou mais)
3. Salva o cadastro.
4. O sistema valida os campos e persiste o produto.

### **Critérios de aceite:**

- O produto é salvo com os campos: nome, descrição, quantidade, valor e lista de setores.
- Ao menos um setor deve ser selecionado no cadastro.
- Quantidade e valor devem ser numéricos e não negativos.
- O produto só pode ser cadastrado se todos os campos obrigatórios forem preenchidos corretamente.
- A associação entre produtos e setores é armazenada e pode ser usada para filtros e controle posterior.
