package cn.edu.ntu.javase.io;

import cn.edu.ntu.javase.common.model.Person;

import java.io.*;

/**
 * @author zack <br>
 * @create 2020-04-04 23:25 <br>
 */
public class SerializeTest {
    public static void main(String[] args) throws IOException {
        // Initializes The Object
        Person person = new Person();
        person.setName("hollis");
        person.setAge(23);
        System.out.println(person);

        // Write Obj to File
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }

        // Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Person newPerson = (Person) ois.readObject();
            System.out.println(newPerson);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            ois.close();
            file.delete();
        }
    }
}
