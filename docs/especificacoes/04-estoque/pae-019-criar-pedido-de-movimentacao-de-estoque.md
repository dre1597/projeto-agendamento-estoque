# [PAE-019] Criar pedido de movimentação de estoque

### **Descrição:**

Movimentações no estoque passam por um processo de requisição e aprovação. O pedido pode ser de três tipos: **adição**, **remoção** ou **verificação**. Adição e remoção mexem no saldo (na execução); a verificação é uma conferência e **não mexe no saldo**.

### **Objetivo:**

Registrar pedidos de movimentação de produtos, com status inicial controlado, para posterior verificação, aprovação e execução.

### **História:**

Como usuário do sistema,
Quero criar um pedido de movimentação de estoque,
Para registrar a solicitação de adição, remoção ou verificação de itens.

### **Fluxo principal:**

1. Usuário autenticado acessa a tela de nova movimentação.
2. Preenche os campos obrigatórios:
   - Tipo da movimentação: adição, remoção ou verificação.
   - Produto.
   - Quantidade (na verificação, a quantidade contada).
   - Razão da movimentação (3 a 100 caracteres).
   - Observação (opcional, até 500 caracteres).
3. Salva o pedido.
4. O sistema:
   - Valida os campos obrigatórios e o tipo da quantidade (inteiro positivo).
   - Gera um `código` sequencial, único e imutável para o pedido.
   - Persiste o pedido com status `"Em Preparação"`, vinculado ao criador e com data/hora.
   - Exibe o pedido na listagem.
5. O pedido fica disponível para ajuste pelo criador ([PAE-021]) e, depois, para requisição ([PAE-023]).

### **Sobre a verificação:**

- É uma **conferência**: registra a contagem física e as observações, e **não altera o saldo**.
- O sistema **não compara** a contagem com o saldo, **não calcula divergência**, **não gera relatório** e **não marca nada automaticamente** — o detalhamento (ex.: "real 8, sistema 10") é descritivo, vai na observação.
- O administrador pode sinalizar manualmente que a verificação `"requer ajuste"` ([PAE-044]); o ajuste, quando houver, é criado **manualmente** como um pedido de adição/remoção.

### **Critérios de aceite:**

- O pedido pode ser do tipo **adição**, **remoção** ou **verificação**.
- Os campos obrigatórios são: tipo, produto, quantidade e razão.
- A `quantidade` é um número **inteiro positivo**.
- A `razão` tem de 3 a 100 caracteres.
- A `observação` é opcional e tem no máximo 500 caracteres.
- Todo pedido recebe um `código` sequencial, **único** e **imutável**, gerado na criação.
- O `código` é a identidade do pedido para os usuários e aparece em todas as telas que envolvem o pedido.
- Na interface, o `código` é exibido com zeros à esquerda (ex.: `0001`), acrescentando dígitos conforme o volume (ex.: `10000`).
- O `código` é separado da chave interna usada no banco (sugestão: chave técnica própria + `código` como identidade de negócio).
- O pedido é criado com status **`Em Preparação`**.
- O pedido guarda o criador e a data/hora de criação.
- O pedido pode ser criado por qualquer usuário autenticado.
- A verificação **não altera o saldo** e **não gera nada automaticamente**.
- Mensagens de erro:
  - campo obrigatório vazio: "Preencha todos os campos obrigatórios";
  - quantidade inválida: "A quantidade deve ser um número inteiro maior que zero";
  - razão fora do tamanho: "A razão deve ter entre 3 e 100 caracteres".
- O novo pedido aparece na listagem após o cadastro.

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
