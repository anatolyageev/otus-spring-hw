insert into authors(name, surname)
values ('Александр', 'Пушкин');
insert into authors(name, surname)
values ('Лев', 'Толстой');
insert into authors(name, surname)
values ('Федор', 'Достоевский');
insert into authors(name, surname)
values ('Илья', 'Ильф');
insert into authors(name, surname)
values ('Евгений', 'Петров');

insert into genres (genre_name) values ( 'Сатира' );
insert into genres (genre_name) values ( 'Роман в стихах' );
insert into genres (genre_name) values ( 'Роман' );

insert into books(title, page_count, genre_id)
values ('Двенадцать стульев', '451', 1);
insert into books(title, page_count, genre_id)
values ('Золотой теленок', '351', 1);
insert into books(title, page_count, genre_id)
values ('Евгений Онегин', '251', 2);
insert into books(title, page_count, genre_id)
values ('Война и Мир', '1251', 3);
insert into books(title, page_count, genre_id)
values ('Идиот', '451', 3);

insert into comments(comment, book_id )
values ('bla-bla1',1);
insert into comments(comment, book_id )
values ('bla-bla1',2);
insert into comments(comment, book_id )
values ('bla-bla1',3);
insert into comments(comment, book_id )
values ('bla-bla1',4);
insert into comments(comment, book_id )
values ('bla-bla1',5);

insert into authors_books(author_id, book_id)
values (1, 3);
insert into authors_books(author_id, book_id)
values (2, 4);
insert into authors_books(author_id, book_id)
values (3, 5);
insert into authors_books(author_id, book_id)
values (4, 1);
insert into authors_books(author_id, book_id)
values (4, 2);
insert into authors_books(author_id, book_id)
values (5, 1);
insert into authors_books(author_id, book_id)
values (5, 2);