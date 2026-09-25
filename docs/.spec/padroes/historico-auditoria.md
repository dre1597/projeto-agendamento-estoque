# Padrão: Histórico / Auditoria

Registro e consulta de alterações de um registro.

## Papel do histórico

O histórico é a base de **auditoria** do sistema: é o que permite saber, depois do
fato, **quem** fez o quê, **quando** e **por quê**.

Ele serve para:
- **Rastrear** as mudanças e reconstruir como um registro chegou ao estado atual.
- **Responsabilizar**: apontar o autor de cada ação.
- **Provar**: guardar o registro de ações sensíveis (ex.: uma exclusão, com a razão informada).

Por isso o histórico é:
- **imutável** — eventos não podem ser editados nem removidos;
- **global** — pertence à base da entidade e **sobrevive à exclusão** do registro;
- **automático** — o sistema descreve o evento; o usuário só informa a razão quando ela é exigida (ex.: exclusão).

## O que vai para o histórico

Toda a vida do registro entra no histórico — não só uma parte dela. São **quatro** os
eventos que precisam ser registrados, e nenhum deles pode ficar de fora:

- **Criação**: o registro nasce; fica o evento inicial com quem criou, quando, e os valores iniciais.
- **Edição**: cada alteração de campo gera um evento com **campo**, **valor anterior** e **valor novo**.
- **Mudança de status**: cada transição é registrada com o status **de → para** e quem disparou.
- **Exclusão**: a remoção também é um evento, com a **razão** informada por quem excluiu.

Juntos, esses quatro eventos contam a história completa da entidade, do nascimento à
exclusão. Deixar qualquer um de fora quebra a auditoria: um registro sem a criação não
tem origem, sem a exclusão fica "eterno", e sem status/edição perde as mudanças do meio.

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
1. Toda alteração de <entidade> gera um evento no histórico — criação, edição, mudança de status ou exclusão. Cada evento registra:
   - Quem fez (usuário autenticado).
   - Data e hora.
   - O que mudou: valores iniciais (criação), valor anterior → valor novo (edição), de → para (mudança de status) ou a razão informada (exclusão).
2. Na tela de detalhes/edição, é possível acessar o histórico.
3. O histórico é exibido em ordem cronológica.

### **Critérios de aceite:**
- Criação, edição, mudança de status e exclusão geram evento no histórico.
- O histórico salva campo, valor anterior, valor novo, data/hora e responsável.
- A exclusão registra a razão informada por quem excluiu.
- Consulta restrita a <papel>.
- Ordenado do mais recente para o mais antigo.
```

## Regras típicas

- Cobrir **os quatro eventos**: criação, edição, mudança de status e exclusão.
- Guardar: **campo**, **valor anterior**, **valor novo**, **data/hora**, **responsável**.
- Ordenação do mais recente para o mais antigo.
- Acesso restrito (ex.: administradores).

## Checklist

- [ ] Criação, edição, mudança de status e exclusão cobertos.
- [ ] Dados registrados definidos.
- [ ] Ordenação definida.
- [ ] Permissão de consulta declarada.

## Exemplo real

`docs/especificacoes/01-usuarios/pae-006-rastrear-historico-de-alteracoes-de-usuarios.md`.
