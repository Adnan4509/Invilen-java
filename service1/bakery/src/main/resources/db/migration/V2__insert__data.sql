-- ======================================
-- Insert sample data into category table
-- ======================================

INSERT INTO category (id, name, description) VALUES
(1, 'Cakes', 'Soft and delicious cakes for every occasion'),
(2, 'Cookies', 'Crunchy and chewy cookies baked to perfection'),
(3, 'Pastries', 'Flaky pastries with rich fillings'),
(4, 'Bread', 'Freshly baked loaves and buns'),
(5, 'Donuts', 'Sweet and fluffy donuts with various toppings');

-- ======================================
-- Insert sample data into bakery table
-- ======================================

INSERT INTO bakery (id, name, description, weight, available_quantity, price, category_id) VALUES
-- Cakes
(1, 'Chocolate Truffle Cake', 'Rich chocolate sponge with ganache frosting', '1 kg', 10, 599.00, 1),
(2, 'Vanilla Cream Cake', 'Classic vanilla layered cake with whipped cream', '1 kg', 8, 499.00, 1),
(3, 'Red Velvet Cake', 'Moist red velvet with cream cheese frosting', '1 kg', 6, 649.00, 1),
(4, 'Black Forest Cake', 'Chocolate sponge layered with cherries and cream', '1 kg', 12, 549.00, 1),
(5, 'Pineapple Cake', 'Light pineapple flavored cake with fruit topping', '1 kg', 9, 479.00, 1),
(6, 'Butterscotch Cake', 'Caramel butterscotch cake with crunchy nuts', '1 kg', 7, 529.00, 1),

-- Cookies
(7, 'Chocolate Chip Cookies', 'Crispy cookies loaded with chocolate chips', '250 g', 25, 149.00, 2),
(8, 'Oatmeal Raisin Cookies', 'Healthy oatmeal cookies with raisins', '250 g', 20, 139.00, 2),
(9, 'Butter Cookies', 'Classic Danish-style butter cookies', '250 g', 30, 129.00, 2),
(10, 'Almond Cookies', 'Crunchy almond cookies with nutty flavor', '250 g', 18, 159.00, 2),
(11, 'Peanut Butter Cookies', 'Soft cookies with rich peanut butter taste', '250 g', 22, 149.00, 2),
(12, 'Choco Fudge Cookies', 'Dark chocolate cookies with fudge chunks', '250 g', 15, 169.00, 2),

-- Pastries
(13, 'Chocolate Éclair', 'Choux pastry filled with chocolate cream', '100 g', 15, 89.00, 3),
(14, 'Strawberry Pastry', 'Vanilla pastry with strawberry topping', '100 g', 20, 79.00, 3),
(15, 'Blueberry Cheesecake Slice', 'Creamy cheesecake slice with blueberry topping', '120 g', 12, 99.00, 3),
(16, 'Tiramisu Pastry', 'Coffee-flavored layered Italian dessert', '100 g', 10, 109.00, 3),
(17, 'Puff Pastry', 'Light puff pastry with buttery layers', '90 g', 25, 69.00, 3),
(18, 'Caramel Delight Pastry', 'Caramel and cream layered pastry', '100 g', 18, 89.00, 3),

-- Bread
(19, 'Whole Wheat Bread', 'Healthy whole wheat loaf', '400 g', 25, 65.00, 4),
(20, 'White Bread', 'Soft and fresh white loaf', '400 g', 30, 55.00, 4),
(21, 'Multigrain Bread', 'Fiber-rich multigrain loaf', '400 g', 20, 75.00, 4),
(22, 'Garlic Bread', 'Toasted bread with garlic butter flavor', '200 g', 15, 85.00, 4),
(23, 'Baguette', 'Crispy French-style long bread', '300 g', 10, 95.00, 4),
(24, 'Buns (Pack of 4)', 'Soft and fluffy buns for burgers or snacks', '250 g', 18, 49.00, 4),

-- Donuts
(25, 'Chocolate Glazed Donut', 'Classic donut with chocolate glaze', '80 g', 20, 79.00, 5),
(26, 'Strawberry Frosted Donut', 'Pink frosted donut with sprinkles', '80 g', 18, 75.00, 5),
(27, 'Sugar-Coated Donut', 'Simple and sweet sugar dusted donut', '80 g', 25, 69.00, 5),
(28, 'Boston Cream Donut', 'Filled donut with vanilla custard and chocolate top', '90 g', 15, 89.00, 5),
(29, 'Cinnamon Donut', 'Soft donut with a cinnamon sugar coating', '80 g', 22, 79.00, 5),
(30, 'Blueberry Donut', 'Donut with blueberry filling and glaze', '80 g', 14, 85.00, 5);
