# .spec — Padrões de especificação

Modelos para escrever specs de features novas no mesmo padrão usado no projeto.
Base: board Trello "Projeto agendamento + estoque" (espelhado em `../`).

## Como usar

1. Leia o [padrão geral](./padrao-geral.md) — é a estrutura que toda spec segue.
2. Identifique o tipo da feature e abra o padrão correspondente em [`padroes/`](./padroes).
3. Copie o template, preencha e mantenha os critérios de aceite verificáveis.

## Conteúdo

- [`padrao-geral.md`](./padrao-geral.md) — estrutura base, convenções e regras transversais
- `padroes/`
  - [`criar.md`](./padroes/criar.md)
  - [`listar.md`](./padroes/listar.md)
  - [`atualizar-visualizar.md`](./padroes/atualizar-visualizar.md)
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
