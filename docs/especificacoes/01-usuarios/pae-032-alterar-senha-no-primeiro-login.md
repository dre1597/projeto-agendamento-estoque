# [PAE-032] Alterar senha no primeiro login

### **Descrição:**

Quando o administrador cadastra ou atualiza um usuário marcando a opção de troca de senha no primeiro login, o sistema exige que o usuário defina uma nova senha antes de acessar o sistema.

### **Objetivo:**

Permitir que o usuário altere a própria senha no primeiro acesso, seguindo as mesmas regras de senha do cadastro, e limpar a flag de troca.

### **História:**

Como usuário do sistema,
Quero alterar minha senha no primeiro login,
Para acessar o sistema com uma senha própria.

### **Fluxo principal:**

1. Usuário faz login com as credenciais e o sistema identifica a flag de troca de senha ativa (ver [PAE-007]).
2. O sistema redireciona o usuário para a tela de alteração de senha e não libera o restante do acesso até a troca ser concluída.
3. Usuário informa a nova senha.
4. O sistema valida a nova senha pelas mesmas regras do cadastro (mínimo de 8 caracteres, com letras, números e símbolos).
5. O sistema atualiza a senha (armazenada com hash) e zera a flag de troca de senha.
6. Usuário é liberado para acessar o sistema.

### **Critérios de aceite:**

- A troca é exigida somente quando a flag de troca de senha está ativa.
- O usuário não acessa o sistema antes de concluir a troca.
- A nova senha segue as mesmas regras do cadastro (mínimo de 8 caracteres, com letras, números e símbolos).
- A senha é armazenada de forma segura (hash).
- A flag de troca de senha é zerada após a troca.
- Após a troca, o usuário é liberado para acessar o sistema.
- Mensagem de erro quando a senha não atende às regras: "A senha deve ter no mínimo 8 caracteres e conter letras, números e símbolos".
