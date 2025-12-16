-- Insert test data for the 'book' table
INSERT INTO book (title, author)
VALUES
    ('The Great Gatsby', 'F. Scott Fitzgerald'),
    ('1984', 'George Orwell'),
    ('To Kill a Mockingbird', 'Harper Lee'),
    ('Moby Dick', 'Herman Melville'),
    ('War and Peace', 'Leo Tolstoy');

-- Insert test data for the 'customers' table
INSERT INTO customers (full_name, email, city)
VALUES
    ('John Doe', 'john.doe@example.com', 'New York'),
    ('Jane Smith', 'jane.smith@example.com', 'London'),
    ('Albert Einstein', 'albert.einstein@example.com', 'Berlin'),
    ('Isaac Newton', 'isaac.newton@example.com', 'Cambridge'),
    ('Marie Curie', 'marie.curie@example.com', 'Paris');

-- Insert test data for the 'users' table
INSERT INTO users (username, city, street, passport_number, passport_is_valid)
VALUES
    ('johnd', 'New York', '5th Avenue', 'XYZ123456', TRUE),
    ('jsmith', 'London', 'Baker Street', 'ABC987654', TRUE),
    ('aeinstein', 'Berlin', 'Unter den Linden', 'DEF456789', FALSE),
    ('inewton', 'Cambridge', 'Trinity Lane', 'GHI654321', TRUE),
    ('mcurie', 'Paris', 'Rue Madame', 'JKL123987', TRUE);

-- Insert test data for the 'buyers' table
INSERT INTO buyers (full_name)
VALUES
    ('Michael Brown'),
    ('Emily Davis'),
    ('Chris Wilson'),
    ('Sarah Johnson'),
    ('David Miller');

-- Insert test data for the 'shops' table
INSERT INTO shops (shop_name)
VALUES
    ('The Bookstore'),
    ('Tech World'),
    ('Fashion Outlet'),
    ('Grocery Mart'),
    ('Toy Planet');

-- Insert test data for the 'orders' table
INSERT INTO orders (buyer_id, shop)
VALUES
    (1, 1),
    (2, 2),
    (3, 3),
    (4, 4),
    (5, 5);

-- Insert test data for the 'products' table
INSERT INTO products (name, price)
VALUES
    ('Laptop', 1200.00),
    ('Smartphone', 800.00),
    ('T-shirt', 25.00),
    ('Book', 15.00),
    ('Toy Car', 35.00);

-- Insert test data for the 'order_items' table
INSERT INTO order_items (product_id, quantity, order_id, orders_key)
VALUES
    (1, 1, 1, 'ORD-001'),
    (2, 2, 2, 'ORD-002'),
    (3, 3, 3, 'ORD-003'),
    (4, 4, 4, 'ORD-004'),
    (5, 5, 5, 'ORD-005');

-- Insert test data for the 'box' table
INSERT INTO box (volume)
VALUES
    (50.5),
    (100.0),
    (75.3),
    (40.2),
    (85.0);

-- Insert test data for the 'item1' table
INSERT INTO item1 (name1, box1_id, list_key)
VALUES
    ('Item1-A', 1, 'List1'),
    ('Item1-B', 2, 'List2'),
    ('Item1-C', 3, 'List3'),
    ('Item1-D', 4, 'List4'),
    ('Item1-E', 5, 'List5');

-- Insert test data for the 'item2' table
INSERT INTO item2 (name2, box2_id)
VALUES
    ('Item2-A', 1),
    ('Item2-B', 2),
    ('Item2-C', 3),
    ('Item2-D', 4),
    ('Item2-E', 5);

-- Insert test data for the 'item3' table
INSERT INTO item3 (name3, box3_id, map_key)
VALUES
    ('Item3-A', 1, 'Map1'),
    ('Item3-B', 2, 'Map2'),
    ('Item3-C', 3, 'Map3'),
    ('Item3-D', 4, 'Map4'),
    ('Item3-E', 5, 'Map5');