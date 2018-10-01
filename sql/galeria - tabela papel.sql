use galeria;

drop table pap_papel;

create table pap_papel(
	pap_id bigint(20) primary key auto_increment,
    pap_descricao varchar(50) not null unique
	);
    
alter table usr_usuario add constraint foreign key (usr_id_papel) references pap_papel(pap_id);

commit;

insert into pap_papel(pap_descricao) values("Visitante");
insert into pap_papel(pap_descricao) values("Usuario Comum");
insert into pap_papel(pap_descricao) values("Administrador");

#SELECT * FROM galeria.pap_papel;

commit;