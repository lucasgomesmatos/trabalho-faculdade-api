CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

DELETE
FROM students;

insert into students (registration, name, email, create_at)
values (uuid_generate_v4(), 'João da Silva', 'joao@gmail.com', '2023-11-26T23:43:18.859645'),
       (uuid_generate_v4(), 'Maria da Silva', 'maria@gmail.com', '2023-11-26T23:43:18.859645'),
       (uuid_generate_v4(), 'Pedro Henrique', 'pedro@gmail.com', '2023-11-26T23:43:18.859645')
;