# [PAE-028] Configurar regras de agendamento de movimentação no estoque

- **Área:** AGENDAMENTO
- **Lista:** Backlog
- **Trello:** https://trello.com/c/xSEoUN3J/29-pae-028-configurar-regras-de-agendamento-de-movimenta%C3%A7%C3%A3o-no-estoque

---

### Descrição:

Permitir que o administrador configure os dias da semana em que o estoque aceita agendamento, a janela de horário permitida para execução e a data a partir da qual essa configuração será aplicada (mínimo 15 dias a partir da data atual).

Ao selecionar os dias da semana (ex: segunda, quarta e sexta), a configuração de janela de horário (ex: 20h às 4h) aplica-se começando na hora definida no dia selecionado e se estende até a hora final do dia seguinte, ou seja, segunda-feira das 20h até terça-feira às 4h, quarta das 20h até quinta às 4h, e assim por diante.

_“Exemplo: selecionar segunda com horário 20h–4h significa da segunda-feira às 20h até terça-feira às 4h.”_

### Objetivo:

Dar controle ao administrador para definir quando e como os agendamentos podem ocorrer, garantindo que as regras só valham a partir de uma data futura para planejamento e evitar conflitos com agendamentos já feitos.

### História:

Como administrador do sistema,
Quero configurar os dias da semana disponíveis para agendamento, a janela de horários permitida e a data inicial para aplicar essa configuração,
Para controlar o funcionamento do agendamento e permitir que os usuários planejem suas execuções conforme regras claras.

### Fluxo principal:

1. Administrador acessa a tela de configurações de agendamento.
2. Visualiza e pode selecionar quais dias da semana estarão habilitados para agendamento (ex: segunda, quarta e sexta).
3. Define a janela de horário permitida para execução no estoque (ex: das 20h às 4h).
4. Define a data a partir da qual a configuração entrará em vigor, respeitando o mínimo de 15 dias à frente da data atual.
   1. O sistema valida que a duração entre o horário inicial e final da janela está entre 1h e 8h, considerando que a janela pode ultrapassar a meia-noite. Se inválido, a configuração não é salva e o usuário é informado.
5. Salva a configuração.
6. O sistema valida que a data inicial está no mínimo 15 dias à frente.
7. O sistema registra a configuração e a torna efetiva a partir da data definida.

### Critérios de aceite:

- Apenas administradores podem acessar e modificar a configuração.
- Os dias da semana podem ser selecionados individualmente.
- A janela de horário deve aceitar intervalos válidos dentro de 24h (com suporte a horário que ultrapassa meia-noite, ex: 20h-4h).
- A data inicial para aplicar a configuração deve ser no mínimo 15 dias no futuro, caso contrário o sistema rejeita.
- Após salvar, a configuração fica ativa somente a partir da data definida.
- A configuração anterior permanece válida até a data de início da nova configuração.
- Validação de entradas deve impedir configuração inválida (ex: intervalo horário invertido, data inválida).
- A configuração de janela de horário que ultrapassa a meia-noite deve ser interpretada como início no dia selecionado e término no dia seguinte.
- A duração da janela de horário deve ser no mínimo 1 hora e no máximo 8 horas, mesmo considerando que ultrapasse a meia-noite.
- O sistema rejeita configurações fora dessa faixa e exibe mensagem de erro clara para o administrador.
