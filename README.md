#ElasTech
## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/vscode/vscode-original.svg" /> Pré-requisitos de Instalação ##

Se você deseja baixar editar e/ou executar esse sistema, é preciso ter:
- JDK*
+ JAVA*
- IntelliJ ou IDE da sua preferência
+ MySQL Workbench*
- Git
+ Acesso ao GitHub

## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/fluency/48/000000/run-command.png" /> Execução da Aplicação ##

<br>As Dependências citadas são instaladas automaticamente.

### Para executar no primeiro acesso: ###

+ Antes de executar a aplicação em resources, na aplication properties tem que colocar a senha do MySQL previamente gerada.
- E no MySQL criar o Banco executando a linha: create database SoulBank.
+ Depois de executada insira os inserts da pasta Scripts.
- Atualizar o valor do Hibernate de acordo com o arquivo clean_bd da mesma pasta.

### Executar em todo acesso: ###

+ Swagger: http://localhost:8090/swagger-ui/index.html#/.

## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/color/48/000000/error--v1.png" /> Possíveis implementações futuras ##

+ Spring Security.
- Autenticação Oauth.
+ Ao invés de termos criado o atributo chave pix para receber o dado duplicado da informação do cliente, ele poderia escolher a chave pix na transação, além ter a opção de múltiplas chaves.
- Fizemos a relação de Pessoa Física e Pessoa Jurídica como herança para poder praticar herança no projeto, porém descobrimos que na prática não é feito com herança.*
+ Criação de Front-End por meio de console.
- Melhorar o código para ficar mais limpo, ex: aplicação das annotations dos getters and setters e dos contrutores.
+ Botar mais regras de negócio para a API do Banco se parecer mais com a realidade*
- Mudar a relação de Cliente e Conta para @ManyToMany.
+ Melhorar a estrutura do Banco para ter mais diversidade de tipos de Clientes.

## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/fluency/48/000000/handshake.png" /> Contribuidores ##

Projeto elaborado por: https://github.com/Bruna-Quinto-Marsiaj,  https://github.com/gizele233, https://github.com/jaqueline-ghizini,  https://github.com/priscilagf, https://github.com/SamantaBarrosC, https://github.com/srhgeorgia.Projeto 

