create table products (
    id integer not null auto_increment,
    nome varchar(100) not null,
    descricao varchar not null,
    preco float not null,
    category_id integer REFERENCES
    primary key(id) products.category(id)
)engine=InnoDB;