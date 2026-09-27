# [PAE-027] Agendar pedido de movimentação para execução no estoque

### **Descrição:**

Depois de aprovado (ou devolvido para `"Pendente"`), o criador do pedido pode agendá-lo para execução respeitando as regras configuráveis do sistema, que definem a janela de horário permitida, os dias da semana em que o agendamento é possível e a capacidade por horário (até 15 dias do dia atual para frente). O agendamento é só um **norte** para o usuário executar no mundo real e **não reserva estoque** — o saldo é verificado na execução ([PAE-026](../04-estoque/pae-026-marcar-pedido-de-movimentacao-como-executado.md)/[PAE-030](pae-030-registrar-execucao-nao-realizada-do-pedido.md)).

Todo horário é tratado no **horário do sistema**, e não no fuso local do usuário ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).

### **Objetivo:**

Permitir que o usuário agende a execução do pedido dentro das janelas e dos dias permitidos, respeitando a configuração e garantindo o controle da capacidade por horário.

### **História:**

Como criador de um pedido aprovado,
Quero agendar a execução do meu pedido em um horário e dia permitido,
Para que ele seja executado no estoque dentro das regras definidas pelo sistema.

### **Fluxo principal:**

1. Usuário acessa a tela de agendamento para um pedido com status `"Aprovado"` ou `"Pendente"`.
2. O sistema verifica a configuração vigente para:
   - Janela de horário permitida (ex.: 20h às 4h), no **horário do sistema**.
   - Dias da semana permitidos para agendamento.
3. O sistema consulta e exibe os horários disponíveis dentro das regras, com o número de vagas restantes por hora.
4. O usuário escolhe um horário e dia disponível.
5. O sistema verifica se o horário ainda tem vagas.
6. Se disponível, o pedido é agendado para o horário escolhido e o agendamento recebe um `código` sequencial, único e imutável.
7. O status do pedido muda para `"Agendado"`.
8. O sistema registra o horário, a data, o usuário e o pedido.
9. Caso o horário esteja cheio ou fora das regras, o sistema rejeita e informa o usuário.

### **Critérios de aceite:**

- Apenas pedidos com status `"Aprovado"` ou `"Pendente"` podem ser agendados.
- Apenas o criador do pedido pode agendar.
- O sistema aplica as configurações de janela de horário e dias permitidos.
- O sistema permite agendar apenas nos próximos 15 dias, a partir do dia atual.
- O sistema não permite agendar para a janela vigente (caso o usuário esteja dentro de uma janela de agendamento).
- Todas as janelas, antecedências e limites são calculados no **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)), independentemente do fuso do usuário.
- O agendamento **não valida nem reserva saldo**; a verificação de saldo ocorre na execução ([PAE-026](../04-estoque/pae-026-marcar-pedido-de-movimentacao-como-executado.md)/[PAE-030](pae-030-registrar-execucao-nao-realizada-do-pedido.md)).
- O sistema exibe corretamente horários disponíveis e vagas restantes.
- O sistema rejeita agendamentos fora da janela, em dias não permitidos ou com limite excedido.
- O status do pedido muda para `"Agendado"` após o agendamento.
- O agendamento recebe um `código` sequencial, único e imutável (como o do pedido), exibido onde o agendamento aparece.
- O sistema registra data/hora, usuário e pedido.
- Um pedido não pode ter **dois agendamentos ativos ao mesmo tempo** (o reagendamento é permitido quando o pedido volta para `"Pendente"`).
- Erros de concorrência são tratados no backend para evitar overbooking.

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
