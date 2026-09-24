# Padrão: Criar

Feature de cadastro de uma nova entidade.

## Quando usar

Quando é preciso registrar uma nova instância de uma entidade (usuário, setor, produto, pedido...).

## Template

```markdown
# [PAE-XXX] Criar <entidade>

### **Descrição:**
O que é a entidade e por que o cadastro é necessário.

### **Objetivo:**
Permitir que <papel> cadastre <entidade> com <campos principais>.

### **História:**
Como <papel>,
Quero cadastrar <entidade> com <campos>,
Para <benefício>.

### **Fluxo principal:**
1. <Papel> acessa a tela de cadastro.
2. Preenche os campos obrigatórios: <lista>.
3. (Opcional) preenche campos opcionais.
4. Salva.
5. O sistema valida e persiste, definindo o <status inicial>.

### **Critérios de aceite:**
- É possível cadastrar <entidade> com <campos>.
- <Campo> é obrigatório / único.
- Validações de tipo e limites respeitadas.
- O registro é criado com <status inicial>.
- O novo registro aparece na listagem após o cadastro.
```

## Regras típicas

- **Campos obrigatórios** explícitos; opcionais identificados.
- **Unicidade** quando aplicável (ex.: `username`, nome/sigla de setor).
- **Numéricos** não negativos e positivos quando fizer sentido (quantidade).
- **Status inicial** definido (ex.: setor `ativo`, pedido `"Em Preparação"`).
- **Limites de tamanho** (ex.: nome ≤100, sigla ≤10, descrição ≤255).
- **Vínculos** com outras entidades (ex.: produto → 1+ setores).
- **Quem pode cadastrar** (ex.: apenas administrador).

## Checklist

- [ ] Campos obrigatórios e opcionais listados.
- [ ] Regras de unicidade declaradas.
- [ ] Status inicial definido.
- [ ] Validações e mensagens de erro descritas.
- [ ] Autorização (quem cadastra) declarada.
- [ ] Registro reflete na listagem após salvar.

## Exemplo real

`docs/especificacoes/01-usuarios/pae-001-criar-usuarios.md` — cadastro com `username` único,
senha manual/gerada (mín. 8 caracteres) e flag de troca de senha no primeiro login.
