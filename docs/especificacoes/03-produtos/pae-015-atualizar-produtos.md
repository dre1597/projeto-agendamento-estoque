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

1. Usuário acessa a listagem de produtos.
2. Seleciona um produto para edição.
3. Altera um ou mais dos seguintes campos:
   - Nome
   - Descrição
   - Quantidade
   - Valor
   - Lista de setores vinculados
4. Salva as alterações.
5. O sistema valida os campos e atualiza o produto.

### **Critérios de aceite:**

- Qualquer usuário autenticado pode acessar a edição de produtos.
- Os mesmos campos do cadastro podem ser alterados: nome, descrição, quantidade, valor e setores.
- A quantidade e o valor continuam sendo validados como numéricos e não negativos.
- Ao menos um setor deve permanecer associado ao produto.
- As alterações são salvas e refletidas imediatamente na listagem e nos registros relacionados.
