package controller;

import models.DaoModel;

import java.sql.SQLException;
import java.util.Scanner;

import static models.DaoModel.*;

public class LoanProcessing {


    public static void main(String[] args) throws InterruptedException, SQLException {

        new DaoModel();
        Scanner sc = new Scanner(System.in);
        do {
            menu();
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    createTables();
                case 2:
                    inserts();
                    break;
                case 3:
                    updates("Nova Coffee", 1);
                    break;
                case 4:
                    // delete some id
                    // deletes(id);
                    break;
                case 5:
                    retrieveRecords();
                    break;
                case 7:
                    System.out.println("bye for now!");
                    System.exit(0);
            }
            System.out.println();
        } while (true);
    }
}
