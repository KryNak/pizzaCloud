create table if not exists Ingredient (
    id varchar(4) not null,
    name varchar(35) not null,
    type varchar(30) not null
);

create table if not exists Pizza(
    id identity,
    name varchar(50) not null,
    createdAt timestamp not null
);

create table if not exists Pizza_Ingredients(
    pizza bigint not null,
    ingredient varchar(4) not null,
    foreign key (pizza) references Pizza(id),
    foreign key (ingredient) references Ingredient(id)
);

create table if not exists Pizza_Order(
    id identity,
    deliveryName varchar(50) not null,
    deliveryStreet varchar(50) not null,
    deliveryCity varchar(50) not null,
    deliveryState varchar(50) not null,
    deliveryZip varchar(10) not null,
    ccNumber varchar(16) not null,
    ccCVV varchar(3) not null,
    placedAt timestamp not null
);

create table if not exists Pizza_Order_Pizzas(
    pizzaOrder bigint not null,
    pizza bigint not null,
    foreign key (pizzaOrder) references Pizza_Order(id),
    foreign key (pizza) references Pizza(id)
)


