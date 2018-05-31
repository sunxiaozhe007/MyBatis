package service;

import domain.Book;

import java.util.List;

public interface BookService {
    /**
     * 查找所有图书
     */
    List<Book> getAll();
}
