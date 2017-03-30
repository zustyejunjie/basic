package guava.collection;

import com.google.common.collect.LinkedHashMultimap;
import guava.Student;

import java.util.Set;

/**
 * Created by Administrator on 2017/3/30 0030.
 */
public class LikedListMutiMapTest {


    public static void main(String[] args) {
        LinkedHashMultimap<String,Student> map  =LinkedHashMultimap.create();

        Student student = new Student();
        student.setId(11);
        map.put("11",student);

        Student student1 = new Student();
        student1.setId(22);
        map.put("11",student1);

        Set<Student> ss = map.get("11");

        System.out.print(ss);

    }
}
