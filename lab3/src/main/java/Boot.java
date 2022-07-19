import java.io.IOException;

public class Boot {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
//        BankRecords bankRecords = new BankRecords("bank-Detail.csv");
        Record bankRecord = new Record("C:\\Users\\86183\\IdeaProjects\\itmd510\\lab2\\src\\main\\resources\\bank-Detail.csv");
        bankRecord.readData();
        bankRecord.processData();
        int len=bankRecord.objs.size();

        Header[] objs = bankRecord.objs.toArray(new Header[len]);
        bankRecord.avgMaleAndFemale(objs,new SexComparator());
        bankRecord.numOfFemaleWithAccount(objs,new SexComparator());
        bankRecord.numOfMaleWithCarAndOneChildPerLoc(objs,new LocationComparator());
        Record.fw.close();

    }
}
