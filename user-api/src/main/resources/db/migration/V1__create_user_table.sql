create table user (
    id integer not null auto_increment,
    nome varchar(100) not null,
    cpf varchar(100) not null,
    endereco varchar(100) not null,
    email varchar(100) not null,
    telefone varchar(100) not null,
    data_cadastro timestamp not null,
    primary key(id)
)engine=InnoDB;