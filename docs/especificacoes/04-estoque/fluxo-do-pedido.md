# Fluxo do pedido de movimentação de estoque

Referência do fluxo (máquina de estados) do pedido de movimentação. **Não é uma história** — é o desenho que as histórias do estoque referenciam.

## Status

`Em Preparação`, `Requisitado`, `Em Verificação`, `Aprovado`, `Rejeitado`, `Agendado`, `Pendente`, `Negado`, `Executado`.

## Transições

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

## Observações

- O **agendamento** é só um norte para a execução no mundo real ([PAE-027](../05-agendamento/pae-027-agendar-pedido-de-movimentacao-para-execucao-no-estoque.md)); não reserva estoque.
- O **saldo só muda na execução** de **adição/remoção** ([PAE-026](pae-026-marcar-pedido-de-movimentacao-como-executado.md)); a **verificação** não altera o saldo ([PAE-019](pae-019-criar-pedido-de-movimentacao-de-estoque.md)).
- O marcador **`"requer ajuste"`** é manual do administrador ([PAE-044](pae-044-sinalizar-verificacao-de-estoque-para-ajuste.md)) — **não é status**.
- Todo horário é no **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).
