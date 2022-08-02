package serial_demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

//import java.io.*;
public class DeserializeDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/resources/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("serial_demo.Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized serial_demo.Employee...");
        System.out.println("Name: " + e.name);
        System.out.println("Address: " + e.address);
        System.out.println("SSN: " + e.SSN);
        System.out.println("Number: " + e.number);

    }
}
