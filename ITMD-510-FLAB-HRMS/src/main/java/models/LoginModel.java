package models;

import Dao.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel extends DBConnect {

    private Boolean hr;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isHr() {
        return hr;
    }

    public void setHr(Boolean hr) {
        this.hr = hr;
    }

    public Boolean getCredentials(String username, String password) {

        String query1 = "SELECT hr_id as id FROM hr WHERE hr_name = ? and password = ?;";
        String query2 = "SELECT cid as id FROM candidate WHERE name  = ? and password = ?;";
        try {
            PreparedStatement stmt1 = connection.prepareStatement(query1);
            stmt1.setString(1, username);
            stmt1.setString(2, password);
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                System.out.println("hr");
                setId(rs.getString("id"));
                setHr(true);
                return true;
            }

            PreparedStatement stmt2 = connection.prepareStatement(query2);
            stmt2.setString(1, username);
            stmt2.setString(2, password);
            rs = stmt2.executeQuery();
            if (rs.next()) {
                System.out.println("candidate");
                setId(rs.getString("id"));
                setHr(false);
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}//end class