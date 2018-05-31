package controller;

import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

import java.util.List;

@Controller
public class BookController {
    /**
     * 自动注入BookService
     */
    @Autowired
    @Qualifier("bookService")
    private BookService bookService;


    @RequestMapping(value = "/main")
    public String main(Model model){
        //获得图书集合
        List<Book> book_list = bookService.getAll();
        //将图书信息添加到model当中
        model.addAttribute("book_list",book_list);
        //跳转到main页面
        return "main";
    }
}
