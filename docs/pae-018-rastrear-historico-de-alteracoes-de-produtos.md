# [PAE-018] Rastrear histórico de alterações de produtos

- **Área:** PRODUTOS
- **Lista:** Backlog
- **Trello:** https://trello.com/c/ohoTkLLr/17-pae-018-rastrear-hist%C3%B3rico-de-altera%C3%A7%C3%B5es-de-produtos

---

### **Descrição:**

Produtos precisam ter um histórico completo de alterações, incluindo quem fez, quando fez e o que foi alterado, para garantir rastreabilidade e auditoria.

### **Objetivo:**

Registrar e exibir as mudanças feitas nos produtos ao longo do tempo, garantindo visibilidade total das ações realizadas no sistema.

### **História:**

Como usuário do sistema,
Quero visualizar o histórico de alterações de um produto,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um produto for criado ou atualizado:
   - O sistema registra automaticamente:
     - Quem fez a alteração (usuário autenticado).
     - Data e hora.
     - Quais campos foram alterados.
     - Valor anterior → valor novo.
2. Na tela de detalhes ou edição do produto, o usuário pode acessar o histórico.
3. O histórico exibe os eventos de forma cronológica.

### **Critérios de aceite:**

- Cada alteração de produto gera um registro no histórico.
- O histórico salva: campo alterado, valor anterior, valor novo, data/hora, e usuário responsável.
- A criação do produto também gera um evento no histórico.
- O histórico pode ser consultado por qualquer usuário autenticado.
- O histórico é ordenado do mais recente para o mais antigo.
