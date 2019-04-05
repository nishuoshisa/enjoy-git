package net.wanho.service;


import com.github.pagehelper.PageInfo;
import net.wanho.model.Student;
import net.wanho.util.JsonResult;


import java.util.List;

/**
 * Created by 胡梦娟 on 2018/11/26.
 */
public interface StudentServiceI {
    JsonResult checkStudent(Student student);
    PageInfo<Student> getStudentList(Student student,Integer pageNum);
    void addStudent(Student student);
    void deleteStudentById(Integer id);
    void updateStudent(Student student);
    Student getStudentById(Integer id);
}
