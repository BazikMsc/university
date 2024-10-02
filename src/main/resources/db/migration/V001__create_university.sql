CREATE TABLE university (
    id SERIAL PRIMARY KEY,
    alpha_two_code VARCHAR(10),
    country VARCHAR(100),
    domains TEXT[],
    name VARCHAR(255),
    state_province VARCHAR(100),
    web_pages TEXT[]
);