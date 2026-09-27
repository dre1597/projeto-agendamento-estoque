# [PAE-045] Relógio do sistema

### **Descrição:**

O sistema opera num fuso de referência — o **"horário do sistema"**. Para evitar confusão com usuários em fusos diferentes, o sistema exibe um relógio no **header global** com o horário do sistema e o horário local do usuário, para comparação.

O rótulo é **"Horário do sistema"** (e não o nome da cidade), pra continuar válido caso o fuso de referência mude.

### **Objetivo:**

Dar clareza sobre o horário do sistema, permitindo comparar com o horário local do usuário.

### **História:**

Como usuário do sistema,
Quero ver o horário do sistema e o meu horário local,
Para não me confundir com fusos ao agendar e executar pedidos.

### **Fluxo principal:**

1. O sistema opera com um fuso de referência — o "horário do sistema" (definição do sistema, não fixo a uma cidade).
2. No header global, é exibido um relógio com:
   - O **horário do sistema**, rotulado como **"Horário do sistema"**.
   - O **horário local do usuário**, rotulado como **"Seu horário"**.
3. Os dois são atualizados continuamente.

### **Critérios de aceite:**

- O sistema opera com um fuso de referência — o "horário do sistema" — definido por **variável de ambiente** (não fica preso ao nome de uma cidade).
- O header global exibe um relógio.
- O relógio mostra o **horário do sistema**, rotulado como "Horário do sistema".
- O relógio mostra também o **horário local do usuário**, para comparação.
- O rótulo é "Horário do sistema" (não o nome da cidade), pra continuar correto se o fuso do sistema mudar.
- Todas as regras que dependem de horário (janelas, antecedências, limites, agendamentos) usam o **horário do sistema**.
- Todo horário **registrado ou exibido** no sistema (históricos, listagens e detalhes) é no **horário do sistema**.
- Ver também as recomendações gerais de fusos horários em [PAE-000](pae-000-recomendacoes-gerais.md).
