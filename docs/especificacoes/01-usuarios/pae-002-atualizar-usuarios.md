# [PAE-002] Atualizar usuários

### **Descrição:**

Usuários têm suas informações básicas de acesso que podem precisar de ajustes ao longo do tempo. A atualização permite corrigir ou alterar dados sem criar novos registros.

### **Objetivo:**

Permitir que o administrador modifique as informações do usuário, como username, senha, mantendo o controle e a segurança.

### **História:**

Como administrador do sistema,
Quero atualizar os dados de um usuário existente,
Para corrigir informações ou ajustar configurações de segurança.

### **Fluxo principal:**

1. Administrador acessa a listagem de usuários.
2. Seleciona o usuário que deseja editar.
3. Altera um ou mais campos:
   - `username` (mantendo a unicidade e o tamanho de 3 a 20 caracteres).
   - `senha` (pode ser manual ou gerada automaticamente; se gerada, aparece no próprio campo de senha).
   - Flag "Solicitar troca de senha no primeiro login" (caso tenha alterado a senha).
   - Checkbox "Administrador" (define se o usuário é administrador).
4. Salva as alterações.
5. O sistema valida:
   - `username` permanece único e com 3 a 20 caracteres.
   - Senha (se alterada) tem no mínimo 8 caracteres e combina letras, números e símbolos.
   - Bloqueia a atualização com a mensagem específica do erro (username duplicado, tamanho do username ou senha fora das regras).
6. Atualiza o registro com os novos dados e registra a alteração no histórico (ver [PAE-006]).

### **Critérios de aceite:**

- É possível atualizar `username`, `senha`, a flag de troca de senha e se um usuário é um administrador ou não.
- `username` continua único e com 3 a 20 caracteres após a edição.
- `username` diferencia maiúsculas de minúsculas (`admin` e `Admin` são usernames distintos).
- Senha nova (manual ou gerada) tem no mínimo 8 caracteres e combina letras, números e símbolos.
- A flag "Solicitar troca de senha no primeiro login" pode ser alterada (caso a senha tenha sido alterada).
- O checkbox "Administrador" pode ser alterado e define se o usuário é administrador.
- Atualização só pode ser feita por administradores.
- A atualização gera um registro no histórico de alterações do usuário (ver [PAE-006]).
- Mensagens de erro:
   - username duplicado: "Este username já está em uso";
   - tamanho do username: "O username deve ter entre 3 e 20 caracteres";
   - senha fora das regras: "A senha deve ter no mínimo 8 caracteres e conter letras, números e símbolos".
- A listagem de usuários reflete as alterações imediatamente após salvar.
