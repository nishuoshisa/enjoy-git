package net.wanho.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.wanho.constant.PageInfoConstant;
import net.wanho.mapper.StudentMapper;
import net.wanho.model.Student;
import net.wanho.service.StudentServiceI;
import net.wanho.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 胡梦娟 on 2018/11/27.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentServiceI {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JsonResult checkStudent(Student student) {
        JsonResult result = new JsonResult();
        List<Student> list=null;
        try {
           list = studentMapper.checkStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
         throw new RuntimeException("登陆查询学生异常");
        }
        if(list.size()==0){
            result.setCode(400);
            result.setMsg("用户名或密码错误");
        }else {
            String name = list.get(0).getName();
            result.setCode(200);
            result.setMsg("欢迎"+name+"登陆");
        }
        return result;
    }

    @Override
    @Transactional
    public PageInfo<Student> getStudentList(Student student, Integer pageNum) {
        List<Student> list = null;
        try {
            list = studentMapper.getStudentList(student);
        } catch (Exception e) {
            throw new RuntimeException("查询学生异常");
        }
        int pageSize = PageInfoConstant.PAGE_SIZE;
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Student> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public void addStudent(Student student) {
        try {
            studentMapper.addStudent(student);
        } catch (Exception e) {
            throw new RuntimeException("新增学生异常");
        }
    }

    @Override
    public void deleteStudentById(Integer id) {
        try {
            studentMapper.deleteStudentById(id);
        } catch (Exception e) {
            throw new RuntimeException("删除学生异常");

        }
    }

    @Override
    public void updateStudent(Student student) {

        try {
            studentMapper.updateStudent(student);
        } catch (Exception e) {
            throw new RuntimeException("新增学生异常");

        }
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student=null;
        try {
         student = studentMapper.getStudentById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

}
