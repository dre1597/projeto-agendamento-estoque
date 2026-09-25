# [PAE-018] Rastrear histórico de alterações de produtos

### **Descrição:**

A base de produtos precisa de um log de alterações, incluindo quem fez, quando fez e o que foi alterado, para garantir rastreabilidade e auditoria. O log pertence à base de produtos (não a um produto específico), então permanece mesmo que um produto seja excluído.

### **Objetivo:**

Registrar e exibir as mudanças feitas na base de produtos ao longo do tempo, garantindo visibilidade total das ações realizadas.

### **História:**

Como usuário do sistema,
Quero visualizar o histórico de alterações dos produtos,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um produto for criado, atualizado ou excluído:
   - O sistema registra automaticamente:
     - Quem fez a alteração (pelo `username`) e o produto afetado (pelo `nome`), ambos como texto (string, sem vínculo com o cadastro).
     - Data e hora.
     - Descrição automática do evento:
       - Criação: "o produto foi criado".
       - Atualização: os campos alterados, com valor anterior → valor novo.
       - Exclusão: "o produto foi excluído".
     - Razão do evento: obrigatória na exclusão (3 a 500 caracteres).
2. Na tela de detalhes do produto, o usuário pode acessar o histórico.
3. O histórico exibe os eventos do mais recente para o mais antigo.

### **Critérios de aceite:**

- Cada alteração na base de produtos gera um registro no histórico.
- O histórico salva: produto afetado, campo alterado, valor anterior, valor novo, data/hora, quem fez e a razão do evento (obrigatória na exclusão).
- A criação do produto também gera um evento no histórico.
- A exclusão do produto também é registrada no histórico, incluindo a razão (obrigatória, de 3 a 500 caracteres).
- O histórico sobrevive à exclusão do produto (identificação em texto, sem vínculo com o cadastro).
- O histórico pode ser consultado por qualquer usuário autenticado.
- O histórico é ordenado do mais recente para o mais antigo.
- O histórico é imutável: seus registros não podem ser editados nem excluídos.
