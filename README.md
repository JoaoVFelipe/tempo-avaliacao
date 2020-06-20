# teste-tempo-telecom
Projeto de teste para aplicação em processo seletivo na Tempo Telecom

## Detalhes

Este projeto foi desenvolvido utilizando a arquitetura Maven com Java (1.8) para o back-end e Angular 8 para o front-end. O banco de dados foi desenvolvido em PostgreSQL com auxilio do PgAdmin4.

## Instalação

Para instalação do projeto, deve se seguir os seguintes passos:

### Inicialização do Banco de dados:
* Instalar e configurar o PgAdmin4 de acordo com a máquina/SO;
* Executar os scripts de SQL encontrados no arquivo 'script-banco.txt' no PgAdmin4.

### Inicialização do servidor Back-end:
* Importar o projeto presente na pasta 'tempo-telecom-teste' em sua IDE de escolha;
* Dentro do diretório src/main/resources, alterar o arquivo application.properties de acordo com a configuração feita no PgAdmin4 (principalmente os atributos 'username' e 'password');
* Buildar o projeto utilizando o Maven Build (varia de acordo com a IDE) e aguardar a instalação das dependências necessárias;
* Após o build, executar a aplicação a partir da classe 'TempoTelecomTesteApplication.java' e aguardar a inicialização do servidor Tomcat.

### Inicialização do serviço Front-end:
* Importar o projeto presente na pasta 'tempo-telecom-front/front-angular' em sua IDE de escolha;
* Dentro deste diretório, executar o comando 'npm-install' com o gerenciador de pacotes do Node para instalação das dependencias;
* Após instalação, verificar o arquivo enviroment.ts (./src/environments/enviroment.ts) e alterar a propriedade BASE_URL conforme o endereço aderido pelo servidor Tomcat durante a inicialização do back-end;
* Executar o comando 'npm-start' para iniciliazição do serviço Angular.

Para acessar o sistema, acesse o endereço fornecido pelo Angular na inicialização do serviço de front-end (geralmente o endereço é /localhost:4200);

## Contato

Email: joaovitor.felipesantos@gmail.com
LinkedIn: https://www.linkedin.com/in/joaovitorfelipedossantos/