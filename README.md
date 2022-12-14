#Projeto ElasTech
# ElasTech Projeto - SoulBank #
## Grupo CodingDreams - Desafio final - Banco Fictício ##

    Documentação técnica, por meio de um arquivo readme.md, do projeto do Programa ElasTech, com a criação de um sistema de Cadastro de Conta Bancária, Cliente e realização de Transações.

___
## <img align="center" alt="Jaque-Csharp" height="30" width="30" src="https://img.icons8.com/color/48/000000/light.png"> Feature 
<p>O banco fictício SoulBank queria construir uma nova plataforma e precisava de um sistema para gerenciar clientes e transações. Esse sistema deveria permitir cadastro de novos clientes, incluindo dados pessoais e dados para contato. O cliente precisava ser atrelado a uma conta bancária, com um valor inicial de saldo. Foi solicitado que fossem feitas transferências de um cliente para outro e esse histórico de transações entre as contas seriam registrados. </p>
<p>Então para atender essa demanda foram aplicados os conceitos de Java com Orientação a Objetos, onde classes foram criadas para representar as entidades a serem gerenciadas e tambén os casos de uso desse sistema. Para armazenar os dados aplicamos os conceitos de bancos de dados. </p>
<p>Criamos o cadastro, alteração e consulta de Pessoa Física e Jurídica, Conta e Transações.</p>
<br>

##  <img align="center" alt="Jaque-Csharp" height="45" width="30" src="https://www.vectorlogo.zone/logos/java/java-vertical.svg"> Tecnologias Utilizadas ##
Foram escolhidas para esse projeto:
+ Linguagem Java. Por ser uma linguagem de alto nível e orientada a objeto.
+ Spring Boot. Pela facilidade e agilidade em processos de aplicações Java. Importamos algumas dependências como Actuator e Web.
- Spring Boot JPA. Por criar uma camada de acesso aos dados por meio de uma API.
+ H2. Utilizamos inicialmente para gerar uma Base de Dados simples para testes de Caso de Uso das Entidades.
- MySQL. Escolhido como Banco de Dados final por ser mais estruturado e ser multiplataforma. 
+ Postman. Utilizamos para realizar os testes iniciais.
- Swagger. Posteriormente incluimos a depencência do Swagger para fazer os testes finais e gerar os endpoints, por ser composto de diversas ferramentas que auxiliam no consumo e visualização de serviços de uma API.
<br><br>

## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/color/48/000000/note.png" /> Organização do Projeto ##
O projeto tem uma estrutura orientada a objeto com uma relação de Herança entre as Classes, sendo elas:
+ Classe Cliente. Superclasse, ou classe Mãe/Pai, com os atributos 'email', 'telefone' e 'statusCliente'.
- Classe Pessoa Física. Subclasse, ou classe Filha, além de herdar as propriedades da mãe, também tem os atributos 'CPF', 'RG', 'nome', é associado a um 'Endereço' e a uma 'Conta Bancária'.
+ Classe Pessoa Jurídica. Subclasse, ou classe Filha, além de herdar as propriedades da mãe, também tem os atributos 'CNPJ', 'razão social', é associado a um 'Endereço' e a uma 'Conta Bancária'. 
<br><br>
Pessoa Fisica e Jurídica estão associados as outras duas Classes, que é a Endereço e Conta Bancária. Conta Bancária por sua vez está relacionado com Transação. Essas Classes têm a seguinte estrutura: 
+ Classe Endereço. Associado por meio de uma relação OneToMany onde um Endereço pode pertencer a mais de uma Pessoa. Os atributos de Endereço são: 'id do Endereco','logradouro', 'complemento', 'bairro', 'cidade', 'estado', 'CEP'.
- Classe Conta Bancária. Com uma relação de OneToOne com Pessoa Física e Jurídica. Inicialmente criamos com essa relação mais simples, mas uma ótima implementação seria uma relação @ManyToMany. Os atributos Conta Bancária são: 'id da Conta', 'conta', 'agencia', 'saldo', 'limite', 'cheque especial', 'chave Pix', 'tipo de chave Pix', 'status da Conta', e um atributo tipo List para exibir as Transações.
+ Transação. Está relacionada a Conta com uma relação de @ManyToOne, onde uma Conta pode ter várias Transações. Como uma Transação pode ser realizada entre dois clientes, foram criados dois atributos do tipo Conta Bancária, um é o 'conta origem' e o outro é o 'conta destino'. Os demais atributos da classe são: 'id de transação', 'valor', 'tipo de transação' e 'data'.
<br>

As entidades Pesssoa Física e Jurídica do Banco de Dados não tem uma relação de Herança com Cliente no Banco de Dados, cada uma têm sua tabela própria para melhor organização.
<br><br>

## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/color/48/000000/note.png" /> Casos de Uso do Sistema ##
+ Cadastro de cliente
<br><br>
![CadastrarCliente](https://user-images.githubusercontent.com/36826625/203323013-1d16d0b4-113f-4810-bdfd-12ad538ebd74.png)

+ Buscar cliente cadastrado
<br><br>
![BuscarClienteCadastrado](https://user-images.githubusercontent.com/36826625/203323775-89718da4-2774-425c-9e4e-a4e79d2c03ea.png)

+ Transferência de saldo entre contas
![TransferenciadeSaldoEntreContas](https://user-images.githubusercontent.com/36826625/203324536-fa1025f2-f449-47a4-951b-dd10a510f412.png)

+ Buscar histórico de transações entre contas
![BuscarHistoricodeTransacaoentreContas](https://user-images.githubusercontent.com/36826625/203325623-65cc41ba-46a5-4ce5-b41e-88e33575f53a.png)

## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/color/48/000000/note.png" /> Diagrama de Classe ##

Diagrama UML.
![DiagramaClasseUML-final](https://user-images.githubusercontent.com/36826625/203415962-ff65916a-cc80-4321-b56e-8fa6d72ce604.png)

<br><br>

## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/color/48/000000/note.png" /> DER ##

Diagrama de Entidade e Relacionamento do Banco de Dados.

![DER](https://user-images.githubusercontent.com/36826625/203319946-3bfd116c-8093-432b-a446-d983bad2561a.png)

<br><br>


## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/vscode/vscode-original.svg" /> Pré-requisitos de Instalação ##

Se você deseja baixar editar e/ou executar esse sistema, é preciso ter:
- JDK 8
+ Java 8
- IntelliJ ou IDE da sua preferência
+ MySQL
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

+ Spring Security: autenticação e autorização (OAuth 2.0).
- Criação de Front-End por meio de console.
+ Código Limpo: Sonar.
- Melhorar a API do Banco se parecer mais com a realidade.
+ Java Dot.



## <img align="center" alt="Jaque-vscode" height="30" width="30" src="https://img.icons8.com/fluency/48/000000/handshake.png" /> Contribuidores ##

Projeto elaborado por: 
+ <a href="https://github.com/Bruna-Quinto-Marsiaj">Bruna Quinto</a>

+ <a href="https://github.com/gizele233">Gizele Rodrigues</a>

+ <a href="https://github.com/jaqueline-ghizini">Jaqueline Ghizini</a>

+ <a href="https://github.com/priscilagf">Priscila Gallo</a>

+ <a href="https://github.com/SamantaBarrosC">Samanta Barros</a>

+ <a href="https://github.com/srhgeorgia.Projeto">Sarah de Oliveira</a>

