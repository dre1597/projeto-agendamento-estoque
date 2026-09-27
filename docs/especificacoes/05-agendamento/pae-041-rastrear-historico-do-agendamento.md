# [PAE-041] Rastrear histórico de agendamentos

### **Descrição:**

A base de agendamentos precisa de um log de alterações — quando foi agendado, por quem, para quando, se foi cancelado e qual o resultado da execução — para dar rastreabilidade ao ciclo do agendamento. O log pertence à base de agendamentos (não a um agendamento específico), então permanece no tempo.

### **Objetivo:**

Registrar e exibir os eventos dos agendamentos ao longo do tempo, cobrindo agendamento, cancelamento e execução.

### **História:**

Como usuário do sistema,
Quero visualizar o histórico de um agendamento,
Para entender o que aconteceu com ele, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um agendamento for criado, cancelado ou executado:
   - O sistema registra automaticamente:
     - Quem fez (pelo `username`) e o agendamento afetado (pelo `código`).
     - Data e hora (no **horário do sistema**).
     - Descrição automática do evento:
       - Agendado: o horário escolhido.
       - Cancelado: o cancelamento do agendamento.
       - Executado: o resultado (realizado ou não realizado) e a razão, quando houver.
2. Na tela de detalhes do agendamento ([PAE-043]), o usuário pode acessar o histórico.
3. O histórico exibe os eventos do mais recente para o mais antigo.

### **Critérios de aceite:**

- Cada evento do agendamento gera um registro no histórico.
- O histórico salva: agendamento afetado (pelo `código`), quem fez, data/hora e a descrição do evento, com a razão quando houver.
- Agendamento, cancelamento e execução geram evento no histórico.
- A execução registra o resultado (realizado ou não realizado) e a razão, quando houver.
- O histórico pertence à **base de agendamentos** (global) e permanece para auditoria.
- A data/hora dos eventos é a do **horário do sistema** ([PAE-045]).
- O histórico pode ser consultado por qualquer usuário autenticado.
- O histórico é ordenado do mais recente para o mais antigo.
- O histórico é imutável: seus registros não podem ser editados nem excluídos.
