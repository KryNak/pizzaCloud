insert into ingredient values ('TNPD', 'thin pizza dough', 'PIZZA_DOUGH');
insert into ingredient values('TKPD', 'tick pizza dough', 'PIZZA_DOUGH');
insert into ingredient values('MIBF', 'beef mince', 'PROTEIN');
insert into ingredient values('CUCH', 'cuts of chicken', 'PROTEIN');
insert into ingredient values('TMTO', 'sliced tomato', 'VEGGIES');
insert into ingredient values('LETC', 'lettuce', 'VEGGIES');
insert into ingredient values('GOUD', 'gouda', 'CHEESE');
insert into ingredient values('CHED', 'cheddar', 'CHEESE');
insert into ingredient values('KECH', 'ketchup', 'SAUCE');
insert into ingredient values('SALS', 'salsa', 'SAUCE');

insert into user (id, city, full_name, password, phone_number, state, street, username, zip)
values (1, 'Elk', 'Seba Mebel', '{bcrypt}$2a$10$RyCqbwWzQVUugTu2Kz8FuOPGrHZqdwmU3SGqk4DnLnOHwmCHMQ7jy', '666982962', 'Mazowsze', 'Loza', 'sa', '07-123');
