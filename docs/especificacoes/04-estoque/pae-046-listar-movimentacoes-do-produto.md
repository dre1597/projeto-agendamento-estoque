# [PAE-046] Listar movimentações do produto

### **Descrição:**

Na tela de detalhes do produto ([PAE-038](../03-produtos/pae-038-visualizar-produto.md)) é preciso ver o **extrato das movimentações** que de fato mexeram no saldo daquele produto (entradas e saídas aplicadas), pra acompanhar como o saldo atual se formou.

### **Objetivo:**

Exibir o extrato de movimentações de um produto, mostrando o que entrou e o que saiu.

### **História:**

Como usuário do sistema,
Quero ver as movimentações de um produto,
Para entender como o saldo atual foi formado.

### **Fluxo principal:**

1. Usuário autenticado acessa os detalhes do produto ([PAE-038](../03-produtos/pae-038-visualizar-produto.md)).
2. A tela exibe o **extrato de movimentações** daquele produto.
3. A tabela exibe as colunas: tipo (entrada/saída), quantidade, data e o pedido de origem.
4. A lista é ordenada do mais recente para o mais antigo.
5. Quando não houver movimentações, o sistema exibe a mensagem "Nenhum resultado encontrado".

### **Critérios de aceite:**

- O extrato é acessível a qualquer usuário autenticado.
- A tabela exibe tipo (entrada/saída), quantidade, data e pedido de origem.
- A lista é ordenada do mais recente para o mais antigo.
- A data/hora é exibida no **horário do sistema** ([PAE-045](../00-geral/pae-045-relogio-do-sistema.md)).
- Quando não houver movimentações, o sistema exibe a mensagem "Nenhum resultado encontrado".
