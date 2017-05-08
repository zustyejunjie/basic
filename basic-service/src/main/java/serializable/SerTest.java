package serializable;

import java.io.*;

import static org.springframework.test.util.AssertionErrors.fail;

/**
 * Created by Administrator on 2017/5/2 0002.
 */
public class SerTest {
    public void serializeToDisk()
    {
        try
        {
            Person ted = new Person("Ted", "Neward", 39);
            Person charl = new Person("Charlotte","Neward", 38);

            ted.setSpouse(charl); charl.setSpouse(ted);

            FileOutputStream fos = new FileOutputStream("tempdata.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ted);
            oos.close();
        }
        catch (Exception ex)
        {
            fail("Exception thrown during test: " + ex.toString());
        }

        try
        {
            FileInputStream fis = new FileInputStream("tempdata.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person ted = (Person) ois.readObject();
            ois.close();

            // Clean up the file
            new File("tempdata.ser").delete();
        }
        catch (Exception ex)
        {
            fail("Exception thrown during test: " + ex.toString());
        }
    }

}
