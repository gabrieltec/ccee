Projeto de Processamento de Arquivos XML com Spring e Angular
Este é um projeto que demonstra como criar um sistema web para processar arquivos XML usando Spring Boot no backend e Angular no frontend. O sistema permite o upload de arquivos XML, o processamento de dados e a exibição de informações consolidadas por região.

Tecnologias Utilizadas
Spring Boot 2
Angular 12+
PostgreSQL (ou outro banco de dados de sua escolha)
Hibernate (para mapeamento objeto-relacional)
Angular Material (para o frontend)
Maven 3 (para gerenciamento de dependências no backend)
Node.js 14+ (para o frontend)
Pré-requisitos
Antes de começar, certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

Java Development Kit (JDK) 17
Node.js e npm
Docker e Docker Compose (para configurar um ambiente com PostgreSQL)
Um editor de código de sua escolha (recomendamos VS Code)
Configuração do Ambiente
Configurando o Banco de Dados PostgreSQL com Docker
Você pode usar o Docker Compose para configurar um ambiente PostgreSQL para este projeto. Execute o seguinte comando na raiz do projeto:

bash
Copy code
docker-compose up -d
Isso iniciará um contêiner PostgreSQL com as configurações especificadas no arquivo docker-compose.yml.

Backend (Spring Boot)
Abra o projeto Spring Boot em sua IDE.
Configure as propriedades do banco de dados no arquivo application.properties para corresponder às configurações do PostgreSQL.
Frontend (Angular)
Navegue até a pasta frontend no diretório do projeto.
Execute o seguinte comando para instalar as dependências do Angular:
bash
Copy code
npm install
Após a instalação, inicie o servidor de desenvolvimento Angular:
bash
Copy code
ng serve
O aplicativo estará disponível em http://localhost:4200/.
Uso
Acesse a interface web em http://localhost:4200/.
Faça o upload de um ou mais arquivos XML.
Os arquivos serão processados e os dados serão armazenados no banco de dados.
Você pode acessar informações consolidadas por região por meio da interface.