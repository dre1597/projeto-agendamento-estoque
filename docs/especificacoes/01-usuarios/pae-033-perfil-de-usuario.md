# [PAE-033] Perfil de usuário

### **Descrição:**

Todo usuário autenticado precisa visualizar suas próprias informações e alterar a própria senha sem depender do administrador. Vale tanto para usuário comum quanto para administrador.

### **Objetivo:**

Permitir que o usuário autenticado veja seus dados no próprio perfil e altere a própria senha, seguindo as mesmas regras de senha do sistema.

### **História:**

Como usuário do sistema,
Quero acessar meu perfil para ver minhas informações e alterar minha senha,
Para manter meus dados e meu acesso atualizados sem depender do administrador.

### **Fluxo principal:**

1. Usuário autenticado acessa a tela de perfil.
2. O sistema exibe suas informações: `username`, se é administrador e o status.
3. Para alterar a senha, o usuário informa a senha atual e a nova senha.
4. O sistema valida a senha atual e as regras da nova senha (mínimo de 8 caracteres, com letras, números e símbolos).
5. O sistema atualiza a senha (armazenada com hash) e registra a alteração no histórico (ver [PAE-006]).

### **Critérios de aceite:**

- Qualquer usuário autenticado acessa o próprio perfil (usuário comum e administrador).
- O perfil exibe `username`, se o usuário é administrador e o status.
- É possível alterar a própria senha informando a senha atual.
- A senha atual é validada; se incorreta, a alteração é bloqueada.
- A nova senha segue as mesmas regras do cadastro (mínimo de 8 caracteres, com letras, números e símbolos).
- A senha é armazenada de forma segura (hash).
- A alteração gera um registro no histórico de alterações do usuário (ver [PAE-006]), com a senha representada por `[senha antiga] → [senha nova]`.
- Mensagens de erro:
   - senha atual incorreta: "Senha atual incorreta";
   - senha fora das regras: "A senha deve ter no mínimo 8 caracteres e conter letras, números e símbolos".
