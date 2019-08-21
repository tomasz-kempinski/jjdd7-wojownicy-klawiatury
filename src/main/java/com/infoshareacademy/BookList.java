package com.infoshareacademy;

import static com.infoshareacademy.BookRepository.getBookRepository;

import java.util.List;


class BookList {

    void listBooks() {
        BooksPrinter.printListOfBooks(getBookRepository());
    }
}
