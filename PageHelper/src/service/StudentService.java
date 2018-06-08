package service;

import com.github.pagehelper.PageInfo;

public interface StudentService {
    PageInfo findAll(int pageNum);
}
