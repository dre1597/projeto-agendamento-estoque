# [PAE-006] Rastrear histórico de alterações de usuários

### **Descrição:**

A base de usuários precisa de um log de alterações, incluindo quem fez, quando fez e o que foi alterado, para garantir rastreabilidade e auditoria. O log pertence à base de usuários (não a um usuário específico), então permanece mesmo que um usuário seja excluído.

### **Objetivo:**

Registrar e exibir as mudanças feitas na base de usuários ao longo do tempo, garantindo visibilidade total das ações realizadas.

### **História:**

Como administrador do sistema,
Quero visualizar o histórico de alterações dos usuários,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um usuário for criado, atualizado ou excluído:
   - O sistema registra automaticamente:
     - Quem fez a alteração e o usuário afetado, ambos pelo `username` (string, sem vínculo com o cadastro).
     - Data e hora.
     - Descrição automática do evento:
       - Criação: "o usuário foi criado".
       - Atualização: os campos alterados, com valor anterior → valor novo.
       - Exclusão: "o usuário foi excluído".
     - Campos sensíveis (ex.: `senha`) não guardam o valor real: aparecem como `[senha antiga] → [senha nova]`.
     - Razão do evento: obrigatória na exclusão e no desbloqueio (3 a 500 caracteres), opcional na atualização e não se aplica à criação.
2. Na tela de detalhes do usuário, o administrador pode acessar o histórico.
3. O histórico exibe os eventos do mais recente para o mais antigo.

### **Critérios de aceite:**

- Cada alteração na base de usuários gera um registro no histórico.
- O histórico salva: usuário afetado, campo alterado, valor anterior, valor novo, data/hora, quem fez (username) e a razão do evento (obrigatória na exclusão e no desbloqueio).
- Campos sensíveis (ex.: `senha`) aparecem no histórico como `[senha antiga] → [senha nova]`, sem o valor real.
- A criação do usuário também gera um evento no histórico.
- A exclusão do usuário também é registrada no histórico, incluindo a razão (obrigatória, de 3 a 500 caracteres).
- O histórico sobrevive à exclusão do usuário (usa `username` como string, sem vínculo com o cadastro).
- O histórico pode ser consultado pelos administradores.
- O histórico é ordenado do mais recente para o mais antigo.
- O histórico é imutável: seus registros não podem ser editados nem excluídos.
