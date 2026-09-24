# [PAE-009] Atualizar setores

- **Área:** SETORES
- **Lista:** Backlog
- **Trello:** https://trello.com/c/kQQBndx6/2-pae-009-atualizar-setores

---

### **Descrição:**

Setores são categorias internas usadas para organizar fornecedores e produtos. Servem para classificar de forma lógica e facilitar a gestão de relacionamentos com contatos e estoques.

### **Objetivo:**

Permitir a edição de setores já cadastrados para corrigir ou atualizar informações como nome, sigla e descrição.

### **História:**

Como administrador do sistema,
Quero editar os dados de um setor existente,
Para manter as informações consistentes e atualizadas.

### **Fluxo principal:**

1. Usuário acessa a listagem de setores.
2. Seleciona o setor que deseja editar.
3. Altera um ou mais campos: `nome`, `sigla`, `descrição`.
4. Ao salvar, o sistema valida:
   - Nome e sigla continuam únicos.
   - Nome e sigla são obrigatórios.
   - Tamanhos máximos continuam sendo respeitados.
5. Se tudo estiver válido, os dados atualizados são persistidos.

### **Critérios de aceite:**

- É possível editar o nome, sigla e descrição de um setor.
- Nome e sigla continuam obrigatórios após a edição.
- Nome e sigla permanecem únicos (não é possível duplicar com outro setor).
- Validações de tamanho continuam aplicadas: nome (≤100), sigla (≤10), descrição (≤255).
- O sistema salva corretamente os dados atualizados e exibe a versão atualizada na listagem.
