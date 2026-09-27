# [PAE-020] Listar pedidos de movimentação de estoque

### **Descrição:**

A listagem de movimentações precisa ser flexível para atender tanto usuários que analisam os pedidos quanto aqueles que apenas acompanham suas próprias solicitações.

### **Objetivo:**

Exibir os pedidos de movimentação de estoque com filtros, ordenação e paginação no backend.

### **História:**

Como usuário do sistema,
Quero filtrar e ordenar os pedidos de movimentação,
Para encontrar facilmente os pedidos que me interessam e acompanhar as solicitações.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem de pedidos de movimentação.
2. A tabela exibe as colunas: `código`, tipo, produto, quantidade, status, criado por e data de criação.
3. O usuário pode:
   - Filtrar por `código`, por produto (busca parcial, ignorando maiúsculas e minúsculas), por status, por criador, por situação de ajuste (`"requer ajuste"`) e por "apenas os meus pedidos".
   - Ordenar por `código`, nome do produto, quantidade ou data de criação (crescente/decrescente).
   - Escolher quantos itens exibir por página (10, 25, 50).
   - Navegar entre as páginas.
4. O sistema retorna os resultados aplicando filtros, ordenações e paginação no backend.
5. Quando nenhum pedido corresponder aos filtros, o sistema exibe a mensagem "Nenhum resultado encontrado".

### **Critérios de aceite:**

- A listagem é acessível a qualquer usuário autenticado.
- A tabela exibe as colunas `código`, tipo, produto, quantidade, status, criador e data de criação.
- É possível filtrar por `código`, por produto (busca parcial, ignorando maiúsculas e minúsculas), por status, por criador e por "apenas os meus pedidos".
- É possível ordenar por `código`, nome do produto, quantidade ou data de criação, em ordem crescente ou decrescente.
- Pedidos de verificação marcados pelo administrador como `"requer ajuste"` ([PAE-044]) são destacados na listagem e podem ser filtrados por ele.
- O usuário controla os itens por página (10, 25, 50).
- Quando não houver resultados, o sistema exibe a mensagem "Nenhum resultado encontrado".
- Todos os filtros, ordenações e paginação são processados no backend.

### **Máquina de estados (contexto):**

| De | Para | Quem dispara | Ação |
|---|---|---|---|
| — | `Em Preparação` | criador | Criar pedido |
| `Em Preparação` | `Em Preparação` | criador | Editar |
| `Em Preparação` | *(excluído)* | criador | Remover (só se nunca saiu daqui) |
| `Em Preparação` | `Requisitado` | criador | Requisitar |
| `Requisitado` | `Em Verificação` | administrador | Iniciar verificação |
| `Em Verificação` | `Aprovado` | administrador | Aprovar |
| `Em Verificação` | `Rejeitado` | administrador | Rejeitar (fim) |
| `Em Verificação` | `Em Preparação` | administrador | Devolver para ajuste |
| `Aprovado` | `Agendado` | criador | Agendar |
| `Agendado` | `Pendente` | criador | Cancelar agendamento |
| `Agendado` | `Executado` | executor | Registrar execução realizada (fim) |
| `Agendado` | `Pendente` | executor | Registrar execução não realizada (com razão) |
| `Pendente` | `Agendado` | criador | Reagendar / executar de novo |
| `Pendente` | `Negado` | administrador | Negar (fim) |

Estados finais: `Executado`, `Rejeitado`, `Negado`. Transitório: `Pendente`.
