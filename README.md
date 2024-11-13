## Database setup

```
create schema if not exists slaughterhouse_schema;
set schema 'slaughterhouse_schema';

GRANT USAGE ON SCHEMA slaughterhouse_schema TO postgres;
GRANT SELECT ON ALL TABLES IN SCHEMA slaughterhouse_schema TO postgres;

DROP table if exists animal, animal_part, tray, mixed_product_tray, same_part_product_tray, mixed_product, same_part_product;

create table animal
(
    id SERIAL primary key,
    animal_reg_no  varchar(255) unique not null,
    animal_type   varchar(20),
    arrival_date DATE not null,
    animal_weight numeric(10, 2) not null,
    origin varchar (255) not null
);

INSERT INTO animal (animal_reg_no, animal_type, arrival_date, animal_weight, origin)VALUES ('aaaaa', 'beef', '2020-12-10', 33.50, 'uncle donald farm');
INSERT INTO animal(animal_reg_no, animal_type, arrival_date, animal_weight, origin) VALUES ('bbbbb', 'chicken', '2023-12-11', 20.44, 'no farm');
INSERT INTO animal(animal_reg_no, animal_type, arrival_date, animal_weight, origin) VALUES ('ccccc', 'pork', '2023-12-11', 130.49, 'yes farm');
INSERT INTO animal(animal_reg_no, animal_type, arrival_date, animal_weight, origin) VALUES ('dddd', 'beef', '2023-12-11', 240.44, 'no farm');
INSERT INTO animal(animal_reg_no, animal_type, arrival_date, animal_weight, origin) VALUES ('eeee', 'pork', '2023-12-11', 210.44, 'yes farm');


create table tray
(
    tray_id      serial primary key,
    part_type    varchar(40) not null,
    total_weight numeric(10, 2) CHECK ( tray.total_weight <= capacity) default 0,
    capacity    numeric(10,2) not null
);

insert into tray (part_type, total_weight, capacity) values ('legs', 400, 500);
insert into tray (part_type, total_weight, capacity) values ('brain', 100, 500);
insert into tray (part_type, total_weight, capacity) values ('back', 200, 500);
insert into tray (part_type, total_weight, capacity) values ('breast', 300, 500);
insert into tray (part_type, total_weight, capacity) values ('hearts', 400, 500);
insert into tray (part_type, total_weight, capacity) values ('eyes', 440, 500);



create table animal_part
(
    part_id            serial primary key,
    part_type          varchar(20) not null,
    part_weight        numeric(10, 2) not null,
    origin_animal_id    int,
    tray_id            int,
    FOREIGN KEY (origin_animal_id) references animal (id),
    FOREIGN KEY (tray_id) references tray (tray_id)
);

insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.50, 1, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.50, 1, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.50, 1, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.50, 1, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('brain', 20.00, 1, 2);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('heart', 1.45, 1, 5);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 2, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 2, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 3, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 3, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 3, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 3, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 4, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 4, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 4, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('leg', 10.20, 4, 1);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('heart', 0.55, 2, 5);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('breast', 0.22, 2, 4);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('breast', 1.22, 3, 4);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('breast', 1.22, 3, 4);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('back', 5.34, 3, 3);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('back', 5.34, 3, 3);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('back', 5.34, 4, 3);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('back', 5.34, 4, 3);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('back', 5.34, 5, 3);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('back', 5.34, 5, 3);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 1, 6);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 1, 6);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 2, 6);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 2, 6);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 3, 6);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 3, 6);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 4, 6);
insert into animal_part (part_type, part_weight, origin_animal_id, tray_id) VALUES ('eyes', 0.20, 4, 6);


create table same_part_product
(
    product_id      serial primary key,
    part_type       varchar(40),
    number_of_parts  smallint,
    weight         numeric(10, 2),
    package_date    date CHECK ( package_date < same_part_product.expiration_date AND package_date <= current_date),
    expiration_date date CHECK ( expiration_date > current_date )
);

insert into same_part_product(part_type, number_of_parts, weight, package_date, expiration_date) values ('legs', 2, 30, '01/01/1800', '01/02/2090');
insert into same_part_product(part_type, number_of_parts, weight, package_date, expiration_date) values ('legs2', 2, 30, '01/01/1800', '01/02/2090');
insert into same_part_product(part_type, number_of_parts, weight, package_date, expiration_date) values ('legs3', 2, 30, '01/01/1800', '01/02/2090');
insert into same_part_product(part_type, number_of_parts, weight, package_date, expiration_date) values ('legs4', 2, 30, '01/01/1800', '01/02/2090');
insert into same_part_product(part_type, number_of_parts, weight, package_date, expiration_date) values ('legs5', 2, 30, '01/01/1800', '01/02/2090');
insert into same_part_product(part_type, number_of_parts, weight, package_date, expiration_date) values ('legs6', 2, 30, '01/01/1800', '01/02/2090');
insert into same_part_product(part_type, number_of_parts, weight, package_date, expiration_date) values ('legs7', 2, 30, '01/01/1800', '01/02/2090');

create table mixed_product
(
    product_id      serial primary key,
    product_name    varchar(40),
    weight         numeric(10, 2),
    package_date    date CHECK ( package_date < mixed_product.expiration_date AND package_date <= current_date),
    expiration_date date CHECK ( expiration_date > current_date )
);

insert into mixed_product(product_name, weight, package_date, expiration_date) values ('half cow', 50, '01/01/1800', '01/02/2090');
insert into mixed_product(product_name, weight, package_date, expiration_date) values ('half chicken', 50, '01/01/1800', '01/02/2090');
insert into mixed_product(product_name, weight, package_date, expiration_date) values ('half human', 50, '01/01/1800', '01/02/2090');
insert into mixed_product(product_name, weight, package_date, expiration_date) values ('half cow', 50, '01/01/1800', '01/02/2090');
insert into mixed_product(product_name, weight, package_date, expiration_date) values ('half cow', 50, '01/01/1800', '01/02/2090');


create table same_part_product_tray
(
    tray_id    int,
    product_id int,
    PRIMARY KEY (tray_id, product_id),
    FOREIGN KEY (tray_id) references tray (tray_id),
    FOREIGN KEY (product_id) references same_part_product (product_id)
);


insert into same_part_product_tray values (2, 5);
insert into same_part_product_tray values (2,6);
insert into same_part_product_tray values (2,7);
insert into same_part_product_tray values (2,4);
insert into same_part_product_tray values (3, 5);
insert into same_part_product_tray values (3,6);
insert into same_part_product_tray values (3,7);
insert into same_part_product_tray values (4, 6);
insert into same_part_product_tray values (5, 7);
insert into same_part_product_tray values (6, 6);
insert into same_part_product_tray values (6,7);
insert into same_part_product_tray values (6, 5);

create table mixed_product_tray
(
    tray_id    int,
    product_id int,
    PRIMARY KEY (tray_id, product_id),
    FOREIGN KEY (tray_id) references tray (tray_id),
    FOREIGN KEY (product_id) references mixed_product (product_id)
);

insert into mixed_product_tray values(2, 1);
insert into mixed_product_tray values(2, 2);
insert into mixed_product_tray values(2, 3);
insert into mixed_product_tray values(3, 2);
insert into mixed_product_tray values(3,1);
insert into mixed_product_tray values(4, 2);
insert into mixed_product_tray values(4,3);
insert into mixed_product_tray values(4,4);
insert into mixed_product_tray values(5,4);
insert into mixed_product_tray values(5,5);
insert into mixed_product_tray values(6,5);
insert into mixed_product_tray values(6,4);
insert into mixed_product_tray values(6,3);


```
