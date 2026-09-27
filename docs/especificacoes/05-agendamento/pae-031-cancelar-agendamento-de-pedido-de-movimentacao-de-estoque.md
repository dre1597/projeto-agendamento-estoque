# [PAE-031] Cancelar agendamento de pedido de movimentação de estoque

### **Descrição:**

Permitir que o criador do pedido cancele o agendamento para execução, retornando o status do pedido para `"Pendente"` e interrompendo o fluxo de execução agendada.

### **Objetivo:**

Dar autonomia ao usuário para cancelar o agendamento do pedido, liberando a execução para um novo agendamento futuro.

### **História:**

Como criador de um pedido agendado,
Quero cancelar o agendamento da execução,
Para poder reagendar ou manter o pedido pendente.

### **Fluxo principal:**

1. Usuário acessa a tela de detalhes de um pedido com status `"Agendado"`.
2. O sistema verifica se faltam pelo menos **24 horas** para o horário agendado (no **horário do sistema**):
   - Se faltarem 24h ou mais, exibe o botão **"Cancelar agendamento"**.
   - Se faltar menos de 24h, o botão **não** é exibido e, ao tentar, o sistema bloqueia com a mensagem **"Não é possível cancelar: o agendamento tem menos de 1 dia de antecedência."**
3. Usuário clica no botão; o sistema exibe a confirmação:
   **"Você deseja cancelar o agendamento? O pedido voltará para Pendente."**
4. Confirmando:
   - O status do pedido muda para `"Pendente"`.
   - O sistema registra data/hora (no **horário do sistema**), usuário e ação.
5. O pedido fica disponível para novo agendamento ([PAE-027]).

### **Critérios de aceite:**

- Apenas pedidos com status `"Agendado"` podem ter o agendamento cancelado.
- Apenas o criador do pedido pode cancelar o agendamento.
- Só é possível cancelar com pelo menos **24 horas** de antecedência (no **horário do sistema**, [PAE-045]).
- O botão "Cancelar agendamento" só aparece quando há 24h ou mais de antecedência.
- O sistema exibe a confirmação **"Você deseja cancelar o agendamento? O pedido voltará para Pendente."** antes de cancelar.
- Se faltar menos de 24h, o sistema bloqueia com **"Não é possível cancelar: o agendamento tem menos de 1 dia de antecedência."**
- O status do pedido muda para `"Pendente"` após o cancelamento.
- O sistema registra o cancelamento (data, hora no **horário do sistema** e usuário).
- O pedido cancelado pode ser reagendado normalmente.

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
