
CREATE DATABASE BtvnSpringbootAndJpa;
USE BtvnSpringbootAndJpa;
CREATE TABLE customer (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

-- Script tạo bảng "Đơn hàng" (Order)
CREATE TABLE orders (
    id INT AUTO_INCREMENT PRIMARY KEY,
    order_code VARCHAR(255) NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    customer_id INT,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- Script thêm dữ liệu mẫu vào bảng "Khách hàng" (Customer)
INSERT INTO customer (name, email)
VALUES
    ('Khách hàng 1', 'customer1@example.com'),
    ('Khách hàng 2', 'customer2@example.com'),
    ('Khách hàng 3', 'customer3@example.com');

-- Script thêm dữ liệu mẫu vào bảng "Đơn hàng" (Order)
INSERT INTO to (order_code, total_amount, customer_id)
VALUES
    ('ORDER001', 100.50, 1),
    ('ORDER002', 75.25, 2),
    ('ORDER003', 50.00, 1);
