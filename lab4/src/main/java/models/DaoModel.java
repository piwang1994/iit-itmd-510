package models;

import records.Record;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DaoModel {
    static Statement stmt;
    static Connection conn;
    static Boolean create;
    public DaoModel() {
        try {
            // initialize any objects here
            conn = connect();
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        return new DBConnect().getConnection();
    }

    public static void menu() {
        String menuItems = "1.Create table\n2.Insert recs\n3.Update recs\n4.Delete recs\n5.View Recs (Console)\n6.View Recs (Window)\n7.Exit";
        System.out.println(menuItems);
    }
    public static void createTables() throws SQLException {
        String create_sql = "CREATE TABLE `records` (\n" +
                "  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `age` int DEFAULT NULL,\n" +
                "  `sex` varchar(5) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  `region` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  `income` decimal(20,2) DEFAULT NULL,\n" +
                "  `married` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  `children` tinyint DEFAULT NULL,\n" +
                "  `car` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  `save_act` char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  `current_act` char(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  `mortgage` char(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  `pep` char(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;";
        stmt.executeUpdate(create_sql);

    }

    public static void inserts() throws InterruptedException {

        // create an insert statement
        String sql = "";

        System.out.println("Inserting records...");
        try {
            conn.setAutoCommit(false);
            Record bankRecord = new Record("C:\\Users\\86183\\IdeaProjects\\itmd510\\lab2\\src\\main\\resources\\bank-Detail.csv");
            bankRecord.readData();
            List<ArrayList<String>> arr = bankRecord.arr;
            int size = arr.get(0).size();
            sql = "Insert Into records(id,age,sex,region,income,married,children,car,save_act,current_act,mortgage,pep)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?)";
            // execute query for insert(s)
            PreparedStatement ps = conn.prepareStatement(sql);

            for (int i = 0; i < arr.size(); i++) {
                for (int j = 0; j < size; j++) {
                    ps.setObject(j+1, arr.get(i).get(j));
                }
                ps.addBatch();

                if (i%50==0){
                    //2、执行batch
                    ps.executeBatch();
                    conn.commit();
                    //3、清空batch
                    ps.clearParameters();

                }
            }
            conn.commit();

            // System.out.println("Records inserted");

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }


        public static void updates(String desc, int id) {
        String SQL = "Update papa_coffee SET prod_desc = ? WHERE id = ?";
        // use prepared statement
        try (PreparedStatement pstmt = connect().prepareStatement(SQL)) {
            pstmt.setString(1, desc);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deletes(int id) {
        // finish implementing...
    }


    public static void retrieveRecords() {

        try {
            // get record data from result set object
            ResultSet rs = stmt.executeQuery("Select * from papa_coffee");
            while (rs.next()) {

                int id = rs.getInt(1);
                String desc = rs.getString("prod_desc");
                double price = Double.parseDouble(rs.getString("prod_price"));

                // print records to console
                System.out.println("Id : " + id + "\t  Desc. : " + desc + "\t  Price: " + price);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
