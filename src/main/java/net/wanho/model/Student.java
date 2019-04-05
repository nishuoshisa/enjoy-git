package net.wanho.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 胡梦娟 on 2018/11/16.
 */
@Data
public class Student implements Serializable {
    private Integer id;
    private String name;
    private Integer age;
    private String password;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
