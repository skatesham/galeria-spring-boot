
create database galeria;

use galeria;

drop table usr_galeria;

create table usr_usuario(
	usr_id bigint(20) primary key auto_increment,
    usr_nome varchar(50) not null,
    usr_senha varchar(250) not null,
    usr_usuario varchar(25) not null unique,
    usr_email varchar(50) not null unique
);

alter table usr_usuario add column usr_id_papel bigint(20) not null;

commit;

insert into usr_usuario(usr_nome, usr_senha, usr_usuario, usr_email, usr_id_papel) values("Administrador", "admin", "admin", "admin@admin.com", 3);

insert into usr_usuario(usr_nome, usr_senha, usr_usuario, usr_email, usr_id_papel) values("Sham Vinicius", "123", "sham", "sham@admin.com", 2);

insert into usr_usuario(usr_nome, usr_senha, usr_usuario, usr_email, usr_id_papel) values("Lucao", "123", "lucas", "lucas@admin.com", 2);

commit;

select count(usr_id) from usr_usuario;

#select * from usr_usuario where usr_id = 105 or 1=1;




