package net.xuele.basic.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by yejj on 2017/9/6 0006.
 */
public class SpringTest  {

    @Test
    public void test1(){
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("applicationContext-test.xml"));


        Student student = (Student) beanFactory.getBean("student2");



        System.out.println(student.getName());
    }

}
