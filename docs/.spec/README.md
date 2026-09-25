# Kit de especificação

Padrões pra escrever specs de features no mesmo formato, de forma que uma IA consiga
implementar e uma pessoa consiga revisar. Aplicável a qualquer feature do projeto.

A ideia central: a spec descreve **comportamento**, não implementação. Toda spec
segue cinco seções fixas — Descrição, Objetivo, História, Fluxo principal e Critérios
de aceite — e cada tipo de feature tem um padrão que define o que preencher nelas.

## Como usar

1. Leia o [padrão geral](./padrao-geral.md) — estrutura, convenções, não-objetivos
   e regras comuns.
2. Identifique o tipo da feature e abra o padrão correspondente em [`padroes/`](./padroes).
3. Copie o template, preencha e valide os critérios de aceite.

## Conteúdo

- [`padrao-geral.md`](./padrao-geral.md) — estrutura base, convenções, não-objetivos e regras transversais
- `padroes/` — um padrão por tipo de feature:
  - [`criar.md`](./padroes/criar.md)
  - [`listar.md`](./padroes/listar.md)
  - [`atualizar.md`](./padroes/atualizar.md)
  - [`visualizar.md`](./padroes/visualizar.md)
  - [`excluir.md`](./padroes/excluir.md)
  - [`ativar-inativar.md`](./padroes/ativar-inativar.md)
  - [`historico-auditoria.md`](./padroes/historico-auditoria.md)
  - [`fluxo-status.md`](./padroes/fluxo-status.md)
  - [`configuracao.md`](./padroes/configuracao.md)

## Glossário

- **Administrador**: perfil com acesso à gestão (usuários, setores, produtos, configurações e decisões do fluxo de estoque).
- **Usuário**: perfil autenticado comum; em pedidos, atua como **criador**.
- **Criador**: usuário que registrou um pedido — algumas ações são exclusivas dele.
- **Status de movimentação**: `Em Preparação`, `Requisitado`, `Em Verificação`, `Aprovado`, `Rejeitado`, `Agendado`, `Pendente`, `Negado`, `Executado`.
- **Prefixo de código**: `PAE` (ex.: `[PAE-001]`).
