# Padrão geral de especificação

Toda spec de feature segue a estrutura abaixo. Os padrões em [`padroes/`](./padroes)
detalham o que colocar em cada seção, por tipo de feature.

## Estrutura obrigatória

```markdown
# [PAE-XXX] Nome curto da feature

### **Descrição:**
Contexto e porquê da feature. Explique o problema em 1–3 parágrafos.

### **Objetivo:**
O que a feature entrega, em uma frase.

### **História:**
Como <papel>,
Quero <ação>,
Para <benefício>.

### **Fluxo principal:**
Passos numerados, do gatilho ao resultado. Inclua validações e mensagens exibidas.

### **Critérios de aceite:**
- Lista de condições verificáveis (uma por linha).
```

## Convenções

- Idioma: português (pt-BR).
- Título: código no formato `[PAE-XXX]` + nome no infinitivo/imperativo.
- Campos e status como inline code do Markdown, ex.: `username`, `"Aprovado"`.
- Mensagens de confirmação/erro entre aspas e, quando exibidas ao usuário, em **negrito**.
- Critérios de aceite: verificáveis, sem "etc."; use bullets `-`.
- Fluxos longos podem aninhar sub-passos.

## Fora de escopo (não-objetivos)

A spec descreve **comportamento**, não implementação. Em geral ficam de fora:

- tecnologia, framework, linguagem;
- modelagem de banco, índices, migrations;
- bibliotecas e serviços de terceiros;
- detalhes de estilo/UI.

O limite não é rígido: quando um detalhe técnico existe por causa de um
comportamento esperado, ele é da spec. O que decide é o comportamento, não a
tecnologia envolvida.

## Regras transversais

Aplique quando fizer sentido na feature:

- **Autorização**: diga explicitamente *quem* pode fazer a ação (administrador, usuário, criador).
- **Confirmação**: ações destrutivas ou irreversíveis pedem confirmação explícita antes.
- **Auditoria**: registrar quem fez, quando (data/hora) e o que mudou (valor anterior → novo).
- **Listagens**: paginação, filtros e ordenação processados **no backend**; itens por página 10/25/50.
- **Consistência de status**: spec de workflow documenta a máquina de estados completa — status canônicos + tabela `de → para` com quem dispara cada transição — não só a ação isolada (ver [`padroes/fluxo-status.md`](./padroes/fluxo-status.md)).
- **Validação de entrada**: campos obrigatórios, unicidade, limites e tipos; mensagens de erro claras.
- **Recomendações gerais ([PAE-000])**: i18n (pt/en/es), suporte a fusos horários, tema claro/escuro, responsividade (TV→celular), métricas de queries e acesso externo aos logs da API.

## Checklist geral

- [ ] Título com código `[PAE-XXX]` e nome claro.
- [ ] Descrição, Objetivo e História preenchidos.
- [ ] Fluxo principal cobre caminhos felizes e de erro.
- [ ] Critérios de aceite verificáveis, um por bullet.
- [ ] Permissões (quem pode) declaradas.
- [ ] Confirmação para ações destrutivas/irreversíveis.
- [ ] Auditoria definida (quem/quando/o quê).
- [ ] Validações de entrada e mensagens de erro descritas.
