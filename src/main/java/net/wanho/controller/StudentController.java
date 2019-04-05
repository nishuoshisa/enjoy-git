package net.wanho.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.constant.PageInfoConstant;
import net.wanho.model.Student;
import net.wanho.service.StudentServiceI;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by 胡梦娟 on 2018/11/27.
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentServiceI studentService;

    @RequestMapping
    public String Menu(@RequestParam(required = false)String name,@RequestParam(required = false)Integer age
            ,@RequestParam(defaultValue = "1")Integer pageNum,Map map){
        int pageSize=PageInfoConstant.PAGE_SIZE;
        PageHelper.startPage(pageNum,pageSize);
        Student student=new Student(name,age);
        PageInfo<Student> pageInfo = studentService.getStudentList(student,pageNum);
        map.put("pageInfo",pageInfo);
        map.put("name",name);
        map.put("age",age);
        return "success";
    }

    @RequestMapping("getStudentById/{id}")
    public String getStudentId(@PathVariable Integer id, Map map) {
        Student student = studentService.getStudentById(id);
        map.put("student", student);
        return "update";
    }

    @RequestMapping("updateStudent")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "redirect:/student";
    }

    @RequestMapping("add")
    public String add() {
        return "add";
    }

    @RequestMapping("addStudent")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "redirect:/student";
    }

    @RequestMapping("deleteStudent/{id}")
    public String addStudent(@PathVariable Integer id) {
        studentService.deleteStudentById(id);
        return "redirect:/student";
    }
}
