package net.xuele.basic.service.impl;

/**
 * Created by yejj on 2017/9/6 0006.
 */
public class Student {

    public Student(String name) {
        this.name = name;
    }

    private String name = "ss";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
