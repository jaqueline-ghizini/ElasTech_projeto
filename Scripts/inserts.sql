-- Executar o script de acordo com a ordem: endereco, conta_bancaria e depois pessoas 

insert into endereco(id_endereco,bairro,cep,cidade,complemento,estado,logradouro)value
(1,"Santa Joana","09912-025","São Bernardo do Campo","Apto 12","SP","Rua das Margaridas,13"),
(2,"Santa Lucia","0123-020","São Bernardo do Campo","Apto 58","SP","Rua das Amoreiras,134"),
(3,"Ana Luiza","2536-025","São Bernardo do Campo","casa 2","SP","Rua dos Panteras,88"),
(4,"Americanopolis","09782-025","São Bernardo do Campo","Apto 03F","SP","Rua Marechal deodoro,123"),
(5,"Jabaquara","09582-025","São Bernardo do Campo","Apto 85A","SP","Rua Alfredo reinaldin,50"),
(6,"Conceição","01236-025","São Bernardo do Campo","Apto 123","SP","Travessa Pranto no Mar,17"),
(7,"Vila Sonia","09912-024","São Bernardo do Campo","casa 1","SP","Rua Jorge Frances,13")
(22,"Mary Dota","22277-005","Rio Claro","casa 2","SP","Rua dos Comerciários,80"),
(23,"Jaragua","05032-025","Rio Claro","casa 12","SP","Rua dos Professores,12"),
(24,"Jardim Planalto","09500-025","Rio Claro","Apto 85A","SP","Rua Alfredo reinaldin,72"),
(25,"Monta Castelo","01211-025","Garça","casa 28","SP","Travessa Pranto,13"),
(26,"Santa Luzia","09933-024","Garça","casa 1","SP","Rua Jorge Franck,1");

insert into conta_bancaria(id_conta,agencia,chave_pix,cheque_especial,conta,limite,saldo,status_conta,tipo_chave_pix) value 
 (8,"2311","e63bd073152a4b08b6548a1571e0d844",true,"23112022-1",500.00,1000.00,true,1),
 (9,"2311","345.678.356-89",true,"23112022-2",500.00,100.00,true,2),
 (10,"2311","011-8525-6545",true,"23112022-3",200.00,100.00,true,3),
 (11,"2022","afgh@pags.com",true,"23112022-4",200.00,100.00,true,4),
 (12,"2311","ges35dkje7h88gak90jdbah6121hd900",false,"23112022-5",00.00,100.00,true,1),
 (13,"2311","741.852.963-89",false,"23112022-6",00.00,100.00,true,2),
 (14,"2022","011-2536-8546",true,"23112022-7",200.00,100.00,true,3),
 (15,"2311","l&l@pags.com",false,"23112022-8",00.00,100.00,true,4),
 (16,"2311","aa11bb22cc33dd44ee55ff66gg77ii88",true,"23112022-9",500.00,100.00,true,1),
 (17,"2311","07.012.855/0001-60",false,"23112022-10",00.00,100.00,true,2),
 (18,"2022","021 7412-8523",true,"23112022-11",500.00,100.00,true,3),
 (19,"2311","caracara@pags.com",true,"23112022-12",500.00,100.00,true,4),
 (20,"2311","a63bd0731sdajk7364nf8b6548a15710",true,"23112022-13",500.00,100.00,true,1),
 (21,"2022","03.072.822/0001-60",true,"23112022-14",500.00,100.00,true,2);	
 
insert into pessoa_fisica (cpf, email,status_cliente, telefone, nome, rg, conta_bancaria_id_conta,id_endereco) value
("123.456.789-12", "abc@pags.com",true,"011-5896-5689","Suellen Almeida Lopes","25.023.258-9",8,1),
("345.678.356-89", "ghi@pags.com",true,"011-4565-8596", "Camem Lucia da Silva","18.025.859-7",9,1),
("456.789.123-85", "uiu@pags.com",true,"011-8525-6545", "Kelly Cristina Soares","78.456.987-2",10,2),
("589.569.458-85", "afgh@pags.com",true,"011-2321-5252", "Julia Freitas Feliz ","78.456.859-2",11,2),
("100.456.799-12", "tyu@pags.com",true,"011-5555-8585", "Danilo Silva Barbosa","95.456.852-x",12,3),
("741.852.963-89", "oiu@pags.com",true,"011-8888-5263", "Pamella Eloi de Moura","85.789.258-x",13,4),
("863.951.753-78", "qaz@pags.com",true,"011-2536-8546", "Sarah Leila Queiroz ","85.159.357-2",14,5);

insert into pessoa_juridica(cnpj,email,status_cliente,telefone,razao_social,conta_bancaria_id_conta,id_endereco) value
("02.012.862/0001-60","l&l@pags.com",true,"021 5269-8569","lima&lima",15,6),
("02.016.862/0001-85","encanto@pags.com",true,"021 8502-5645","Sono Encantado",16,7),
("07.012.855/0001-60","lubalu@pags.com",true,"021 5259-8859","modas lubalu",17,22),
("02.001.456/0001-60","balaomagico@pags.com",true,"021 7412-8523","Balao magico",18,23),
("02.012.852/0001-60","caracara@pags.com",true,"021 5555-8569","cara cara",19,24),
("02.014.753/0001-50","docesluna@pags.com",true,"021 5519-8569","luna doces",20,25),
("03.072.822/0001-60","papellumina@pags.com",true,"021 5023-8569","papelaria lumina",21,26);



