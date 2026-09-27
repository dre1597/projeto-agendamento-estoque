# [PAE-028] Configurar regras de agendamento de movimentação no estoque

### **Descrição:**

O administrador configura os dias da semana em que o estoque aceita agendamento, a janela de horário permitida para execução e a data a partir da qual a configuração será aplicada (mínimo 15 dias a partir da data atual).

Ao selecionar os dias da semana (ex.: segunda, quarta e sexta), a configuração de janela de horário (ex.: 20h às 4h) aplica-se começando no horário definido do dia selecionado e se estende até o horário final do dia seguinte — ou seja, segunda das 20h até terça às 4h, quarta das 20h até quinta às 4h, e assim por diante.

_"Exemplo: selecionar segunda com horário 20h–4h significa da segunda às 20h até terça às 4h."_

Todo horário e prazo são tratados no **horário do sistema** ([PAE-045]).

### **Objetivo:**

Dar controle ao administrador para definir quando e como os agendamentos podem ocorrer, garantindo que as regras só valham a partir de uma data futura e evitando conflitos com agendamentos já feitos.

### **História:**

Como administrador do sistema,
Quero configurar os dias da semana disponíveis para agendamento, a janela de horários permitida e a data inicial para aplicar essa configuração,
Para controlar o funcionamento do agendamento e permitir que os usuários planejem suas execuções conforme regras claras.

### **Fluxo principal:**

1. Administrador acessa a tela de configurações de agendamento.
2. Seleciona quais dias da semana estarão habilitados para agendamento (ex.: segunda, quarta e sexta).
3. Define a janela de horário permitida para execução no estoque (ex.: das 20h às 4h).
4. Define a data a partir da qual a configuração entrará em vigor, respeitando o mínimo de 15 dias à frente da data atual.
5. Salva a configuração.
6. O sistema valida que a data inicial está no mínimo 15 dias à frente e que a janela tem entre 1h e 8h de duração (considerando que pode ultrapassar a meia-noite); se inválido, não salva e informa o usuário.
7. O sistema registra a configuração e a torna efetiva a partir da data definida.

### **Critérios de aceite:**

- Apenas administradores podem acessar e modificar a configuração.
- Os dias da semana podem ser selecionados individualmente.
- A janela de horário deve aceitar intervalos válidos dentro de 24h (com suporte a horário que ultrapassa a meia-noite, ex.: 20h–4h).
- A janela que ultrapassa a meia-noite é interpretada como início no dia selecionado e término no dia seguinte.
- A duração da janela deve ser no mínimo 1 hora e no máximo 8 horas, mesmo ultrapassando a meia-noite.
- A data inicial para aplicar a configuração deve ser no mínimo 15 dias no futuro.
- Após salvar, a configuração fica ativa somente a partir da data definida.
- A configuração anterior permanece válida até a data de início da nova configuração.
- Todas as janelas, datas e prazos são calculados no **horário do sistema** ([PAE-045]), independentemente do fuso do usuário.
- O sistema rejeita configurações inválidas e exibe a mensagem correspondente:
  - data inicial fora do prazo: "A data inicial deve ser no mínimo 15 dias à frente";
  - janela fora da faixa: "A janela deve ter entre 1 e 8 horas";
  - intervalo horário inválido: "Informe um intervalo de horário válido".
