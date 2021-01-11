delete from Pizza_Order_Pizzas;
delete from Pizza_Ingredients;
delete from Pizza;
delete from Pizza_Order;

delete from Ingredient;
insert into Ingredient(id, name, type)
values ('TNPD', 'thin pizza dough', 'PIZZA_DOUGH'),
       ('TKPD', 'tick pizza dough', 'PIZZA_DOUGH'),
       ('MIBF', 'beef mince', 'PROTEIN'),
       ('CUCH', 'cuts of chicken', 'PROTEIN'),
       ('TMTO', 'sliced tomato', 'VEGGIES'),
       ('LETC', 'lettuce', 'VEGGIES'),
       ('GOUD', 'gouda', 'CHEESE'),
       ('CHED', 'cheddar', 'CHEESE'),
       ('KECH', 'ketchup', 'SAUCE'),
       ('SALS', 'salsa', 'SAUCE')
