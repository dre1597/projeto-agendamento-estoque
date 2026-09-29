# Padrão de plano: Criar

Plano de implementação para o cadastro de uma nova entidade.

## Quando usar

Quando a história cria uma nova instância de uma entidade (usuário, setor, produto...).

## Template

````markdown
# Plano — [PAE-XXX] Criar <entidade>

Escopo: <o que esta história entrega; o que fica para outras histórias>.

## Build

- <dependência a adicionar>.

## Estrutura

```text
com/example/inventory/
  common/
    domain/
    web/
  <feature>/
    domain/
    application/
    web/
```

Obs: <regras de organização dos arquivos>.

## Modelo de dados

Entidade `<Entidade>` -> tabela `<tabela>`:

| Campo     | Tipo     | Regra     |
| --------- | -------- | --------- |
| `<campo>` | `<tipo>` | `<regra>` |

`<Enum>`: `<valores>`.
`<Repository>`: `<métodos>`.

## Contrato

`<MÉTODO> /<rota>`

**Request**

| Campo     | Tipo     | Padrão    |
| --------- | -------- | --------- |
| `<campo>` | `<tipo>` | `<padrão>` |

**Response `<status>`**

| Campo     | Tipo     |
| --------- | -------- |
| `<campo>` | `<tipo>` |

<Nunca expor campos sensíveis.>

**Erros**

Corpo `ApiError` (`code`, `message` em inglês, `params`). O use case lança `DomainException`; o
`ApiExceptionHandler` monta a resposta.

| Status   | `code`   | `params`   |
| -------- | -------- | ---------- |
| `<status>` | `<CODE>` | `<params>` |

## Validação

No `<UseCase>`, nesta ordem:
1. <passo>.

Cada falha lança `DomainException` com `code` e `params`. <Mapear violação de constraint, se houver.>

## Fluxo de execução

`<UseCase>.execute`, em ordem:
1. recebe o input;
2. valida (ver "Validação");
3. <passos>;
4. devolve o output.

## Testes

**`<UseCase>` (unitário)**
- <caminho feliz>;
- <limites>;
- <erros e ordem da validação>.

**`<Repository>` (integração)**
- <constraints>.

**`<Controller>` (MockMvc, `<MÉTODO> /<rota>`)**
- `<status>` de sucesso;
- cada `code` de erro com status e params;
- formato do corpo de erro.

## Dependências futuras

- [PAE-XXX](<caminho>): <dependência>.

## Fora de escopo

- <o que não entra>.
````

## Regras típicas

- **Escopo explícito**: o endpoint da história entra; UI e histórias futuras ficam de fora.
- **API em inglês**, incluindo mensagens. Erro com `code` estável + `params`; o front traduz pelo `code`.
- **Validação no use case**, com a ordem declarada.
- **Unicidade garantida no banco**, com fallback da violação de constraint para a corrida de concorrência.
- **DTOs como records aninhados** na classe que os usa.
- **Testes por nível**: use case, repositório e controller. Cobrir limites e caminhos de erro, sem repetir casos triviais.
- **Histórias futuras** entram só como dependência, com link para o card e, quando couber, um TODO no ponto de extensão.

## Checklist

- [ ] Escopo declarado (o que entra e o que fica de fora).
- [ ] Dependências de build listadas.
- [ ] Estrutura de arquivos definida.
- [ ] Modelo de dados com regra por campo.
- [ ] Contrato com request, response e tabela de erros.
- [ ] Validação com ordem explícita.
- [ ] Fluxo de execução numerado.
- [ ] Testes por nível, com limites e erros.
- [ ] Dependências futuras com link para os cards.
- [ ] Fora de escopo listado.

## Exemplo real

`../pae-001-criar-usuarios.md` — criação de usuário com username único, senha com hash e flag de
troca de senha no primeiro login.
