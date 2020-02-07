# Spring testing app 
Example: Simple to-do list

![](crud_ex.png)


DB: 
create table if not exists notes(
    id bigint primary key auto_increment,
    author varchar(20),
    title varchar(50) not null,
    note varchar(255) not null
);
