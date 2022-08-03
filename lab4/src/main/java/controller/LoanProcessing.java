package controller;

import models.DaoModel;
import records.BankRecords;
import records.base.Person;
import records.base.YesOrNo;
import views.LoanView;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


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
                    BigDecimal income = new BigDecimal(scan.nextLine());
                    YesOrNo pep = income.compareTo(criterion) >= 0 ? YesOrNo.YES : YesOrNo.NO;
                    dao.NewInsert(income, pep);
                    break;
                case 4:
                    // delete some id
                    System.out.println("input id you wanna delete");
                    Scanner delete = new Scanner(System.in);
                    dao.deletes(delete.nextLine());
                    break;
                case 5:
                    dao.printRecords();
                    break;
                case 6:
                    viewRecs(dao.getGoodRecords());
                    break;
                case 7:
                    System.out.println("bye for now!");
                    System.exit(0);
            }
            System.out.println();
        } while (true);
    }

    public static void menu() {
        String menuItems = "1.Create table\n2.init Insert recs\n3.new Insert recs\n4.Delete recs\n5.print Recs (Console)\n6.View Recs (Window)\n7.Exit";
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
}
