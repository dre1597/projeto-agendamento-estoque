# [PAE-044] Sinalizar verificação de estoque para ajuste

### **Descrição:**

O administrador pode marcar **manualmente** uma verificação como `"requer ajuste"`, sinalizando que ela precisa de um pedido de ajuste. A marcação pode ser removida quando não for mais necessária (ex.: o ajuste foi aprovado, foi rejeitado ou não se aplica). O sistema **nunca** marca nem desmarca sozinho.

### **Objetivo:**

Permitir ao administrador sinalizar e remover a marcação de `"requer ajuste"` de uma verificação.

### **História:**

Como administrador do sistema,
Quero marcar ou desmarcar uma verificação como "requer ajuste",
Para organizar o que precisa de ajuste sem que o sistema decida isso sozinho.

### **Fluxo principal:**

1. Administrador acessa os detalhes de um pedido de verificação ([PAE-042](pae-042-visualizar-pedido-de-movimentacao-de-estoque.md)).
2. O sistema exibe a ação de **marcar** ou **remover a marcação**.
3. Ao marcar `"requer ajuste"`, o pedido fica **destacado** na listagem ([PAE-020](pae-020-listar-pedidos-de-movimentacao-de-estoque.md)) e nos detalhes ([PAE-042](pae-042-visualizar-pedido-de-movimentacao-de-estoque.md)).
4. Ao remover a marcação, o destaque some.
5. A marcação nunca é feita automaticamente: só por ação do administrador.

### **Critérios de aceite:**

- Apenas administradores podem **marcar** ou **remover** a marcação.
- A marcação é sempre **manual**; o sistema não marca nem desmarca sozinho.
- O pedido marcado aparece com **destaque** na listagem ([PAE-020](pae-020-listar-pedidos-de-movimentacao-de-estoque.md)) e nos detalhes ([PAE-042](pae-042-visualizar-pedido-de-movimentacao-de-estoque.md)).
- A marcação pode ser **removida a qualquer momento** pelo administrador.
- A ação (marcar/remover) é registrada no histórico do pedido ([PAE-040](pae-040-rastrear-historico-do-pedido-de-movimentacao-de-estoque.md)).

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
