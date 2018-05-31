package service;

import domain.Book;
import mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    /**
     * 自动注入BookMapper
     * @return
     */
    @Autowired
    private BookMapper bookMapper;

    /**
     * 查找所有图书
     * @return
     */
    @Override
    public List<Book> getAll() {

        return bookMapper.findAll();
    }
}
