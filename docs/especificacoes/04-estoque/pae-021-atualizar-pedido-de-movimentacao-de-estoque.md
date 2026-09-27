# [PAE-021] Atualizar pedido de movimentação de estoque

### **Descrição:**

Enquanto o pedido está em preparação, o criador pode ajustar seus dados. Depois de enviado para requisição, não pode mais ser editado.

### **Objetivo:**

Permitir que o criador ajuste o pedido enquanto ele estiver em preparação.

### **História:**

Como criador de um pedido de movimentação,
Quero editar o pedido enquanto ele estiver em preparação,
Para ajustar qualquer dado antes de enviá-lo para verificação.

### **Fluxo principal:**

1. Criador acessa os detalhes do pedido ([PAE-042](pae-042-visualizar-pedido-de-movimentacao-de-estoque.md)).
2. Se o status for `"Em Preparação"`:
   - Os campos ficam editáveis: tipo (adição/remoção/verificação), produto, quantidade (inteiro positivo), razão (3 a 100 caracteres) e observação (opcional, até 500 caracteres).
   - Um botão permite salvar as alterações.
3. Se o status não for `"Em Preparação"`, a edição não é permitida.
4. O sistema valida os campos com as mesmas regras da criação ([PAE-019](pae-019-criar-pedido-de-movimentacao-de-estoque.md)) e salva.

### **Critérios de aceite:**

- Apenas o criador pode editar o pedido.
- A edição só é possível enquanto o status for `"Em Preparação"`.
- Os campos editáveis são: tipo, produto, quantidade, razão e observação, com as mesmas validações da criação ([PAE-019](pae-019-criar-pedido-de-movimentacao-de-estoque.md)).
- O sistema salva as alterações e reflete na listagem.
- Mensagens de erro iguais às da criação ([PAE-019](pae-019-criar-pedido-de-movimentacao-de-estoque.md)).

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
