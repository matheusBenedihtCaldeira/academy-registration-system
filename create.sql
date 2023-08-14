create table tb_customers (id bigserial not null, cpf varchar(255), email varchar(255) unique, name varchar(255), password varchar(255), primary key (id));
create table tb_operators (role smallint check (role between 0 and 2), id bigserial not null, email varchar(255), name varchar(255), operator_key varchar(255), password varchar(255), primary key (id));
