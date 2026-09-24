# Padrão: Excluir

Remoção controlada de um registro.

## Quando usar

Quando é preciso remover um registro, respeitando integridade e vínculos.

## Template

```markdown
# [PAE-XXX] Excluir <entidade>

### **Descrição:**
Riscos de integridade e segurança ao remover registros.

### **Objetivo:**
Permitir que <papel> exclua <entidade> que não esteja em uso.

### **História:**
Como <papel>,
Quero excluir <entidade> que não estão em uso,
Para manter o cadastro limpo sem comprometer dados vinculados.

### **Fluxo principal:**
1. <Papel> acessa a listagem.
2. Clica para excluir individualmente.
3. O sistema pede confirmação: "Tem certeza que deseja excluir... Esta ação não pode ser desfeita."
4. Se confirmado:
   - Verifica se o registro está em uso.
   - Se estiver, bloqueia e informa o motivo.
   - Se não, exclui.
5. A listagem é atualizada.

### **Critérios de aceite:**
- Exclusão é individual (sem seleção múltipla).
- Exige confirmação antes de excluir.
- Impede a exclusão se o registro estiver vinculado.
- Exibe mensagem clara ao bloquear.
- Remove corretamente quando permitido e atualiza a listagem.
```

## Regras típicas

- **Individual**, sem múltipla seleção.
- **Confirmação** com aviso de irreversibilidade.
- **Verificação de vínculo** antes de excluir; bloquear se em uso.
- Mensagem clara do motivo do bloqueio.
- Atualização imediata da listagem.
- Autorização (geralmente administrador).

## Checklist

- [ ] Confirmação obrigatória descrita.
- [ ] Regra de bloqueio por vínculo definida.
- [ ] Mensagem de bloqueio descrita.
- [ ] Exclusão individual.
- [ ] Listagem atualizada.

## Exemplo real

`docs/01-usuarios/pae-003-excluir-usuarios.md` — exclusão individual, com
confirmação e bloqueio se o usuário estiver vinculado a registros/processos ativos.
