# [PAE-013] Rastrear histórico de alterações de setores

### **Descrição:**

A base de setores precisa de um log de alterações, incluindo quem fez, quando fez e o que foi alterado, para garantir rastreabilidade e auditoria. O log pertence à base de setores (não a um setor específico), então permanece mesmo que um setor seja excluído.

### **Objetivo:**

Registrar e exibir as mudanças feitas na base de setores ao longo do tempo, garantindo visibilidade total das ações realizadas.

### **História:**

Como administrador do sistema,
Quero visualizar o histórico de alterações dos setores,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**

1. Toda vez que um setor for criado, atualizado, tiver o status alterado ou for excluído:
   - O sistema registra automaticamente:
     - Quem fez a alteração (pelo `username`) e o setor afetado (pelo identificador `sigla - nome`, ex.: `VD - Vendas`), ambos como texto (string, sem vínculo com o cadastro).
     - Data e hora.
     - Descrição automática do evento:
       - Criação: "o setor foi criado".
       - Atualização: os campos alterados, com valor anterior → valor novo.
       - Mudança de status: de → para (ativo/inativo).
       - Exclusão: "o setor foi excluído".
     - Razão do evento: obrigatória na exclusão (3 a 500 caracteres).
2. Na tela de detalhes do setor, o administrador pode acessar o histórico.
3. O histórico exibe os eventos do mais recente para o mais antigo.

### **Critérios de aceite:**

- Cada alteração na base de setores gera um registro no histórico.
- O histórico salva: setor afetado, campo alterado, valor anterior, valor novo, data/hora, quem fez e a razão do evento (obrigatória na exclusão).
- A criação do setor também gera um evento no histórico.
- A mudança de status (ativar/inativar) gera um evento no histórico.
- A exclusão do setor também é registrada no histórico, incluindo a razão (obrigatória, de 3 a 500 caracteres).
- O histórico sobrevive à exclusão do setor (identificação em texto, sem vínculo com o cadastro).
- O histórico pode ser consultado pelos administradores.
- O histórico é ordenado do mais recente para o mais antigo.
- O histórico é imutável: seus registros não podem ser editados nem excluídos.
