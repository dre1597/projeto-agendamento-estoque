# Padrão: Atualizar / Visualizar

Edição de um registro existente e/ou tela de detalhes.

## Quando usar

Quando é preciso alterar dados de um registro ou exibir seus detalhes,
às vezes com edição condicional.

## Template

```markdown
# [PAE-XXX] Atualizar <entidade> / Visualizar <entidade>

### **Descrição:**
Por que os dados precisam ser ajustados ao longo do tempo.

### **Objetivo:**
Permitir que <papel> modifique <campos>, mantendo <regras>.

### **História:**
Como <papel>,
Quero atualizar os dados de <entidade>,
Para <benefício>.

### **Fluxo principal:**
1. <Papel> acessa a listagem/detalhes e seleciona o registro.
2. Altera um ou mais campos: <lista>.
3. Salva.
4. O sistema valida e atualiza o registro.

### **Critérios de aceite:**
- É possível atualizar <campos>.
- <Regras> (ex.: unicidade) continuam válidas após a edição.
- <Condições de edição> respeitadas.
- A listagem reflete as alterações imediatamente.
```

## Regras típicas

- **Edição condicional**: quem pode editar e sob quais condições
  (ex.: só o **criador** e apenas no status `"Em Preparação"`).
- Demais usuários: **somente leitura**.
- **Unicidade** mantida após a edição.
- Validações iguais às da criação.
- Refletir alterações na listagem imediatamente.
- Tela de detalhes exibe quem criou, quando e o status atual.

## Checklist

- [ ] Campos editáveis listados.
- [ ] Condições de edição (quem/quando) declaradas.
- [ ] Modo somente leitura definido para não autorizados.
- [ ] Validações mantidas.
- [ ] Reflexo na listagem.

## Exemplo real

`docs/especificacoes/01-usuarios/pae-002-atualizar-usuarios.md` e
`docs/especificacoes/04-estoque/pae-021-visualizar-e-editar-pedido-de-movimentacao-de-estoque.md`
(edição só pelo criador enquanto `"Em Preparação"`).
