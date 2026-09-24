# [PAE-013] Rastrear histórico de alterações de setores

### **Descrição:**

Setores precisam ter um histórico completo de alterações, incluindo quem fez, quando fez e o que foi alterado, para garantir rastreabilidade e auditoria.

### **Objetivo:**

Registrar e exibir as mudanças feitas nos setores ao longo do tempo, garantindo visibilidade total das ações realizadas no sistema.

### **História:**

Como usuário do sistema,
Quero visualizar o histórico de alterações de um setor,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um setor for criado ou atualizado:
   - O sistema registra automaticamente:
     - Quem fez a alteração (usuário autenticado).
     - Data e hora.
     - Quais campos foram alterados.
     - Valor anterior → valor novo.
2. Na tela de detalhes ou edição do setor, o usuário pode acessar o histórico.
3. O histórico exibe os eventos de forma cronológica.

### **Critérios de aceite:**

- Cada alteração de setor gera um registro no histórico.
- O histórico salva: campo alterado, valor anterior, valor novo, data/hora, e usuário responsável.
- A criação do setor também gera um evento no histórico.
- O histórico pode ser consultado por qualquer usuário autenticado.
- O histórico é ordenado do mais recente para o mais antigo.
