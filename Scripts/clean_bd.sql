use SoulBank;

select * from hibernate_sequence;
update hibernate_sequence set next_val = next_val + 1; -- para acertar o numero do hibernete após colocar os inserts. Basta consultar que numero está e somar até chegar no 27 

select * from pessoa_fisica;
DELETE FROM pessoa_fisica WHERE cpf = "123.456.789-12";

select * from pessoa_juridica;
DELETE FROM pessoa_juridica WHERE cnpj = 123456987;

select * from endereco;
DELETE FROM endereco WHERE id_endereco in(17);

select * from transacao;
delete from transacao where id_transacao = 12;

select * from conta_bancaria;
DELETE FROM conta_bancaria WHERE id_conta in (8);