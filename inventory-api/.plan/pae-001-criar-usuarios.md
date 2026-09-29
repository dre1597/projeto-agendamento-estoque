# Plano — [PAE-001] Criar usuários

Escopo: só o endpoint de criação de usuário. UI, login e histórico são outras histórias.

## Build

- Adicionar `org.springframework.security:spring-security-crypto`.

## Estrutura

```
com/example/inventory/
  common/
    domain/
      DomainException.java
    web/
      ApiError.java
      ApiExceptionHandler.java
  user/
    domain/
      User.java
      UserStatus.java
      UserRepository.java
      UserErrorCode.java
    application/
      CreateUserUseCase.java
    web/
      UserController.java
```

Obs: os DTOs do use case e do controller, inicialmente, são records aninhados na própria classe.

## Modelo de dados

Entidade `User` -> tabela `users`:

| Campo                | Tipo         | Regra                                              |
| -------------------- | ------------ | -------------------------------------------------- |
| `id`                 | `Long`       | gerado                                             |
| `username`           | `String`     | obrigatório, único, minúsculo, 3 a 20, `[a-z0-9.]` |
| `passwordHash`       | `String`     | obrigatório, BCrypt                                |
| `mustChangePassword` | `boolean`    | padrão `false`                                     |
| `admin`              | `boolean`    | padrão `false`                                     |
| `status`             | `UserStatus` | padrão `ACTIVE`                                    |

`UserStatus`: `ACTIVE`, `INACTIVE`, `BLOCKED`. Só `ACTIVE` entra nesta história.
`UserRepository`: `JpaRepository<User, Long>` com `existsByUsername(String username)`.

## Contrato

`POST /api/users`

**Request**

| Campo                | Tipo      | Padrão  |
| -------------------- | --------- | ------- |
| `username`           | `string`  | —       |
| `password`           | `string`  | —       |
| `mustChangePassword` | `boolean` | `false` |
| `admin`              | `boolean` | `false` |

**Response `201 Created`**

| Campo      | Tipo      |
| ---------- | --------- |
| `id`       | `integer` |
| `username` | `string`  |
| `status`   | `string`  |
| `admin`    | `boolean` |

Nunca expor a senha.

**Erros**

Corpo `ApiError` (`code`, `message` em inglês, `params`). O use case lança `DomainException`;
o `ApiExceptionHandler` monta a resposta.

| Status | `code`                        | `params`                    |
| ------ | ----------------------------- | --------------------------- |
| `409`  | `USERNAME_ALREADY_IN_USE`     | —                           |
| `400`  | `USERNAME_LENGTH_OUT_OF_RANGE`| `{ "min": 3, "max": 20 }`   |
| `400`  | `USERNAME_INVALID_CHARACTERS` | `{ "pattern": "[a-z0-9.]" }`|
| `400`  | `PASSWORD_RULES_VIOLATION`    | `{ "minLength": 8, "minLetters": 1, "minNumbers": 1, "minSymbols": 1, "allowedSymbols": "!@#$%&*()-_=+.,;:?/" }` |

## Validação

No `CreateUserUseCase`, nesta ordem:
1. normaliza o username para minúsculo e checa unicidade;
2. valida tamanho 3 a 20;
3. valida os caracteres permitidos (letras, números e ponto);
4. valida a senha: mínimo 8, só com letras, números e símbolos do conjunto `!@#$%&*()-_=+.,;:?/`, com pelo menos 1 de cada;
5. exige os campos obrigatórios.

Cada falha lança `DomainException` com `code` e `params`. Mapear também
`DataIntegrityViolationException` para `USERNAME_ALREADY_IN_USE`, cobrindo corrida de concorrência.

## Fluxo de execução

`CreateUserUseCase.execute`, em ordem:
1. recebe o input;
2. valida (ver "Validação");
3. gera o hash BCrypt da senha;
4. monta o `User` com `status = ACTIVE`;
5. salva pelo `UserRepository`;
6. devolve o output.

## Testes

**`CreateUserUseCase` (unitário)**

Caminho feliz:
- cria com username em minúsculo, `status = ACTIVE` e senha em hash BCrypt (não em texto puro);
- devolve o output com `id`, `username`, `status` e `admin`, sem senha;
- username com maiúsculas é persistido e devolvido em minúsculo;
- `mustChangePassword` e `admin` refletem o input.

Unicidade:
- duplicado exato e duplicado diferindo só por caixa (`admin` / `Admin`);
- `DataIntegrityViolationException` no save vira `USERNAME_ALREADY_IN_USE` (corrida de concorrência).

Username:
- limites válidos: 3 e 20 caracteres;
- limites inválidos: 2 e 21 caracteres;
- caracteres fora do permitido: espaço, `_`, `-`, `@`, acento;
- ponto (`.`) é aceito;
- nulo ou vazio cai em `USERNAME_LENGTH_OUT_OF_RANGE`;
- duplicado tem prioridade sobre tamanho inválido (a ordem da validação).

Senha:
- 8 caracteres é válida, 7 é inválida;
- falta só letra, falta só número, falta só símbolo (cada caso isolado);
- símbolo fora do conjunto (`"`, `\`, `<`, `>`) é inválido;
- espaço é inválido;
- nula ou vazia cai em `PASSWORD_RULES_VIOLATION`.

**`UserRepository` (integração)**

- a constraint única de `username` rejeita duplicado no banco.

**`UserController` (MockMvc, `POST /api/users`)**

- `201` com `id`, `username`, `status`, `admin`, sem senha no corpo;
- `mustChangePassword` e `admin` ausentes são aceitos e viram `false`;
- `409` `USERNAME_ALREADY_IN_USE`;
- `400` `USERNAME_LENGTH_OUT_OF_RANGE` com `min`/`max` nos params;
- `400` `USERNAME_INVALID_CHARACTERS` com `pattern` nos params;
- `400` `PASSWORD_RULES_VIOLATION` com os params das regras;
- corpo de erro no formato `ApiError` (`code`, `message` em inglês, `params`).

## Dependências futuras

- [PAE-007](../../docs/especificacoes/01-usuarios/pae-007-login.md): o endpoint passa a exigir admin autenticado.
- [PAE-006](../../docs/especificacoes/01-usuarios/pae-006-rastrear-historico-de-alteracoes-de-usuarios.md): a criação passa a gravar evento de histórico. Deixar TODO no `CreateUserUseCase`.
- [PAE-004](../../docs/especificacoes/01-usuarios/pae-004-listar-usuarios.md): a listagem é daquela história. A resposta de criação já devolve o usuário criado.

## Fora de escopo

Login, autorização, geração de senha, histórico, listagem, atualização, exclusão,
ativar/inativar e visualização. A tradução das mensagens (pt/en/es) é do front, a partir dos códigos.
