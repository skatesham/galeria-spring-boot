# Servidor Spring Boot RESTFULL
Servidor Spring Boot que funciona como uma API RESTFULL, dessa forma as sessões são stateless, com objetivo disponibilizar um galeria pessoais de imagens que é acessada por requisições HTTP. Esse Sistema possui os requisitos a seguir:

1. Login via Token
2. Cadastro via POST com body Json.
3. Galeria de Imagens.
4. Estrutura MVC
5. Spring Data JPA
6. Banco de Dados MYSQL

## Executar projecto
```
mvn spring-boot:run
```
Para a execução do sistema, necessita de um servidor Mysql com as tabelas a seguir:

1. [Usuario](https://github.com/skatesham/galeria-spring-boot/blob/master/sql/galeria%20-%20tabela%20usuario.sql)
2. [Papel](https://github.com/skatesham/galeria-spring-boot/blob/master/sql/galeria%20-%20tabela%20papel.sql)
3. [Imagem](https://github.com/skatesham/galeria-spring-boot/blob/master/sql/galeria%20-%20tabela%20imagem.sql)

e [configurar os dados de autenticação do servidor de banco de dados para o Spring Boot](https://github.com/skatesham/galeria-spring-boot/blob/master/src/main/resources/application.properties). Essas são URL, Username, Password.

### Rotas (Routes)
#### Inicial
http://localhost:8888/GaleriaImagens/
#### Login
http://localhost:8888/GaleriaImagens/login
#### Rotas de Usuario
http://localhost:8888/GaleriaImagens/usuario/
#### Rotas de Imagens
http://localhost:8888/GaleriaImagens/imagem/

### Header de Login
> Authorization = token

#### Modelo do Banco de Dados
![alt text](https://raw.githubusercontent.com/skatesham/Galeria-Spring-Boot-API-REST/master/img/galeria%20spring.png)


