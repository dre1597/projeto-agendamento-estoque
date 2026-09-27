# [PAE-025] Avaliar pedido de movimentação: Aprovar, Rejeitar ou Ajustar

### **Descrição:**

Após a análise de um pedido em verificação, o administrador pode aprová-lo, rejeitá-lo ou, caso encontre necessidade de correção, devolvê-lo ao estado de preparação para que o criador ajuste as informações.

### **Objetivo:**

Dar ao administrador três opções claras ao finalizar a análise de um pedido: aprovar, rejeitar ou devolver para ajustes, mantendo controle total do fluxo e garantindo rastreabilidade das decisões.

### **História:**

Como administrador do sistema,
Quero aprovar, rejeitar ou devolver pedidos em verificação,
Para concluir a análise ou solicitar ajustes antes da decisão final.

### **Fluxo principal:**

1. Administrador acessa a tela de detalhes de um pedido com status `"Em Verificação"`.
2. Três botões são exibidos:
   - **Aprovar pedido**
   - **Rejeitar pedido**
   - **Devolver para ajuste**
3. Para cada ação:
   - O sistema solicita confirmação com mensagem clara.
   - A ação é registrada com data/hora e quem realizou.
   - O status do pedido é alterado conforme a ação:
     - **Aprovado:** segue o fluxo para agendamento e execução.
     - **Rejeitado:** o pedido é encerrado como inválido.
     - **Devolver para ajuste:** o status volta para `"Em Preparação"`, mas **o pedido não poderá mais ser excluído**, mesmo nesse estado.

### **Critérios de aceite:**

- Apenas administradores visualizam os três botões na tela de detalhes quando o pedido estiver em `"Em Verificação"`.
- Cada ação exige confirmação explícita antes de ser realizada.
- A ação executada é registrada com data/hora e usuário responsável.
- "Devolver para ajuste" volta o pedido para `"Em Preparação"`, mas bloqueia a exclusão mesmo sendo esse o status atual.
- "Aprovar" altera o status para `"Aprovado"` e bloqueia edições.
- "Rejeitar" altera o status para `"Rejeitado"` e bloqueia edições.
- O status atual é refletido corretamente na listagem e nos detalhes.
- Nenhuma dessas ações pode ser realizada fora do status `"Em Verificação"`.

### **Máquina de estados (contexto):**

| De | Para | Quem dispara | Ação |
|---|---|---|---|
| — | `Em Preparação` | criador | Criar pedido |
| `Em Preparação` | `Em Preparação` | criador | Editar |
| `Em Preparação` | *(excluído)* | criador | Remover (só se nunca saiu daqui) |
| `Em Preparação` | `Requisitado` | criador | Requisitar |
| `Requisitado` | `Em Verificação` | administrador | Iniciar verificação |
| `Em Verificação` | `Aprovado` | administrador | Aprovar |
| `Em Verificação` | `Rejeitado` | administrador | Rejeitar (fim) |
| `Em Verificação` | `Em Preparação` | administrador | Devolver para ajuste |
| `Aprovado` | `Agendado` | criador | Agendar |
| `Agendado` | `Pendente` | criador | Cancelar agendamento |
| `Agendado` | `Executado` | executor | Registrar execução realizada (fim) |
| `Agendado` | `Pendente` | executor | Registrar execução não realizada (com razão) |
| `Pendente` | `Agendado` | criador | Reagendar / executar de novo |
| `Pendente` | `Negado` | administrador | Negar (fim) |

Estados finais: `Executado`, `Rejeitado`, `Negado`. Transitório: `Pendente`.
