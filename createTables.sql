create sequence book_sequence start with 1 increment by 50;

    create table Book (
       serialNumber bigint not null,
        authorName varchar(255),
        bookQuantity integer not null,
        bookQuantityCopy integer not null,
        bookTitle varchar(255),
        primary key (serialNumber)
    );
create sequence book_sequence start with 1 increment by 50;

    create table Book (
       serialNumber bigint not null,
        authorName varchar(255),
        bookQuantity integer not null,
        bookQuantityCopy integer not null,
        bookTitle varchar(255),
        primary key (serialNumber)
    );
