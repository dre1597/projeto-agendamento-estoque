# [PAE-006] Rastrear histórico de alterações de usuários

### **Descrição:**

Usuários precisam ter um histórico completo de alterações, incluindo quem fez, quando fez e o que foi alterado, para garantir rastreabilidade e auditoria.

### **Objetivo:**

Registrar e exibir as mudanças feitas nos usuários ao longo do tempo, garantindo visibilidade total das ações realizadas no sistema.

### **História:**

Como administrador do sistema,
Quero visualizar o histórico de alterações de um usuário,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um usuário for criado ou atualizado:
   - O sistema registra automaticamente:
     - Quem fez a alteração (usuário autenticado).
     - Data e hora.
     - Quais campos foram alterados.
     - Valor anterior → valor novo.
2. Na tela de detalhes ou edição do usuário, o administrador pode acessar o histórico.
3. O histórico exibe os eventos de forma cronológica.

### **Critérios de aceite:**

- Cada alteração de usuário gera um registro no histórico.
- O histórico salva: campo alterado, valor anterior, valor novo, data/hora, e usuário responsável.
- A criação do usuário também gera um evento no histórico.
- O histórico pode ser consultado pelos administradores.
- O histórico é ordenado do mais recente para o mais antigo.
