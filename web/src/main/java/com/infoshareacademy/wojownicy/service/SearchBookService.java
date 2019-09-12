package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.Book;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
public class SearchBookService {

    @EJB
    private BookDaoBean bookDaoBean;


    public List<Book> getBooksList() {
        return bookDaoBean.getBooksList();
    }
}
