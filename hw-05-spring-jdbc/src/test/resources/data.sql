insert into authors(name, surname)
values ('Александр', 'Пушкин');
insert into genres (genre_name) values ( 'Роман в стихах' );
insert into books(title, page_count, genre_id)
values ('Евгений Онегин', '251', 1);
insert into authors_books(author_id, book_id)
values (1, 1);