# loteria-zup
## API simples desenvolvida para o processo Zup Orange Talents

Trata-se de uma API REST de loteria que cadastra pessoas num banco de dados e atribui a elas suas devidas apostas. 

Para cada nova aposta é gerado um número aleatório.

Há um segundo endpoint que recebe no path um email e devolve uma lista das apostas feitas pela pessoa correspondente ao email.

A aplicação foi criada em linguagem JAVA com Spring. Foram adicionados ao projeto ainda o Spring Boot, Spring Validator e o Spring Data JPA implementado pelo Hibernate.


OBS. a presente aplicação não possui uma camada Service, com o objetivo de simplificar o projeto, atendendo apenas aos requisitos do desafio.

Licensa livre.
