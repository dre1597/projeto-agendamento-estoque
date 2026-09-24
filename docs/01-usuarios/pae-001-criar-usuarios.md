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
2. Preenche o campo obrigatório username (deve ser único).
3. Define a senha manualmente ou clica em um botão para gerar uma senha automaticamente.
4. Marca (ou não) a opção "Solicitar troca de senha no primeiro login".
5. Define se o usuário é um administrador.
6. Salva o usuário.
7. O sistema:
   - Valida se o username já existe.
   - Garante que a senha (manual ou gerada) tenha no mínimo 8 caracteres.
   - Persiste os dados com a flag de troca de senha, se marcada.
   - Exibe o novo usuário na listagem.

### **Critérios de aceite:**

- É possível cadastrar um usuário com `username` e `senha`.
- `username` deve ser único.
- A senha pode ser inserida manualmente ou gerada automaticamente.
- A senha gerada automaticamente tem no mínimo 8 caracteres e combina letras, números e símbolos.
- Existe um checkbox "Solicitar troca de senha no primeiro login".
- Ao marcar a opção, o sistema exige que o usuário troque a senha ao fazer o primeiro login.
- O cadastro só pode ser feito por administradores.
- O novo usuário aparece corretamente na listagem após o cadastro.
