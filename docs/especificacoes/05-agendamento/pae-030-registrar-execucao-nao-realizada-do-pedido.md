# [PAE-030] Registrar execução não realizada do pedido

### **Descrição:**

Quando o pedido agendado **não é executado**, quem tentou executar registra o que aconteceu, informando a razão. O pedido volta para `"Pendente"` para poder ser reagendado ou executado de novo.

### **Objetivo:**

Permitir que quem executou registre a execução não realizada, com a razão, devolvendo o pedido para `"Pendente"` sem encerrá-lo.

### **História:**

Como usuário que tentou executar o pedido,
Quero registrar que a execução não foi realizada e informar a razão,
Para que o pedido possa ser reagendado ou executado de novo.

### **Fluxo principal:**

1. Usuário que tentou executar acessa os detalhes de um pedido com status `"Agendado"`.
2. Um botão é exibido: **"Marcar como não realizado"**.
3. O sistema exibe uma confirmação: **"Você deseja confirmar que a execução não foi realizada?"**
4. Ao confirmar, o sistema solicita a razão, a partir de uma lista de motivos prontos:
   - "sem estoque"
   - "produto avariado"
   - "produto não encontrado"
   - "quantidade divergente"
   - "outro" (texto livre, de 3 a 100 caracteres)
5. O usuário escolhe (ou digita) a razão e confirma.
6. O sistema:
   - Altera o status do pedido para `"Pendente"`.
   - Registra data/hora (no **horário do sistema**), quem registrou e a razão informada.
   - Devolve o pedido para que possa ser reagendado ou executado de novo ([PAE-027]).
7. Quando a não realização for por falta de saldo (numa remoção), a razão indicada por quem registra é "sem estoque".

### **Critérios de aceite:**

- O botão aparece apenas para pedidos com status `"Agendado"`.
- Qualquer usuário que executou o pedido pode registrar a execução não realizada.
- O sistema exibe a confirmação **"Você deseja confirmar que a execução não foi realizada?"** antes de registrar.
- A razão é obrigatória: um dos motivos prontos ou "outro" com texto de 3 a 100 caracteres.
- O status muda para `"Pendente"` e o pedido fica disponível para novo agendamento/execução.
- O sistema registra data/hora (no **horário do sistema**, [PAE-045]), responsável e a razão.
- A razão é sempre **informada por quem registra**; o sistema não a define sozinho.
- Numa remoção sem saldo, a razão indicada é "sem estoque".

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
