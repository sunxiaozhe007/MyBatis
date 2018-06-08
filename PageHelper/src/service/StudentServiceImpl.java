package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.StudentDao;
import domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public PageInfo findAll(int pageNum) {
        PageHelper.startPage(pageNum,3);
        List<Student>list =  studentDao.findAll();

        System.out.println(list);
        PageInfo pageInfo = new PageInfo(list);
        System.out.println(pageInfo.getList());
        return pageInfo;
    }
}
