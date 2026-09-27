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

1. Usuário autenticado acessa a listagem de pedidos ([PAE-020](pae-020-listar-pedidos-de-movimentacao-de-estoque.md)).
2. Seleciona um pedido e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: `código`, tipo, produto, quantidade, razão, observação, status, quem criou e data de criação. Nas verificações, exibe também a quantidade contada.
4. A tela exibe o **fluxo completo do pedido** em uma **trilha de etapas**, com o **estado atual em destaque** e os ramos (Rejeitado, Pendente, Negado) como desvios na etapa de origem — visível a **todos** os usuários.
5. A tela dá acesso ao histórico de alterações do pedido ([PAE-040](pae-040-rastrear-historico-do-pedido-de-movimentacao-de-estoque.md)).
6. Conforme o status e a permissão, a tela oferece as ações do fluxo:
   - `"Em Preparação"`: atualizar [PAE-021](pae-021-atualizar-pedido-de-movimentacao-de-estoque.md), remover [PAE-022](pae-022-remover-pedido-de-movimentacao-de-estoque.md) e requisitar [PAE-023](pae-023-requisitar-um-pedido.md) (criador).
   - `"Requisitado"`: iniciar verificação [PAE-024](pae-024-iniciar-verificacao-de-pedido-de-movimentacao-de-estoque.md) (administrador).
   - `"Em Verificação"`: aprovar, rejeitar ou devolver para ajuste [PAE-025](pae-025-avaliar-pedido-de-movimentacao-aprovar-rejeitar-ou-ajustar.md) (administrador).
   - `"Aprovado"` ou `"Pendente"`: agendar [PAE-027](../05-agendamento/pae-027-agendar-pedido-de-movimentacao-para-execucao-no-estoque.md) (criador).
   - `"Agendado"`: cancelar agendamento [PAE-031](../05-agendamento/pae-031-cancelar-agendamento-de-pedido-de-movimentacao-de-estoque.md) (criador) e registrar execução [PAE-026](pae-026-marcar-pedido-de-movimentacao-como-executado.md)/[PAE-030](../05-agendamento/pae-030-registrar-execucao-nao-realizada-do-pedido.md) (executor).
   - `"Pendente"`: negar [PAE-039](../05-agendamento/pae-039-negar-pedido-de-movimentacao-de-estoque.md) (administrador).

### **Critérios de aceite:**

- A tela de detalhes é acessível a qualquer usuário autenticado.
- Os dados são exibidos em modo somente leitura.
- A tela exibe `código`, tipo, produto, quantidade, razão, observação, status, criador e data de criação.
- A tela exibe a marcação `"requer ajuste"` quando o administrador a tiver aplicado ([PAE-044](pae-044-sinalizar-verificacao-de-estoque-para-ajuste.md)), além da quantidade contada nas verificações.
- A tela exibe o **fluxo completo do pedido** em uma **trilha de etapas**, com o **estado atual destacado**, e isso é visível a **todos** os usuários (independentemente de permissão).
- A tela dá acesso ao histórico de alterações do pedido ([PAE-040](pae-040-rastrear-historico-do-pedido-de-movimentacao-de-estoque.md)).
- As ações disponíveis aparecem apenas quando o status e a permissão permitirem, conforme a máquina de estados.
- As datas e horários são exibidos no **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).

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
