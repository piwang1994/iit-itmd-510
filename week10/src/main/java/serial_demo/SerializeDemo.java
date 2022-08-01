package serial_demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "James Papademas";
        e.address = "3300 S. Federal";
        e.SSN = 11122333;
        e.number = 100;
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved as employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
