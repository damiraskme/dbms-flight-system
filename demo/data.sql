INSERT INTO airports (airport_code, city, country) VALUES
('BOS', 'Boston', 'USA'),
('ALA', 'Almaty', 'Kazakhstan'),
('SVO', 'Moscow', 'Russia'),
('JFK', 'NYC', 'USA'),
('CDG', 'Paris', 'France'),
('MAD', 'Madrid', 'Spain'),
('BSB', 'Brazilia', 'Brazil'),
('HKG', 'Hong Kong', 'China'),
('FRA', 'Frankfurt', 'Germany'),
('IST', 'Istanbul', 'Turkey'),
('HND', 'Tokyo', 'Japan');

INSERT INTO flights (flight_number, departure_time, origin_code, destination_code) VALUES
('KZ001', '2025-05-01 14:00:00', 'BOS', 'ALA'),
('RU002', '2025-05-02 16:00:00', 'BOS', 'SVO'),
('US003', '2025-05-03 08:00:00', 'BOS', 'JFK'),
('FR004', '2025-05-04 10:00:00', 'BOS', 'CDG'),
('ES005', '2025-05-05 12:00:00', 'BOS', 'MAD'),
('BR006', '2025-05-06 22:00:00', 'BOS', 'BSB'),
('CN007', '2025-05-07 05:00:00', 'BOS', 'HKG'),
('DE008', '2025-05-08 13:00:00', 'BOS', 'FRA'),
('TR009', '2025-05-09 11:00:00', 'BOS', 'IST'),
('JP010', '2025-05-10 09:00:00', 'BOS', 'HND');


INSERT INTO customers (first_name, last_name, email) VALUES
('Alice', 'Smith', 'alice@test.com'),
('Bob', 'Jones', 'bob@test.com'),
('Charlie', 'Brown', 'charlie@test.com'),
('David', 'White', 'david@test.com'),
('Eve', 'Black', 'eve@test.com'),
('Frank', 'Green', 'frank@test.com'),
('Grace', 'Hall', 'grace@test.com'),
('Heidi', 'Klum', 'heidi@test.com'),
('Ivan', 'Drago', 'ivan@test.com'),
('Judy', 'Fosters', 'judy@test.com');


INSERT INTO seats (seat_number, class_type, flight_id, customer_id) VALUES
('1A', 'Economy', 1, 1),
('1B', 'Economy', 1, 2),
('1C', 'Economy', 1, 3),
('2A', 'Economy', 1, 4),
('2B', 'Economy', 1, 5),
('10A', 'Business', 1, 6),
('10B', 'Business', 1, 7),
('11A', 'Business', 1, 8),
('11B', 'Business', 1, 9),
('12A', 'Business', 1, 10);