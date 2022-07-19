import java.io.IOException;

public abstract class Client {
    /*
    -Create an abstract class called Client.java to allow for three abstract methods the bank needs to process.
     Name your methods readData(), processData() and printData()
     */
    public abstract void readData() throws IOException;

    public abstract void processData();

    public abstract void printData() throws NoSuchFieldException, IllegalAccessException;

}
