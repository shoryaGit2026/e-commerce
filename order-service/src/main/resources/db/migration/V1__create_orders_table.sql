CREATE TABLE orders (
    order_id BIGSERIAL PRIMARY KEY,
    product_id BIGINT,
    quantity INTEGER,
    price DOUBLE PRECISION,
    order_date_time TIMESTAMP,
    status VARCHAR(255)
);
