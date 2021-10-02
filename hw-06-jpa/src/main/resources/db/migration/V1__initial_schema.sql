drop table if exists authors;
drop table if exists books;
drop table if exists genres;

create table authors
(
    id      bigint auto_increment primary key,
    name    varchar(255),
    surname varchar(255)
);

create table genres
(
    id         bigint auto_increment primary key,
    genre_name varchar(255)
);



create table books
(
    id         bigint auto_increment primary key,
    title      varchar(255),
    page_count INTEGER,
    genre_id   bigint,
    foreign key (genre_id) references genres (id)
);

create table comments
(
    id      bigint auto_increment primary key,
    comment varchar(2000),
    book_id bigint,
    foreign key (book_id) references books (id)
);

create table authors_books
(
    author_id bigint not null,
    book_id   bigint not null references books (id) on delete cascade,

    foreign key (author_id)
        references authors (id),
    foreign key (book_id)
        references books (id)
)
