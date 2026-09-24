# [PAE-017] Listar produtos

### **Descrição:**

A listagem de produtos precisa permitir navegação eficiente, com filtros úteis, ordenação dinâmica e controle de quantidade por página para facilitar a consulta e a gestão do estoque.

### **Objetivo:**

Permitir que usuários visualizem os produtos cadastrados de forma eficiente, com ferramentas para localizar rapidamente itens específicos.

### **História:**

Como usuário do sistema,
Quero visualizar a lista de produtos com filtros e ordenação,
Para encontrar e analisar facilmente os itens registrados.

### **Fluxo principal:**

1. Usuário acessa a tela de listagem de produtos.
2. A tabela exibe os produtos com colunas: nome, quantidade, valor e setores.
3. O usuário pode:
   - Filtrar por nome (busca parcial).
   - Filtrar por setor (um ou mais).
   - Ordenar por nome, quantidade ou valor (asc/desc).
   - Escolher quantos itens deseja ver por página (10, 25, 50).
   - Navegar entre páginas.
4. O sistema retorna os dados aplicando todos os filtros, ordenações e paginação **no backend**.

### **Critérios de aceite:**

- A listagem é paginada e controlada pelo usuário.
- O usuário pode escolher 10, 25 ou 50 itens por página.
- É possível filtrar produtos por nome (texto livre).
- É possível filtrar produtos por um ou mais setores.
- É possível ordenar a lista por nome, quantidade ou valor (ascendente/descendente).
- Toda a lógica de filtro, ordenação e paginação é executada no backend.
- A interface reflete imediatamente as mudanças aplicadas.
