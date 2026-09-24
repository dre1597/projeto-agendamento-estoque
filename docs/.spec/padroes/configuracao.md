# Padrão: Configuração

Telas que definem regras/parâmetros do sistema.

## Quando usar

Quando o administrador ajusta regras que afetam o comportamento do sistema.

## Template

```markdown
# [PAE-XXX] Configurar <regra>

### **Descrição:**
Quais regras são configuráveis e por quê.

### **Objetivo:**
Dar controle ao administrador para definir <parâmetros>.

### **História:**
Como administrador do sistema,
Quero configurar <parâmetros>,
Para <benefício>.

### **Fluxo principal:**
1. Administrador acessa a tela de configuração.
2. Define <parâmetros>.
3. Salva.
4. O sistema valida os parâmetros.
5. A configuração passa a valer conforme a regra definida.

### **Critérios de aceite:**
- Apenas administradores acessam/modificam a configuração.
- <Validações> são aplicadas.
- Configurações inválidas são rejeitadas com mensagem clara.
- A configuração é registrada e efetiva conforme definido.
```

## Regras típicas

- Acesso **restrito a administradores**.
- **Validações** explícitas (faixas, datas, intervalos).
- Distinguir **configuração vigente** da **futura** (agendada).
- Rejeitar entrada inválida com **mensagem clara**.
- Registrar quem/quando configurou.

## Checklist

- [ ] Parâmetros configuráveis listados.
- [ ] Validações e faixas definidas.
- [ ] Regra de vigência (quando passa a valer).
- [ ] Permissão de administrador.
- [ ] Mensagens de erro de validação.

## Exemplo real

`docs/especificacoes/05-agendamento/pae-028-configurar-regras-de-agendamento-de-movimentacao-no-estoque.md`
— dias da semana, janela de horário (1h–8h, podendo cruzar meia-noite) e data de início
(mínimo 15 dias à frente).
