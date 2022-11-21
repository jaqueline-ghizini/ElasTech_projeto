use SoulBank; 
-- para dar certo o hybernate tem que mudar a configuração do Safe. Ir no Edit > preferences > sql editor, no fim da pag desabilitar a opção safe update.
select * from hibernate_sequence;
update hibernate_sequence set next_val = next_val + 18; -- para acertar o numero do hibernete após colocar os inserts. Basta consultar que numero está e somar até chegar no 27 

select * from pessoa_fisica;
DELETE FROM pessoa_fisica WHERE cpf = "18398555";

select * from pessoa_juridica;
DELETE FROM pessoa_juridica WHERE cnpj = "58465774";

select * from endereco;
DELETE FROM endereco WHERE id_endereco in(1,5);

select * from transacao;
delete from transacao where id_transacao in (3,4,7,8);

select * from conta_bancaria;
DELETE FROM conta_bancaria WHERE id_conta in (2,6);