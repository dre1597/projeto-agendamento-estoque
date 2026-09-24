# Padrão: Ativar / Inativar

Alteração de status (ativo/inativo) sem excluir o registro.

## Quando usar

Quando o acesso/uso de um registro precisa ser ligado/desligado preservando o histórico.

## Template

```markdown
# [PAE-XXX] Ativar e inativar <entidade>

### **Descrição:**
Controlar o uso sem remover do banco.

### **Objetivo:**
Permitir que <papel> ative/inative <entidade> sem excluí-la.

### **História:**
Como <papel>,
Quero ativar ou inativar <entidade>,
Para gerenciar o acesso sem perder o histórico.

### **Fluxo principal:**
1. <Papel> acessa a listagem.
2. Para cada item há a opção de ativar/inativar.
3. O sistema pede confirmação: "Tem certeza que deseja [ativar/inativar]...?"
4. Após confirmar, o status é atualizado.
5. Inativos permanecem listados, mas bloqueados para uso.

### **Critérios de aceite:**
- A listagem exibe ativos e inativos.
- É possível ativar/inativar individualmente.
- A ação exige confirmação.
- O efeito do status inativo é respeitado conforme a entidade.
- O status é refletido imediatamente.
- O sistema previne ações repetidas (ex.: inativar já inativo).
```

## Regras típicas

- Toggle individual com **confirmação**.
- Inativos **permanecem listados**; o efeito do status inativo varia por entidade.
- Prevenir ação redundante.
- Refletir status imediatamente.

## Checklist

- [ ] Confirmação descrita.
- [ ] Efeito do status inativo definido.
- [ ] Prevenção de ação repetida.
- [ ] Reflexo imediato na listagem.

## Exemplo real

`docs/especificacoes/01-usuarios/pae-005-ativar-e-inativar-usuarios.md` — inativos não fazem login
e continuam na listagem.
