SELECT * FROM we2foodiesdb.resources;

SELECT * FROM we2foodiesdb.menuitems;
update we2foodiesdb.resources set TYPE='jumbotron';

commit;

alter table we2foodiesdb.MenuItems
add column type varchar(25);


create table MenuItems(
id int,
description varchar(200),
cost long,
unit varchar(20),
primary key(id),
Foreign key(id) REFERENCES resources(id)
);



