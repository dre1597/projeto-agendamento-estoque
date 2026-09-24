# Padrão: Listar

Tela de listagem/consulta com paginação, filtros e ordenação.

## Quando usar

Quando é preciso exibir uma coleção de registros com busca e navegação.

## Template

```markdown
# [PAE-XXX] Listar <entidade>

### **Descrição:**
Necessidade de navegar/organizar os registros com eficiência.

### **Objetivo:**
Exibir <entidade> com filtros, ordenação e paginação no backend.

### **História:**
Como <papel>,
Quero visualizar <entidade> com paginação, ordenação e filtros,
Para localizar rapidamente os registros desejados.

### **Fluxo principal:**
1. Usuário acessa a listagem.
2. A tabela exibe as colunas: <lista>.
3. O usuário pode:
   - Filtrar por <campos>.
   - Ordenar por <campos> (asc/desc).
   - Escolher itens por página (10, 25, 50).
   - Navegar entre páginas.
4. O sistema retorna os dados paginados, filtrados e ordenados conforme a escolha.

### **Critérios de aceite:**
- A listagem é paginada.
- É possível filtrar por <campos> (busca parcial quando texto).
- A ordenação funciona em ordem crescente e decrescente.
- O usuário controla itens por página (10, 25, 50).
- Toda a lógica ocorre no backend.
```

## Regras típicas

- **Paginação, filtros e ordenação no backend** (performance).
- Itens por página **10/25/50**.
- Filtros comuns: texto (busca parcial), status, criador, período, "somente os meus".
- Ordenação por nome, quantidade, data.
- Atualização dinâmica sem reload completo; responsiva.
- Colunas mínimas definidas.

## Checklist

- [ ] Colunas da tabela definidas.
- [ ] Filtros e ordenações declarados.
- [ ] Paginação e itens por página.
- [ ] Backend responsável pela paginação/filtros/ordenação.
- [ ] Atualização dinâmica e responsividade.

## Exemplo real

`docs/01-usuarios/pae-004-listar-usuarios.md` — colunas `username`/`status`,
filtro por `username` (parcial) e `status`, ordenação por `username`, 10/25/50.
