# Sistema de Pontuação Trabalhista

## BackEnd
------------------------
### Requisitos
#### Back-end
- JDK 11 (https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

  - >PATH e JAVA_HOME devidamente configurado.
- Maven (https://maven.apache.org/download.cgi)

  - >PATH devidamente configurado

- Docker
#### Front-end
- Nodejs:Latest
  - Reactjs
  - Axios
    - `npm install axios`
  - Materialize
    - `npm install materialize-css@next`
      
    - `npm install react-materialize`
### Opcional
- VSCode (ext: spring, java, maven)

### CHANGLOG

- :heavy_check_mark: Criar Modelo Entidade Relacionamento;
  Vide src/main/{Package}/*FuncionarioController.java* ou /*PontoController.java* para mais informações
  
  - Funcionario RESTFULL COMPLETADO;
  - Modelo de relacionamento com *Ponto* realizado
  - Modelo de Pontuação funcionando.
  - Ponto ainda não consegue contabilizar saldo diario
  
- :heavy_check_mark: Criar um consulta de todos os funcionários que tiveram marcações inferior a 4 no dia corrente, campos: CPF, Nome do Funcionário , Quantidade de Batidas
- :radio_button: Criar uma consulta que traga todos os funcionários que tenha a idade maior que
25 anos e que tenha um saldo de horas extras maior que 2 hrs no dia atual,
campos: CPF, Nome do Funcionário, Idade, Saldo Horas Extras;
- :heavy_multiplication_x: Criar uma consulta que traga os dias da sema no qual os funcionários fizeram horas extras, campos: CPF, Nome do Funcionário, Dia da Semana(Segunda, Terça, Quarta, Quinta, Sexta, Sábado e Domingo);

### Iniciando projeto
##### A raiz do projeto encontra-se em .../implementacao/
está dividido em: 
- provarh (API/BACK-END)
- front/frontprova-provarh(FRONT-END)
#### Realize o "pull" dos conteiners pré montados
$` docker pull mysql:latest`
$`docker pull openjdk:11`
#### Para subir imagem do mysql
$`cd implementacao`
$`docker-compose up`  
#### Abra o projeto com VSCODE para obter raiz em "prova-rh-01"
$`cd provarh`
### Para subir api
$`mvn clean`

$`mvn install`

$`mvn spring-boot:run`

### Ou para subir no docker
$`docker build . -t spring-pulse`

$`docker run -p 8080:8080 --network` 

$`spring-network --name spring-pulse --link 
pulse-mysql:mysql  -d spring-pulse`


## FrontEnd
#### Obs: Por motivos de facilidade, a segurança foi desabilitado para realizar o debug.
### Endereços de acesso
- `localhost:3000/` Tela de home. -Necessário logar.
- `localhost:3000/signup` Tela de Cadastro. -Acesso liberado
- `localhost:3000/funcionario` Tela de gerenciamento dos funcionarios. -Acesso liberado, para facilitar o debug
### ChangLog
- :heavy_check_mark: Sistema de login e cadastro.
- :heavy_check_mark: Marca ponto.
- :heavy_check_mark: Visão geral dos Funcionarios.
- :heavy_check_mark: Filtra por funcionarios menos de 4 marcações.

### Iniciando Front-end

- $`cd implementacao/front/front-provarh`
- $`npm start` 

## Screenshots

![alt text](https://github.com/LeandroLimaPRO/prova-rh-01/blob/master/documentacao/ScreenShots/Tela%20Inicial%20-%20Login.png?raw=true)

![alt text](https://github.com/LeandroLimaPRO/prova-rh-01/blob/master/documentacao/ScreenShots/TelaRegistro.png?raw=true)


![alt text](https://github.com/LeandroLimaPRO/prova-rh-01/blob/master/documentacao/ScreenShots/DashBoard.png?raw=true)

![alt text](https://github.com/LeandroLimaPRO/prova-rh-01/blob/master/documentacao/ScreenShots/TelaPainelGereciamentoGeral.png?raw=true)

-----------------