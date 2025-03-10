API REST desenvolvida com Spring Boot, projetada para gerenciar um sistema de restaurante. A API permite que clientes interajam com o sistema para realizar pedidos e acessar informações do cardápio.

Funcionalidades Principais:

Gerenciamento de Clientes:
Permite criar, visualizar, atualizar e excluir informações de clientes.
Gestão de Pedidos:
Possibilita a criação de pedidos, listagem de pedidos e visualização de detalhes de pedidos.
Cardápio:
Oferece acesso a informações sobre os itens do cardápio.
Documentação da API:
Utiliza o Swagger UI para documentar e testar os endpoints da API.
Banco de Dados:
Utiliza o H2 como banco de dados em memória para persistência de dados durante o desenvolvimento.
Tratamento de Exceções:
Possui tratamento de exceções global, para padronizar o retorno de erros da aplicação.
Arquitetura:

A arquitetura do projeto segue o padrão MVC (Model-View-Controller), com camadas bem definidas para separação de responsabilidades.
Os controladores recebem as requisições HTTP, os serviços implementam a lógica de negócios e os repositórios interagem com o banco de dados.
O tratamento de erros é feito de forma global, com o uso do ControllerAdvice e ExceptionHandler.
O uso do Swagger UI permite a fácil visualização dos endpoints e também permite que os endpoints sejam testados de forma fácil.
Tecnologias:

Spring Boot

JPA (Java Persistence API)

H2 Database

SpringDoc(Swagger UI)

Spring Web


```mermaid
classDiagram
  class Cliente {
    -Long id
    -String nome
    -String email
    -String telefone
    -List~Pedido~ pedidos
    -List~Promocao~ promocoesElegiveis
  }
  class Pedido {
    -Long id
    -String numeroPedido
    -Date dataPedido
    -StatusPedido status
    -BigDecimal total
    -List~ItemPedido~ itens
    -Cliente cliente
  }
  class ItemPedido {
    -Long id
    -ItemCardapio item
    -int quantidade
    -BigDecimal precoUnitario
    -Pedido pedido
  }
  class ItemCardapio {
    -Long id
    -String nome
    -String descricao
    -BigDecimal preco
    -CategoriaCardapio categoria
    -boolean disponivel
    -List~PromocaoItemCardapio~ promocoes
  }
  class Promocao {
    -Long id
    -String titulo
    -String descricao
    -String icone
    -Date dataInicio
    -Date dataFim
    -BigDecimal valorDesconto
  }
  class PromocaoItemCardapio {
    -Long id
    -BigDecimal precoDescontado
    -Promocao promocao
    -ItemCardapio itemCardapio
  }
  class CategoriaCardapio {
    -Long id
    -String nome
  }
  class StatusPedido {
    -Long id
    -String status
  }

  Cliente "1" *-- "N" Pedido : pedidos
  Pedido "1" *-- "N" ItemPedido : itens
  ItemPedido "N" --> "1" ItemCardapio : item
  ItemCardapio "1" -- "0..N" PromocaoItemCardapio : promocoes
  PromocaoItemCardapio "N" --> "1" Promocao : promocao
  Cliente "N" -- "N" Promocao : promocoesElegiveis
  ItemCardapio "1" --> "1" CategoriaCardapio : categoria
  Pedido "1" --> "1" StatusPedido : status
  Pedido "N" --> "1" Cliente : cliente
  ItemPedido "N" --> "1" Pedido : pedido
  PromocaoItemCardapio "N" --> "1" ItemCardapio : itemCardapio
 ```
