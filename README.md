# Pets-Backend
* Esta api é o backend de um sistema de cadastro de animais de estimação
* que eu criei como uma forma de me desafiar a fazer um sistema completo
* e funcional. Consegui hospedar esta api na RailWay e o frontend eu hospedei 
* na Netlify, esta api possui poucos métodos, foi criada sob demanda para 
* atender as necessidades de seu frontend

## Pré Requisitos
* Java 17
* Spring Boot 3.1.2
* Banco de Dados PostgreSQL

## Link do Swagger
* http://localhost:8080/swagger-ui/index.html

## Mudando as configurações no application properties para o banco de dados local 
![Application Properties](![application properties imagem](https://github.com/Joelson0935/Pets-Backend/assets/56981455/3c3aa216-28dc-45cd-909d-c8f74cec18bc)
 )

## Endpoints: 
* Guardar Objeto:
* ` http://localhost:8080/pet/guardar-objeto  `
* Buscar Objeto por nome
* ` http://localhost:8080/pet/buscar-objeto-por-nome `
* Buscar Lista Paginada
* ` http://localhost:8080/pet/buscar-lista-paginada `
* Buscar lista completa
* ` http://localhost:8080/pet/buscar-lista-completa `
* Buscar total de pets
* ` http://localhost:8080/pet/buscar-total-pets `
* Buscar pets por id
* ` http://localhost:8080/pet/buscar-pet-por-id/{id} ` 
 
