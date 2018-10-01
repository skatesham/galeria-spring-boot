use galeria;

drop table ima_imagem;

create table ima_imagem(
	ima_id bigint(20) primary key auto_increment,
    ima_id_usuario bigint(20) not null,
    ima_nome varchar(50) not null,
    ima_tamanho varchar(20) not null,
    ima_tipo varchar(20) not null,
    ima_imagem tinyblob not null,
    ima_string varchar(250)
    );
    
alter table ima_imagem add constraint foreign key (ima_id_usuario) references usr_usuario(usr_id);

select * from ima_imagem;
