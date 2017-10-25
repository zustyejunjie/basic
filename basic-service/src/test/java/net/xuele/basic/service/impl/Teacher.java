package net.xuele.basic.service.impl;

/**
 * Created by yejj on 2017/9/6 0006.
 */
public class Teacher {


    private String name;

    private String age;

    private String cla;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {

        if(cla.equals("yes")){
            name = name +"yes";
        }

    }
}
