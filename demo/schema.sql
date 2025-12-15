CREATE TABLE IF NOT EXISTS airports (
    airport_code VARCHAR(3) PRIMARY KEY,
    city VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS flights (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_number VARCHAR(20) NOT NULL,
    departure_time DATETIME NOT NULL,
    origin_code VARCHAR(3),
    destination_code VARCHAR(3),
    FOREIGN KEY (origin_code) REFERENCES airports(airport_code),
    FOREIGN KEY (destination_code) REFERENCES airports(airport_code)
);

CREATE TABLE IF NOT EXISTS seats (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,
    seat_number VARCHAR(5) NOT NULL,
    class_type VARCHAR(20),
    flight_id INT NOT NULL,
    customer_id INT,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id),
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);