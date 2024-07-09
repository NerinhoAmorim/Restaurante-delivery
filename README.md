# Restaurant Delivery

Este é um projeto simplificado para o controle de delivery de um restaurante. A aplicação permite o cadastro, alteração, deleção e consulta de clientes, pedidos e entregas. Além disso, possui um sistema de autenticação via token JWT para garantir a segurança das operações.

## Tecnologias Utilizadas

- Java 17
- Spring Boot 2
- Banco de Dados MongoDB
- Maven
- OpenAPI 3.0 (Swagger)

## Compilar e Executar

1. Clone o repositório:
git clone https://github.com/NerinhoAmorim/restaurante-delivery
cd restaurant-delivery

2. Compile o projeto:
   mvn clean install

3. Execute a aplicação:
   mvn spring-boot:run

4. Acesse o Swagger para ver e testar as APIs:
   http://localhost:8080/swagger-ui.html
   
# Funcionalidades
## Segurança
Cadastro de usuários e login com autenticação via token JWT. Os métodos das APIs abaixo só poderão ser executados caso o usuário esteja logado.
## Cliente
Cadastro,
alteração,
deleção e consulta de clientes.
## Pedido
Cadastro,
alteração,
deleção e consulta de pedidos.
Um pedido obrigatoriamente precisa ter um cliente e um cliente pode ter vários pedidos.
# Entrega
Cadastro,
alteração,
deleção e consulta de entregas.
Uma entrega obrigatoriamente necessita estar vinculada a um pedido.

# Endpoints

## Autenticação
POST /authenticate - Autenticação de usuário e geração de token JWT.

## Cliente
GET /clientes - Lista todos os clientes.

GET /clientes/{id} - Consulta um cliente pelo ID.

POST /clientes - Cadastro de um novo cliente.

PATCH /clientes/{id} - Atualização de um cliente existente.

DELETE /clientes/{id} - Deleção de um cliente.

## Pedido
GET /pedidos - Lista todos os pedidos.

GET /pedidos/{id} - Consulta um pedido pelo ID.

POST /pedidos - Cadastro de um novo pedido.

PATCH /pedidos/{id} - Atualização de um pedido existente.

DELETE /pedidos/{id} - Deleção de um pedido.

## Entrega
GET /entregas - Lista todas as entregas.

GET /entregas/{id} - Consulta uma entrega pelo ID.

POST /entregas - Cadastro de uma nova entrega.

PATCH /entregas/{id} - Atualização de uma entrega existente.

DELETE /entregas/{id} - Deleção de uma entrega.

## Autores
Nerinho Amorim - Desenvolvedor




