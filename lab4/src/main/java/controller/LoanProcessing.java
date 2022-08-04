package controller;

import models.DaoModel;
import records.BankRecords;
import records.base.Person;
import records.base.YesOrNo;
import views.LoanView;

import java.io.*;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class LoanProcessing {
    // you can set criterion for good or bad pep label for new user
    static BigDecimal criterion = BigDecimal.valueOf(500);

    ResultSet rs;

    public static void main(String[] args) throws SQLException, IOException {

        BankRecords bankRecord = new BankRecords("C:\\Users\\86183\\IdeaProjects\\itmd510\\lab4\\bank-Detail.csv");
        bankRecord.readData();
        bankRecord.processData();
        DaoModel dao = new DaoModel();
        List<Person> objs = bankRecord.objs;


        Scanner sc = new Scanner(System.in);
        do {
            BigDecimal income;
            YesOrNo pep;
            menu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    dao.createTables();
                    break;
                case 2:
                    dao.inserts(objs);
                    break;
                case 3:
                    System.out.println("only input income and we generate the id auto ");
                    Scanner scan = new Scanner(System.in);
                    income = new BigDecimal(scan.nextLine());
                    pep = income.compareTo(criterion) >= 0 ? YesOrNo.YES : YesOrNo.NO;
                    dao.NewInsert(income, pep);
                    break;
                case 4:
                    // delete some id
                    System.out.println("input info you wanna update,for example 'id,income'");
                    Scanner update = new Scanner(System.in);
                    String[] info = update.nextLine().split(",");
                    String id = info[0];
                    income = new BigDecimal( info[1]);
                    pep= income.compareTo(criterion) >= 0 ? YesOrNo.YES : YesOrNo.NO;
                    dao.update(id,income,pep);
                    break;
                case 5:
                    // delete some id
                    System.out.println("input id you wanna delete");
                    Scanner delete = new Scanner(System.in);
                    dao.deletes(delete.nextLine());
                    break;
                case 6:
                    dao.printRecords();
                    break;
                case 7:
                    viewRecs(dao.getGoodRecords());
                    break;
                case 8:
                    serialObject(objs);
                    break;
                case 9:
                    deSerialObject();
                    break;

                case 10:
                    System.out.println("bye for now!");
                    System.exit(0);
            }
            System.out.println();
        } while (true);
    }

    public static void menu() {
        String menuItems = "1.Create table\n2.init Insert recs\n3.new Insert recs\n4.update recs" +
                "\n5.Delete recs\n6.print all Recs (Console)\n7.View good Recs (Window)" +
                "\n8.Serial recs\n9.deSerial Recs\n10.Exit";
        System.out.println(menuItems);
    }

    public static void viewRecs(ResultSet rs) {

        try {
            // get record data from result set object
            new LoanView().runView(rs); // display records in window
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void serialObject(List<Person> objs){
        HashMap<Long, Person> hmap = new HashMap<>();
        long i= 0L;
        for (Person obj : objs) {
            hmap.put( ++i,obj);
        }
        System.out.println("count of person is "+i);
        BankRecordSerialObject bankRecordSerialObject = new BankRecordSerialObject(hmap);
        try {
            FileOutputStream fos = new FileOutputStream("BankRecordSerialObject.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bankRecordSerialObject);
            oos.close();
            fos.close();
            System.out.print("Serialized HashMap data is saved in BankRecordSerialObject.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void deSerialObject() {

        BankRecordSerialObject beso;
        try {
            FileInputStream fis = new FileInputStream("BankRecordSerialObject.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            beso = (BankRecordSerialObject) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized HashMap..");
        // Display content using Iterator

        Set<Map.Entry<Long, Person>> set = beso.BRmap.entrySet();
        System.out.println(set);
        Iterator<Map.Entry<Long, Person>> iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Long, Person> mentry = iterator.next();
            System.out.print("key: " + mentry.getKey() + " & Value: ");
            System.out.println(mentry.getValue());
        }
    }
}
