# Padrão: Visualizar

Tela de detalhes de um registro, em modo somente leitura.

## Quando usar

Quando é preciso consultar os dados de um registro em detalhes, em modo somente
leitura, com acesso ao histórico e às ações da entidade conforme a permissão.

## Template

```markdown
# [PAE-XXX] Visualizar <entidade>

### **Descrição:**
Por que é preciso consultar os dados da entidade em detalhes.

### **Objetivo:**
Permitir que <papel> visualize os dados de <entidade> sem editá-los.

### **História:**
Como <papel>,
Quero visualizar os detalhes de <entidade>,
Para consultar suas informações e o histórico de alterações.

### **Fluxo principal:**
1. <Papel> acessa a listagem.
2. Seleciona um registro e é levado à tela de detalhes.
3. A tela exibe, em modo somente leitura: <campos>.
4. A tela dá acesso ao histórico de alterações (ver [PAE-XXX]).
5. A partir da tela, <papel> pode acionar as ações da entidade conforme sua permissão.

### **Critérios de aceite:**
- A tela de detalhes é acessível a <papel>.
- Os dados são exibidos em modo somente leitura (não editáveis na tela).
- A tela exibe <campos>.
- A tela dá acesso ao histórico de alterações.
- Tendo permissão, é possível executar qualquer ação da entidade a partir dos detalhes.
```

## Regras típicas

- **Somente leitura**: a tela não edita dados diretamente.
- **Hub de ações**: reúne as ações da entidade (editar, ativar/inativar, desbloquear,
  excluir...), liberadas conforme a **permissão** do usuário.
- **Histórico**: dá acesso ao histórico de alterações
  (ver [`historico-auditoria.md`](./historico-auditoria.md)).
- **Permissão de acesso** declarada (quem pode ver os detalhes).

## Checklist

- [ ] Campos exibidos definidos.
- [ ] Permissão de acesso declarada.
- [ ] Modo somente leitura declarado.
- [ ] Acesso ao histórico.
- [ ] Ações disponíveis na tela (conforme permissão).

## Exemplo real

`docs/especificacoes/01-usuarios/pae-036-visualizar-usuario.md`.
