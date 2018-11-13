# Servidor Spring Boot RESTFULL
Servidor Spring Boot que funciona como uma API RESTFULL, dessa forma as sessões são stateless, com objetivo disponibilizar um galeria pessoais de imagens que é acessada por requisições HTTP. Esse Sistema possui os requisitos a seguir:

1. Login via Token;
2. Cadastro via POST com body Json;
3. Galeria de Imagens;
4. Estrutura MVC;
5. Spring Data JPA;
6. Banco de Dados MYSQL.

[Um servidor Vue em Typescript foi desenvolvido para ser a interface de usuário desse sistema](https://github.com/skatesham/galeria-vue-interface)

## Executar projeto
Para a execução do sistema, necessita de um servidor Mysql com as tabelas a seguir:

1. [Usuario](https://github.com/skatesham/galeria-spring-boot/blob/master/sql/galeria%20-%20tabela%20usuario.sql)
2. [Papel](https://github.com/skatesham/galeria-spring-boot/blob/master/sql/galeria%20-%20tabela%20papel.sql)
3. [Imagem](https://github.com/skatesham/galeria-spring-boot/blob/master/sql/galeria%20-%20tabela%20imagem.sql)

e [Configurar os dados de autenticação do servidor de banco de dados para o Spring Boot](https://github.com/skatesham/galeria-spring-boot/blob/master/src/main/resources/application.properties). 

As configuraçõe são
- URI;
- Username;
- Password.

Após as configurações acima, pode-se utilizar do Maven pra executar o servidor com o seguinte comando:
```
mvn spring-boot:run
```

O servidor será disponibilizado de acordo com as [configurações](https://github.com/skatesham/galeria-spring-boot/blob/master/src/main/resources/application.properties), neste link:
```
http://localhost:8888/GaleriaImagens/
```

### Controllers
Os controllers possui as rotas de acesso do sistema, esses são:
- [Root Controller - Para Login e Teste](https://github.com/skatesham/galeria-spring-boot/blob/master/src/main/java/com/fatec/spring/boot/controller/RootController.java)
- [Usuario Controller - Para operações com usuarios do sistema](https://github.com/skatesham/galeria-spring-boot/blob/master/src/main/java/com/fatec/spring/boot/controller/UsuarioController.java)
- [Imagem Controller - Para operações com as imagens](https://github.com/skatesham/galeria-spring-boot/blob/master/src/main/java/com/fatec/spring/boot/controller/ImagemControler.java)


### Header de Login
> Authorization = token

#### Modelo do Banco de Dados
![alt text](https://raw.githubusercontent.com/skatesham/Galeria-Spring-Boot-API-REST/master/img/galeria%20spring.png)

Estrutuar do projeto:
.
├── babel.config.js
├── package.json
├── package-lock.json
├── postcss.config.js
├── public
│   ├── favicon.ico
│   ├── index.html
│   ├── logo-img.png
│   └── styles.css
├── README.md
├── src
│   ├── App.vue
│   ├── assets
│   │   ├── css
│   │   │   └── my-login.css
│   │   ├── img
│   │   │   ├── gallery.jpg
│   │   │   ├── logo.jpg
│   │   │   └── logo.png
│   │   └── js
│   │       └── my-login.js
│   ├── components
│   │   ├── authentication
│   │   │   ├── Cadastro.vue
│   │   │   ├── Login.vue
│   │   │   └── Painel.vue
│   │   ├── HelloWorld.vue
│   │   ├── modulos
│   │   │   ├── ImagensComp.vue
│   │   │   ├── Inicial.vue
│   │   │   └── UsuariosComp.vue
│   │   └── navbar
│   │       ├── NavbarBlocked.vue
│   │       └── Navbar.vue
│   ├── main.ts
│   ├── packages
│   │   └── auth
│   │       └── Auth.js
│   ├── router.ts
│   ├── shims-tsx.d.ts
│   ├── shims-vue.d.ts
│   ├── store.ts
│   ├── typing.d.ts
│   └── views
│       ├── About.vue
│       ├── Home.vue
│       ├── Imagens.vue
│       ├── Logar.vue
│       ├── Registro.vue
│       └── Usuarios.vue
└── tsconfig.json

