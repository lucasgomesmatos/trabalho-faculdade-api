create table students
(
    create_at    timestamp(6),
    update_at    timestamp(6),
    registration uuid not null,
    email        varchar(255)                    not null unique,
    name         varchar(255)                    not null,
    primary key (registration)
);

