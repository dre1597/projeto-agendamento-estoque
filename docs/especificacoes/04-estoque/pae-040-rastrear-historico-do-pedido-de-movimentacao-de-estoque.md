# [PAE-040] Rastrear histórico de alterações de pedidos de movimentação de estoque

### **Descrição:**

Os pedidos de movimentação precisam de um log de alterações — quem fez, quando, o que mudou e por quê — para dar rastreabilidade a todo o workflow. O log pertence à base de pedidos e permanece mesmo que um pedido seja excluído.

### **Objetivo:**

Registrar e exibir as mudanças feitas nos pedidos de movimentação ao longo do tempo, garantindo visibilidade de todo o fluxo de aprovação e execução.

### **História:**

Como usuário do sistema,
Quero visualizar o histórico de alterações de um pedido,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um pedido for criado, editado, tiver o status alterado ou for excluído:
   - O sistema registra automaticamente:
     - Quem fez a alteração (pelo `username`) e o pedido afetado (pelo `código`).
     - Data e hora.
     - Descrição automática do evento:
       - Criação: "o pedido foi criado".
       - Edição: os campos alterados, com valor anterior → valor novo.
       - Mudança de status: de → para, com o responsável.
       - Exclusão: "o pedido foi excluído".
     - Razão do evento, quando houver (ex.: execução não realizada).
2. Na tela de detalhes do pedido ([PAE-021](pae-021-atualizar-pedido-de-movimentacao-de-estoque.md)), o usuário pode acessar o histórico.
3. O histórico exibe os eventos do mais recente para o mais antigo.

### **Critérios de aceite:**

- Cada alteração na base de pedidos gera um registro no histórico.
- O histórico salva: pedido afetado, campo/status alterado, valor anterior → valor novo, data/hora, quem fez e a razão do evento quando houver.
- Criação, edição, mudança de status e exclusão geram evento no histórico.
- O histórico sobrevive à exclusão do pedido (identificação pelo `código`, sem vínculo com o cadastro).
- O histórico pode ser consultado por qualquer usuário autenticado.
- O histórico é ordenado do mais recente para o mais antigo.
- O histórico é imutável: seus registros não podem ser editados nem excluídos.
- A data/hora dos eventos é a do **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).

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
