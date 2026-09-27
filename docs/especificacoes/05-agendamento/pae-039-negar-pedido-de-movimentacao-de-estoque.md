# [PAE-039] Negar pedido de movimentação de estoque

### **Descrição:**

Um pedido que ficou `"Pendente"` (execução não realizada ou agendamento cancelado) pode ser encerrado sem ser executado. Essa é a ação de **negar** o pedido, finalizando o fluxo.

### **Objetivo:**

Permitir que o administrador negue um pedido pendente, encerrando-o quando não houver mais intenção de executá-lo.

### **História:**

Como administrador do sistema,
Quero negar um pedido pendente,
Para encerrá-lo quando ele não for mais ser executado.

### **Fluxo principal:**

1. Administrador acessa a tela de detalhes de um pedido com status `"Pendente"`.
2. Um botão é exibido: **"Negar pedido"**.
3. Ao clicar, o sistema exibe uma confirmação:
   **"Você deseja negar este pedido? Ele será encerrado e não poderá mais ser executado."**
4. Confirmando:
   - O status do pedido muda para `"Negado"` (fim).
   - Ficam registrados data/hora (no **horário do sistema**) e quem negou.
5. O pedido não pode mais ser reagendado nem executado.

### **Critérios de aceite:**

- Apenas pedidos com status `"Pendente"` podem ser negados.
- Apenas administradores podem negar o pedido.
- O sistema exige confirmação antes de negar.
- Ao confirmar, o status muda para `"Negado"` e o pedido fica finalizado.
- O sistema registra data/hora (no **horário do sistema**, [PAE-045]) e o responsável.
- O pedido negado não pode ser reagendado nem executado.

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
