create table shop(
     id integer not null auto_increment,
     user_identifier varchar(100) not null,
     date timestamp not null,
     total float not null,
     primary key(id)
)engine=InnoDB;

create table item(
     product_identifier varchar(100) not null,
     price float not null,
     shop_id integer REFERENCES
     primary key(id) shopping.shop(id)
)engine=InnoDB;