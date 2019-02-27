create database Library;
use Library;
DROP table books;
DROP table author;


create table author
(
author nvarchar(70) not null primary key,
country nvarchar(20) not null
);

create table books
(id_book int not null primary key,
name_of_book nvarchar(50) not null,
author nvarchar(70) not null, 
released date not null,
publishing_house nvarchar(50) not null, 
foreign key (author) references author (author)
);
insert into author (author, country) VALUES('?','?');

insert into author (author, country) 
values ('������� ������', '������'),
('���������� ������','��������'),
('������� �������','������'),
('Yakupov Nail', '��������'),
('Lui Mark', '���');


insert into books(id_book, name_of_book, author, released, publishing_house)
values 
(1, '�������', '������� ������', '1903-01-01','���������� ����������'),
(2, '�����', '���������� ������', '1914-01-01', '������ �����'),
(3, '����������� �������� ������', '������� �������', '2017-05-01', '�����������'),
(4, '���������� � �������', 'Yakupov Nail', '2017-01-01', '������'),
(5, 'James in Boston', 'Lui Mark', '2018-01-01', 'LibUk');
insert into books(id_book, name_of_book, author, released, publishing_house)
values 
(6, '���� ������', '������� ������', '1905-01-01','���������� ����������'),
(7, '�� ���', '������� ������', '1903-01-01','���������� ����������'),
(8, '������', '������� ������', '1903-01-01','���������� ����������');

insert into books(id_book, name_of_book, author, released, publishing_house)
values 
(9, '������� �����', '���������� ������', '1910-01-01', '������ �����'),
(10, '�������', '���������� ������', '1911-01-17', '������ �����');

select author.author, author.country from author
 inner join books on author.author = books.author
 group by author.author, author.country
 having count(*) > 1;

delete from books where released < '1904';
select *from books;

select * from books where YEAR(released) = YEAR(getdate());

select * from books where year(released) =year(getdate()) or
year(released) = year(dateadd(year, -1, getdate()));


select name_of_book from books where YEAR(released) = YEAR(getdate());