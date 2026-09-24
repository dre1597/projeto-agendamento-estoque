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
   - `username` (mantendo a unicidade).
   - `senha` (pode ser manual ou gerar automaticamente).
   - Flag "Solicitar troca de senha no primeiro login" (caso tenha alterado a senha).
   - Se o usuário é um administrador ou não.
4. Salva as alterações.
5. O sistema valida:
   - `username` permanece único.
   - Senha (se alterada) atende aos critérios mínimos.
6. Atualiza o registro com os novos dados.

### **Critérios de aceite:**

- É possível atualizar `username`, `senha`, a flag de troca de senha e se um usuário é um administrador ou não.
- `username` continua sendo único após a edição.
- Senha nova deve seguir as regras de segurança (mínimo 8 caracteres, etc).
- A flag para troca de senha no primeiro login pode ser alterada (caso a senha tenhado sido alterada).
- Atualização só pode ser feita por administradores.
- A listagem de usuários reflete as alterações imediatamente após salvar.
