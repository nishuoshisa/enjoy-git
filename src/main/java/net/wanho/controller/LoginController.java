package net.wanho.controller;

import net.wanho.model.Student;
import net.wanho.service.StudentServiceI;
import net.wanho.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 胡梦娟 on 2018/11/27.
 */
@Controller
@RequestMapping("login")
public class LoginController {
    @Autowired
    private StudentServiceI studentService;

    @RequestMapping()
    public String showLogin(){
        return "login";
    }

    @RequestMapping("checkLogin")
    @ResponseBody
    public JsonResult toLogin(Student student, HttpServletRequest request){

        JsonResult result = studentService.checkStudent(student);
        if(result.getCode()==200){
            HttpSession session = request.getSession();
            session.setAttribute("student",result.getData());
        }
        return result;
    }
}
