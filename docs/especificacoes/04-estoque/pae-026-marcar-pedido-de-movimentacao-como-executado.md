# [PAE-026] Marcar pedido de movimentação como executado

### **Descrição:**

Depois de executar o pedido no mundo real, o usuário registra que a movimentação **aconteceu**. Nesse momento a movimentação é aplicada ao estoque (o saldo muda e o registro entra no ledger).

### **Objetivo:**

Permitir que quem executou o pedido registre a execução realizada, aplicando a movimentação ao estoque e encerrando o pedido.

### **História:**

Como usuário que executou o pedido,
Quero registrar que a movimentação foi realizada,
Para que o estoque seja atualizado com o que aconteceu de fato.

### **Fluxo principal:**

1. Usuário que executou o pedido acessa os detalhes de um pedido com status `"Agendado"`.
2. Um botão é exibido: **"Marcar como executado"**.
3. Ao clicar, o sistema exibe uma confirmação e pede a confirmação da ação.
4. Confirmando:
   - O sistema aplica a movimentação ao estoque (entrada/saída), atualizando o saldo e gravando o registro no ledger.
   - O status do pedido muda para `"Executado"` (fim).
   - Ficam registrados data/hora e quem executou.
5. Se for uma **remoção** e não houver saldo suficiente, o sistema **não aplica** a movimentação e orienta o usuário a registrar a execução como não realizada ([PAE-030]).

### **Critérios de aceite:**

- O botão aparece apenas para pedidos com status `"Agendado"`.
- Qualquer usuário que executou o pedido pode registrar a execução.
- O sistema exige confirmação antes de executar.
- Ao confirmar, a movimentação é aplicada ao estoque (saldo atualizado + registro no ledger).
- O status muda para `"Executado"` e o pedido fica finalizado, sem novas alterações.
- Numa remoção sem saldo suficiente, a movimentação **não** é aplicada e a orientação é registrar como não realizada ([PAE-030]).
- O saldo nunca fica negativo.

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
