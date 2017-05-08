package serializable;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
public class Person  implements Serializable{

    private String firstName;
    private String lastName;
    private int age;
    private Person spouse;


    public Person(String fn, String ln, int a)
    {
        this.firstName = fn; this.lastName = ln; this.age = a;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public String toString()
    {
        return "[Person: firstName=" + firstName +
                " lastName=" + lastName +
                " age=" + age +
                " spouse=" + spouse.getFirstName() +
                "]";
    }
}
