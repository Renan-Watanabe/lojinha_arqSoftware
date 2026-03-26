# Lojinha
Este projeto é uma aplicação Java desenvolvida para fins acadêmicos, simulando o funcionamento interno de uma loja, desde a gestão de produtos e clientes até a finalização de pedidos com integração de pagamento.

## DER do sistema:

![DER_arqSoftware](https://github.com/user-attachments/assets/fe2eccde-bf1b-4afe-a179-3d0225b3bbd3)

## Diagrama UML do sistema:

<img width="1138" height="670" alt="image" src="https://github.com/user-attachments/assets/3f44724c-e66a-4968-8efa-3ebbce037035" />

## Arquitetura:
O sistema foi construído seguindo princípios de design robustos para garantir organização e facilidade de manutenção.
Modelo Arquitetural: Monolito Cliente-Servidor
Embora o sistema seja executado em um único projeto, ele aplica uma separação lógica clara:

Cliente (Front-end Simulado): Representado pela classe Main, responsável pela interface via console (Scanner/switch-case) e interação com o usuário.

Servidor (Back-end/Lógica): Composto pelos pacotes service, model e repository. Esta camada processa regras de negócio, cálculos e validações de forma independente da interface.

Nota: Essa separação permite que, no futuro, a interface de console seja substituída por uma GUI ou API Web sem a necessidade de alterar a lógica de negócio principal.

## Organização:
Para respeitar o Princípio da Responsabilidade Única (SRP), o código foi dividido nos seguintes pacotes:

com.lojinha.model: Entidades de domínio que representam os dados (Cliente, Produto, Pedido).

com.lojinha.repository: Responsável pela persistência. Utiliza a classe StoreData com listas estáticas para simular um banco de dados.

com.lojinha.service: Camada para serviços externos e lógica complexa.

## Padrões do projeto:
Foi implementado o padrão Singleton na classe PaymentGateway.

## Implementação
Gestão de Estado (Pedido como Carrinho): A classe Pedido assume o papel de acumulador de itens. Isso evita a duplicação de dados entre um objeto "Carrinho" e um "Pedido", permitindo cálculos dinâmicos de total em tempo real.

Fluxo de Controle: O uso de switch-case no menu principal foi escolhido pela legibilidade superior em relação a múltiplos if-else.

Feedback de Operações: Métodos de processamento retornam valores booleanos, permitindo que a camada de interface tome decisões baseadas no sucesso ou falha das operações da "API" de serviços.

## Estrutura do projeto:
src/
└── com/
    └── lojinha/
        ├── main/
        │   └── Main.java            # Ponto de entrada e Menu
        ├── model/
        │   ├── Cliente.java         # Entidade Cliente
        │   ├── Produto.java         # Entidade Produto
        │   ├── ItemPedido.java      # Itens que compõem o pedido
        │   └── Pedido.java          # Lógica de negócio e carrinho
        ├── repository/
        │   └── StoreData.java       # Simulação de Banco de Dados
        └── service/
            └── PaymentGateway.java  # Singleton de Pagamento
            
## Como executar o projeto:
Certifique-se de ter o JDK instalado em sua máquina.

Clone o repositório.

Navegue até a pasta src.

Compile e execute a classe Main.java.
