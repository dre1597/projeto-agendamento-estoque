# AGENTS.md — inventory-api

Regras de trabalho: `AGENTS.md` da raiz.
Especificação do sistema: `docs/especificacoes/`.

Código em inglês; specs e mensagens em pt-BR.

## Dúvidas

- Diante de ambiguidade ou de mais de uma abordagem, não assuma: pergunte antes de escrever ou implementar.
- Se houver uma recomendação, diga qual é e por quê, mas não decida sozinho.

## Escrita

- Comece pelo conteúdo. Sem introdução e sem preâmbulo.
- Não escreva contexto que já está no próprio documento.
- Não escreva frase que não muda nenhuma decisão.
- Cada seção trata só do seu assunto.
- Seja explícito. Escreva a informação por inteiro; não omita para encurtar.

## Java

- Enum carrega um campo de string explícito (`value` ou `code`). A constante Java fica em maiúsculo (`ACTIVE`); banco e API usam o campo (ex.: `active`). Use o campo em vez de `.name()`.
- Enum com valor próprio é persistido com `AttributeConverter` + `@Convert` no campo.
- Use `var` em variável local quando o lado direito já mostra o tipo (`var user = new User(...)`) ou quando saber o tipo exato não agrega. Mantenha o tipo explícito só quando o lado direito não revela o tipo e ele for necessário pra leitura.

## API e erros

- API toda em inglês, incluindo mensagens.
- Erro com `code` estável + `params`; o front traduz pelo `code`.
- Limites (min, max, etc.) vão em `params`.
