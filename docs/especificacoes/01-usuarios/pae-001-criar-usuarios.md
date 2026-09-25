# [PAE-001] Criar usuários

### **Descrição:**

Usuários são pessoas autorizadas a acessar o sistema. O cadastro é realizado exclusivamente por administradores e define as informações mínimas para autenticação e segurança.

### **Objetivo:**

Permitir que o administrador cadastre novos usuários com nome de usuário e senha, com opção de gerar senha automática e forçar troca no primeiro acesso.

### **História:**

Como administrador do sistema,
Quero cadastrar usuários com nome de usuário e senha,
Para conceder acesso ao sistema de forma segura e com controle de troca de senha no primeiro login.

### **Fluxo principal:**

1. Administrador acessa a tela de cadastro de usuário.
2. Preenche o campo obrigatório username (único, de 3 a 20 caracteres).
3. Define a senha manualmente ou clica em um botão para gerar uma senha automaticamente; a senha gerada aparece no próprio campo de senha, como se tivesse sido digitada.
4. Marca (ou não) o checkbox "Solicitar troca de senha no primeiro login" (vazio por padrão).
5. Marca (ou não) o checkbox "Administrador" (vazio por padrão).
6. Salva o usuário.
7. O sistema:
   - Valida se o username já existe (ignorando maiúsculas/minúsculas) e, se sim, bloqueia com a mensagem "Este username já está em uso".
   - Valida o tamanho do username (3 a 20 caracteres).
   - Garante que a senha (manual ou gerada) tenha no mínimo 8 caracteres e combine letras, números e símbolos.
   - Persiste os dados com a flag de troca de senha, se marcada.
   - Cria o usuário com status ativo.
   - Registra a criação no histórico de alterações do usuário (ver [PAE-006]).
   - Exibe o novo usuário na listagem.

### **Critérios de aceite:**

- É possível cadastrar um usuário com `username` e `senha`.
- `username` deve ser único e ter entre 3 e 20 caracteres.
- `username` é único sem diferenciar maiúsculas de minúsculas (`admin` e `Admin` são considerados o mesmo username).
- A senha pode ser inserida manualmente ou gerada automaticamente.
- A senha (manual ou gerada) tem no mínimo 8 caracteres e combina letras, números e símbolos.
- Existe um checkbox "Solicitar troca de senha no primeiro login" (vazio por padrão).
- Existe um checkbox "Administrador" (vazio por padrão) que define se o usuário é administrador.
- Ao marcar a opção de troca de senha, o sistema exige que o usuário troque a senha ao fazer o primeiro login.
- O usuário é criado com status ativo.
- O cadastro só pode ser feito por administradores.
- A criação gera um registro no histórico de alterações do usuário (ver [PAE-006]).
- Mensagens de erro:
   - username duplicado: "Este username já está em uso";
   - tamanho do username: "O username deve ter entre 3 e 20 caracteres";
   - senha fora das regras: "A senha deve ter no mínimo 8 caracteres e conter letras, números e símbolos".
- O novo usuário aparece corretamente na listagem após o cadastro.
