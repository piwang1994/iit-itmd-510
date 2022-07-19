import java.io.IOException;

public class boot {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
//        BankRecords bankRecords = new BankRecords("bank-Detail.csv");
        BankRecords bankRecords = new BankRecords("C:\\Users\\86183\\IdeaProjects\\itmd510\\lab2\\src\\main\\resources\\bank-Detail.csv");
        bankRecords.readData();
        bankRecords.processData();
        bankRecords.printData();
    }
}
