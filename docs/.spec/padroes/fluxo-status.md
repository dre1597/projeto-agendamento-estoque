# Padrão: Fluxo de status (transição de estado)

Ações que movem um registro de um status para outro (workflow).

## Quando usar

Quando uma entidade tem estado (`Em Preparação`, `Requisitado`, `Aprovado`...)
e ações mudam esse estado sob regras.

## Template

```markdown
# [PAE-XXX] <Ação> <entidade>

### **Descrição:**
Por que a transição existe e em que ponto do fluxo ela ocorre.

### **Objetivo:**
Permitir que <papel> mova <entidade> de "<status atual>" para "<novo status>".

### **História:**
Como <papel>,
Quero <ação>,
Para <benefício>.

### **Fluxo principal:**
1. <Papel> acessa <entidade> com status "<status atual>".
2. Um botão "<Ação>" é exibido (apenas nas condições válidas).
3. Ao clicar, o sistema pede confirmação: "<mensagem>".
4. Confirmando:
   - O status muda para "<novo status>".
   - A data/hora e o usuário responsável são registrados.
   - Edições/exclusões são bloqueadas/liberadas conforme o caso.
5. Se as condições não forem atendidas, o botão não é exibido / a ação é rejeitada.

### **Critérios de aceite:**
- O botão aparece apenas para <papel> e quando o status for "<status atual>".
- O sistema exige confirmação antes de mudar o status.
- Ao confirmar, o status muda para "<novo status>".
- Registro com data/hora e usuário responsável.
- <Bloqueios/liberações de edição e exclusão>.
- O status é refletido na listagem e nos detalhes.
- Nenhuma ação pode ocorrer fora do status previsto.
```

## Regras típicas

- Declarar **de → para** e **quem** pode.
- **Botão condicional**: só aparece no status e perfil corretos.
- **Confirmação** antes da transição.
- **Registro** (data/hora, usuário, ação).
- **Bloqueios** após certos status (edição/exclusão).
- **Concorrência** tratada no backend (ex.: evitar overbooking).
- Não permitir ação repetida (ex.: agendar duas vezes).

## Máquina de estados (obrigatório)

Cada card documenta uma transição, mas a spec precisa mostrar onde ela se encaixa.
Sem o mapa completo, transições escritas isoladas tendem a divergir. Inclua:

- a lista canônica de status da entidade (valores exatos);
- a tabela completa `de → para` — todas as transições, não só a sua — com quem
  dispara, condição e efeito.

```markdown
### **Máquina de estados:**
| De | Para | Quem | Condição | Efeito |
|----|------|------|----------|--------|
| <status> | <status> | <papel> | <regra> | <efeito> |
```

## Exemplos de transições do board

- `Requisitar um pedido`: `"Em Preparação"` → `"Requisitado"` (criador; bloqueia edição)
  — `docs/04-estoque/pae-023-requisitar-um-pedido.md`
- `Iniciar verificação`: `"Requisitado"` → `"Em Verificação"` (admin)
  — `docs/04-estoque/pae-024-iniciar-verificacao-de-pedido-de-movimentacao-de-estoque.md`
- `Avaliar`: `"Em Verificação"` → `Aprovado` / `Rejeitado` / volta `"Em Preparação"`
  — `docs/04-estoque/pae-025-avaliar-pedido-de-movimentacao-aprovar-rejeitar-ou-ajustar.md`
- `Agendar`: `"Aprovado"` → `"Agendado"` (criador; dentro das regras)
  — `docs/05-agendamento/pae-027-agendar-pedido-de-movimentacao-aprovado-para-execucao-no-estoque.md`
- `Tentativa de execução`: `"Agendado"` → `Executado` / `"Pendente"` / `"Negado"`
  — `docs/05-agendamento/pae-030-tentativa-de-execucao-do-pedido.md`
- `Cancelar agendamento`: `"Agendado"` → `"Pendente"` (criador; antecedência mínima de 1 dia)
  — `docs/05-agendamento/pae-031-cancelar-agendamento-de-pedido-de-movimentacao-de-estoque.md`

## Checklist

- [ ] Transição (de → para) definida.
- [ ] Quem pode executar.
- [ ] Confirmação descrita.
- [ ] Registro de auditoria da transição.
- [ ] Bloqueios de edição/exclusão definidos.
- [ ] Concorrência/ações repetidas tratadas.
- [ ] Máquina de estados completa incluída (status canônicos + tabela `de → para`).
