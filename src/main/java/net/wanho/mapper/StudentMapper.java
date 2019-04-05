package net.wanho.mapper;



import net.wanho.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 胡梦娟 on 2018/11/16.
 */
public interface StudentMapper {
    List<Student> checkStudent(Student student);
    List<Student> getStudentList(@Param("student")Student student );
    void addStudent(Student student);
    void deleteStudentById(@Param("id")Integer id);
    void updateStudent(Student student);
    Student getStudentById(@Param("id")Integer id);

}
