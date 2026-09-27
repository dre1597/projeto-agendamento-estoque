# [PAE-022] Remover pedido de movimentação de estoque

### **Descrição:**

Pedidos de movimentação podem ser removidos apenas enquanto estiverem em preparação e não tiverem iniciado o fluxo de aprovação. Isso garante flexibilidade durante a criação, mas bloqueia alterações destrutivas após o envio.

### **Objetivo:**

Permitir que o criador exclua um pedido de movimentação antes de submetê-lo para validação, evitando a existência de pedidos incorretos ou descartados.

### **História:**

Como criador de um pedido de movimentação,
Quero poder excluir meu pedido enquanto ele estiver em preparação,
Para corrigir erros ou remover pedidos indevidos antes de submetê-los.

### **Fluxo principal:**

1. Usuário autenticado acessa a listagem ou os detalhes do pedido.
2. Se o pedido estiver com status `"Em Preparação"` **e** nunca tiver saído desse status:
   - O botão de exclusão é exibido.
   - Ao clicar, o sistema exibe a confirmação:
     **"Tem certeza que deseja excluir este pedido? Esta ação não pode ser desfeita."**
   - Confirmando, o pedido é removido.
3. Se o pedido já tiver saído de `"Em Preparação"` em algum momento (mesmo que tenha voltado depois):
   - O botão de exclusão não aparece.
   - Nenhuma ação de exclusão é permitida.

### **Critérios de aceite:**

- Apenas o criador do pedido pode ver e usar o botão de exclusão.
- A exclusão só é permitida se o status atual for `"Em Preparação"` **e** o pedido nunca tiver saído desse status.
- O sistema exibe confirmação antes de excluir.
- Após a exclusão, o pedido desaparece da listagem.
- A exclusão é registrada no histórico do pedido ([PAE-040](pae-040-rastrear-historico-do-pedido-de-movimentacao-de-estoque.md)).
- O sistema bloqueia qualquer tentativa forçada de excluir pedidos fora dessa regra.

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
