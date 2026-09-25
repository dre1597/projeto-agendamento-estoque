# [PAE-016] Excluir produtos

### **Descrição:**

Em alguns casos, produtos podem ser cadastrados incorretamente ou deixarem de ser relevantes. A exclusão deve ser possível quando o produto não estiver vinculado a movimentações de estoque.

### **Objetivo:**

Permitir que o usuário remova produtos que não estão em uso no sistema, garantindo integridade dos dados e evitando registros órfãos.

### **História:**

Como usuário do sistema,
Quero excluir um produto não utilizado,
Para manter o cadastro limpo e evitar informações irrelevantes no sistema.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem ou os detalhes de um produto.
2. Clica para excluir um produto individualmente.
3. O sistema exibe confirmação e exige informar a razão da exclusão (3 a 500 caracteres):
   **"Tem certeza que deseja excluir este produto? Esta ação não pode ser desfeita."**
4. Se confirmado:
   - O sistema verifica se o produto está em uso (possui movimentações de estoque).
   - Se estiver em uso, bloqueia a exclusão com a mensagem "Não é possível excluir: o produto possui movimentações de estoque".
   - Se não estiver, exclui o produto do banco e registra a exclusão no histórico de alterações do produto ([PAE-018]), incluindo a razão informada.
5. Atualiza a listagem refletindo a exclusão.

### **Critérios de aceite:**

- A exclusão pode ser feita por qualquer usuário autenticado.
- Exclusão é individual, sem opção de múltiplas seleções.
- O sistema exige confirmação antes da exclusão.
- Impede a exclusão se o produto possuir movimentações de estoque.
- Exibe a mensagem "Não é possível excluir: o produto possui movimentações de estoque" ao bloquear a exclusão.
- Remove o produto corretamente quando permitido.
- A exclusão gera um registro no histórico de alterações do produto ([PAE-018]).
- A razão da exclusão é obrigatória (3 a 500 caracteres) e fica registrada no histórico.
- A exclusão pode ser acionada pela listagem ou pelos detalhes do produto.
- Atualiza a listagem imediatamente após a exclusão.
