package com.infoshareacademy.wojownicy.service;

import com.infoshareacademy.wojownicy.dao.BookDaoBean;
import com.infoshareacademy.wojownicy.domain.entity.Book;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class BookService {

    @EJB
    private BookDaoBean bookDaoBean;

    public List<Book> findBookBySearchParam (String searchParam) {
        return bookDaoBean.findBookBySearchParam(searchParam);
    }
}
