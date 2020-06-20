# teste-tempo-telecom
Projeto de teste para aplicação em processo seletivo na Tempo Telecom

## Detalhes

Este projeto foi desenvolvido utilizando a estrutura Maven com Java (1.8) para o back-end e Angular 8 para o front-end. O banco de dados foi desenvolvido em PostgreSQL com auxilio do PgAdmin4.

É necessário para execução desta aplicação:
* Java 8;
* IDE com suporte a estrutura Maven (Ex: Eclipse, IntelliJ);
* Gerenciador de pacotes Node: https://nodejs.org/pt-br/download/package-manager/
* Angular CLI: https://cli.angular.io/
* Gerenciador de banco de dados com suporte a PostgreSQL (ex: PgAdmin4)

## Instalação

Para instalação do projeto, deve se seguir os seguintes passos:

### Inicialização do Banco de dados:
* Executar o script de criação da base de dados encontrado no arquivo 'script-banco.txt' em seu gerenciador de BD de escolha (que suporte PostgreSQL) ou criar uma base de dados manualmente;
* Executar os scripts de criação de tabelas encontrados no arquivo 'script-banco.txt' dentro da base de dados e aguardar a criação das tabelas;

### Inicialização do servidor Back-end:
* Importar o projeto Maven presente na pasta 'tempo-telecom-teste' em sua IDE de escolha;
* Dentro do diretório 'src/main/resources/', alterar o arquivo application.properties de acordo com as configurações da base de dados criada (nome e endereço da base de dados, username e password)
* Buildar o projeto utilizando o Maven Build (varia de acordo com a IDE) e aguardar a instalação das dependências necessárias;
* Após o build, executar a aplicação a partir da classe 'TempoTelecomTesteApplication.java' e aguardar a inicialização do servidor Tomcat.

### Inicialização do serviço Front-end:
* Importar o projeto presente na pasta 'tempo-telecom-front/front-angular' em sua IDE de escolha;
* Dentro deste diretório, executar o comando 'npm install' com o gerenciador de pacotes do Node para instalação das dependencias;
* Após instalação, verificar o arquivo enviroment.ts (./src/environments/enviroment.ts) e alterar a propriedade BASE_URL conforme o endereço aderido pelo servidor Tomcat durante a inicialização do back-end;
* Executar o comando 'npm start' no terminal (Node ou Powershell), dentro do diretório da aplicação para iniciliazição do serviço Angular.

Para acessar o sistema, acesse o endereço fornecido pelo Angular na inicialização do serviço de front-end (geralmente o endereço é /localhost:4200);

## Contato

* Email: joaovitor.felipesantos@gmail.com
* LinkedIn: https://www.linkedin.com/in/joaovitorfelipedossantos/
