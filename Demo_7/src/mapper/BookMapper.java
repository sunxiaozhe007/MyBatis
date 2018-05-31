package mapper;

import domain.Book;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {

    /**
     * 查询所有图书信息
     */
    @Select("select * from book")
    List<Book> findAll();
}
