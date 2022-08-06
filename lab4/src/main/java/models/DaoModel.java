package models;

import records.base.Person;
import records.base.YesOrNo;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

public class DaoModel {
    public static Statement stmt;
    public static Connection conn;

    public DaoModel() {
        try {
            // initialize any objects here
            conn = connect();
            conn.setAutoCommit(true);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection connect() throws SQLException {
        return new DBConnect().getConnection();
    }
    public void update(String Id,BigDecimal income,YesOrNo pep) throws SQLException {
        String SQL = "select max(pid) pid from  records where Id='"+Id+"'";
        ResultSet resultSet = stmt.executeQuery(SQL);
        if (resultSet.next()) {
            if (resultSet.getString("pid") != null) {
                SQL = "replace into records(pid,id,income,pep) values(" + "'"+resultSet.getString("pid")+ "'" + ",?,?,?)";
            } else {
                SQL = "replace into records(id,income,pep) values(?,?,?)";
            }
        }
        System.out.println(SQL);
        // use prepared statement
        try (PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, Id);
            pstmt.setObject(2, income);
            pstmt.setString(3, pep.name());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletes(String id) throws SQLException {
        // finish implementing...
        int rs = stmt.executeUpdate("delete from records where id=" + "'" + id + "'");
    }

    public void printRecords() {

        try {
            // get record data from result set object
            ResultSet rs = stmt.executeQuery("Select * from records");
            while (rs.next()) {

//                String id = rs.getString(1);
                String id = rs.getString(2);
                BigDecimal income = rs.getBigDecimal(3);
                String pep = rs.getString(4);
                System.out.println("Id : " + id + "\t  Income. : " + income + "\t  pep: " + pep);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getGoodRecords() {
        ResultSet rs = null;
        // get record data from result set object
        try {
            rs = stmt.executeQuery("Select * from records order by pep desc");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    public void createTables() throws SQLException {
        String create_sql = "CREATE TABLE  if not exists  `records` (\n" +
                " `pid` INTEGER not NULL AUTO_INCREMENT,\n"+
                "  `id` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `income` decimal(20,2) DEFAULT NULL,\n" +
                "  `pep` char(3) COLLATE utf8mb4_unicode_ci DEFAULT NULL,\n" +
                "  PRIMARY KEY (`pid`)\n" +
                ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;";
        stmt.executeUpdate(create_sql);

    }

    public void inserts(List<Person> arr) throws SQLException {

        // create an insert statement
        String sql = "";

        System.out.println("Inserting records...");
        try {
            conn.setAutoCommit(false);
            sql = "Insert Into records(id,income,pep)  values(?,?,?)";
            // execute query for insert(s)
            PreparedStatement ps = conn.prepareStatement(sql);
            int i;
            for (i = 0; i < arr.size(); i++) {

                ps.setString(1, arr.get(i).getId());
                ps.setObject(2, arr.get(i).getIncome());
                ps.setObject(3, arr.get(i).getPep().name());
                ps.addBatch();
                if (i % 50 == 0) {
                    //2、执行batch
                    ps.executeBatch();
                    conn.commit();
                    //3、清空batch
                    ps.clearParameters();

                }
            }
            conn.commit();

            // System.out.println("Records inserted");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
        }
    }

}
