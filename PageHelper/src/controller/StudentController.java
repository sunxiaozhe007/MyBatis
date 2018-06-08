package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.StudentService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    @Autowired
    @Qualifier("studentService")
    private StudentService studentService;

    @RequestMapping("list")
    public String list(HttpServletRequest request,Model model) {
        int pageNum=1;
        if (request.getParameter("pageNum")==null || "".equals(request.getParameter("pageNum"))){
            pageNum=1;
        }else {
            pageNum = Integer.parseInt(request.getParameter("pageNum"));
        }
        System.out.println(pageNum + "====page");
        model.addAttribute("student",studentService.findAll(pageNum));
        return "show";

    }
}
