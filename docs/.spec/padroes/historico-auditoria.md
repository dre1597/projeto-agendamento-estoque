# Padrão: Histórico / Auditoria

Registro e consulta de alterações de um registro.

## Quando usar

Quando é preciso rastrear quem alterou o quê e quando.

## Template

```markdown
# [PAE-XXX] Rastrear histórico de alterações de <entidade>

### **Descrição:**
Necessidade de rastreabilidade e auditoria.

### **Objetivo:**
Registrar e exibir as mudanças feitas em <entidade>.

### **História:**
Como <papel>,
Quero visualizar o histórico de alterações de <entidade>,
Para entender o que foi modificado, por quem e quando.

### **Fluxo principal:**
1. Sempre que <entidade> for criada ou atualizada, o sistema registra:
   - Quem fez (usuário autenticado).
   - Data e hora.
   - Campos alterados.
   - Valor anterior → valor novo.
2. Na tela de detalhes/edição, é possível acessar o histórico.
3. O histórico é exibido em ordem cronológica.

### **Critérios de aceite:**
- Cada alteração gera um registro no histórico.
- O histórico salva campo, valor anterior, valor novo, data/hora e responsável.
- A criação também gera um evento.
- Consulta restrita a <papel>.
- Ordenado do mais recente para o mais antigo.
```

## Regras típicas

- Eventos em **criação e atualização** (e transições de status, quando aplicável).
- Guardar: **campo**, **valor anterior**, **valor novo**, **data/hora**, **responsável**.
- Ordenação do mais recente para o mais antigo.
- Acesso restrito (ex.: administradores).

## Checklist

- [ ] Eventos de criação e atualização cobertos.
- [ ] Dados registrados definidos.
- [ ] Ordenação definida.
- [ ] Permissão de consulta declarada.

## Exemplo real

`docs/01-usuarios/pae-006-rastrear-historico-de-alteracoes-de-usuarios.md`.
