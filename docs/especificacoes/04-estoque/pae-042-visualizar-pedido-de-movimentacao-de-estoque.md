# [PAE-042] Visualizar pedido de movimentação de estoque

### **Descrição:**

Tela de detalhes do pedido, em modo somente leitura, que reúne as informações, o histórico e as ações disponíveis conforme o status e a permissão do usuário.

### **Objetivo:**

Permitir que o usuário consulte os detalhes do pedido e acione as ações do fluxo.

### **História:**

Como usuário do sistema,
Quero visualizar os detalhes de um pedido,
Para consultar suas informações, o histórico e executar as ações cabíveis.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem de pedidos ([PAE-020]).
2. Seleciona um pedido e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: `código`, tipo, produto, quantidade, razão, observação, status, quem criou e data de criação. Nas verificações, exibe também a quantidade contada.
4. A tela exibe o **fluxo completo do pedido** em uma **trilha de etapas**, com o **estado atual em destaque** e os ramos (Rejeitado, Pendente, Negado) como desvios na etapa de origem — visível a **todos** os usuários.
5. A tela dá acesso ao histórico de alterações do pedido ([PAE-040]).
6. Conforme o status e a permissão, a tela oferece as ações do fluxo:
   - `"Em Preparação"`: atualizar [PAE-021], remover [PAE-022] e requisitar [PAE-023] (criador).
   - `"Requisitado"`: iniciar verificação [PAE-024] (administrador).
   - `"Em Verificação"`: aprovar, rejeitar ou devolver para ajuste [PAE-025] (administrador).
   - `"Aprovado"` ou `"Pendente"`: agendar [PAE-027] (criador).
   - `"Agendado"`: cancelar agendamento [PAE-031] (criador) e registrar execução [PAE-026]/[PAE-030] (executor).
   - `"Pendente"`: negar [PAE-039] (administrador).

### **Critérios de aceite:**

- A tela de detalhes é acessível a qualquer usuário autenticado.
- Os dados são exibidos em modo somente leitura.
- A tela exibe `código`, tipo, produto, quantidade, razão, observação, status, criador e data de criação.
- A tela exibe a marcação `"requer ajuste"` quando o administrador a tiver aplicado ([PAE-044]), além da quantidade contada nas verificações.
- A tela exibe o **fluxo completo do pedido** em uma **trilha de etapas**, com o **estado atual destacado**, e isso é visível a **todos** os usuários (independentemente de permissão).
- A tela dá acesso ao histórico de alterações do pedido ([PAE-040]).
- As ações disponíveis aparecem apenas quando o status e a permissão permitirem, conforme a máquina de estados.

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
