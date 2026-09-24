# [PAE-016] Excluir produtos

### **Descrição:**

Em alguns casos, produtos podem ser cadastrados incorretamente ou deixarem de ser relevantes. A exclusão deve ser possível quando o produto não estiver vinculado a movimentações de estoque ou outros registros dependentes.

### **Objetivo:**

Permitir que usuários removam produtos que não estão em uso no sistema, garantindo integridade dos dados e evitando registros órfãos.

### **História:**

Como usuário do sistema,
Quero excluir um produto não utilizado,
Para manter o cadastro limpo e evitar informações irrelevantes no sistema.

### **Fluxo principal:**

1. Usuário acessa a listagem de produtos.
2. Clica para excluir um produto individualmente.
3. O sistema exibe confirmação:
   **"Tem certeza que deseja excluir este produto? Esta ação não pode ser desfeita."**
4. O sistema verifica se o produto está em uso (ex: movimentações, histórico).
5. Se estiver em uso, bloqueia a exclusão e informa o motivo.
6. Se não estiver, remove o produto do banco.
7. A listagem é atualizada refletindo a exclusão.

### **Critérios de aceite:**

- A exclusão é feita individualmente, sem seleção múltipla.
- O sistema exige confirmação antes de excluir.
- A exclusão só é permitida se o produto não estiver vinculado a nenhum outro registro (ex: movimentações).
- O sistema informa claramente o motivo caso não permita a exclusão.
- O produto é removido corretamente e desaparece da listagem após a ação.
