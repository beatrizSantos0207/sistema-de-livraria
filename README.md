# Faça sua própria Livraria!📖
Esse sistema foi criado utilizando a linguagem Java, versão 11.

## Escopo do desafio
- Adicionar, ver, alterar e remover qualquer produto do sistema.
- Ver quantos itens de um tipo específico existem no estoque.
- Ver a listagem completa dos itens em estoque.
- Ver a listagem dos itens em estoque por categoria.
- Realizar uma operação de compra, ao realizar esta operação os produtos comprados devem ser removidos do estoque e o dinheiro pago deve ser adicionado ao caixa.
- Aplicar mudanças de escopo sem ferir os principios de SOLID.

## Como executar 🏃

Após clonar o projeto, faça o build das depedências e execute a classe Teste em sua IDE.

### Testes

Utilizando a classe teste, você pode utilizar as funcionalides da Livraria que incluem que incluem funções de cadastro, visualização, alteração e remoção de produtos, além do gerenciamento de estoque e funcionalidades de caixa como compra de itens.

## Decisões técnicas

### SOLID
O projeto foi construido tentando atender a metodologia de SOLID como:

S - Responsabilidade Única -> Uma classe deve ter uma única responsabilidade.

O - Aberto-Fechado -> As classes devem ser abertas para extensão, mas fechadas para modificação.

L - Substituição Liskov -> Se S é um subtipo de T, então objetos do tipo T em um programa podem ser substituídos por objetos do tipo S sem alterar nenhuma das propriedades desejáveis daquele programa.

I -  Segregação de Interface -> Os clientes não devem ser forçados a depender de métodos que não usam.

D — Inversão de Dependência -> Módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender da abstração. E as abstrações não devem depender de detalhes. Os detalhes devem depender de abstrações.


### Design Patterns
No desenvolvimento do projeto foi tentado utilizar alguns padrões de Design Patterns como:
Abstract Factory -> Padrão de projeto criacional que permite a produção de famílias de objetos relacionados sem ter que especificar suas classes concretas.
Builder -> Padrão permite que a produção de diferentes tipos e representações de um objeto usando o mesmo código de construção.
Strategy -> Padrão de projeto comportamental que permite a definição de uma família de algoritmos,  colocando-os em classes separadas, e fazendo os objetos deles intercambiáveis.


### Dificuldades
Durante a execução das mudanças de escopo do projeto a maior dificuldade foi repeitar o principio do OCP do SOLID, pois tecnicamente seria mais fácil alterar as classe existentes. Esse principio necessita de uma análise geral do sistema de forma que possamos criar novas implementações sem alterar o comportamento das classes existentes e sem tornar o código redundante. Seguir todos os principios do SOLID, tambem se  aprensentou como uma tarefa dificil, pois além do conhecimento tecnico era  necessário um conhecimento metódico e arquitetural, isso porque a aplicação das metodologias sem a devida análise, ao invés de facilitar a legibilidade e organização do sistema, aumenta seu grau complexidade.

## Melhorias
Aplicar o projeto em contexto real, utilizando tecnologias como conexão com banco de dados, REST e fluxo de exceções.

