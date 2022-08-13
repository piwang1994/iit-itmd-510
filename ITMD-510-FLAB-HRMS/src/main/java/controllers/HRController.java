package controllers;

import Dao.DBConnect;
import application.DynamicTable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class HRController {
    @FXML
    public  Pane pane0;


    @FXML
	private Pane pane1;
    @FXML
    private TextField cName;
    @FXML
    private TextField jName;
    @FXML
    private TextField appResult;

	@FXML
	private Pane pane2;
    @FXML
    private TextField job_name;
    @FXML
    private TextField job_desc;
    @FXML
    private TextField company;
    @FXML
    public TextField job_id;


	@FXML
	private Pane pane3;
	@FXML
	private TextField del_jid;

	// Declare DB objects
	DBConnect conn;
	Statement stmt = null;

	public HRController() {
		conn = new DBConnect();
	}

    public void viewJobs() {

        DynamicTable d = new DynamicTable();
        // call method from DynamicTable class and pass some arbitrary query string
        d.buildData("Select * from job ");

    }


	public void viewApp() {

		DynamicTable d = new DynamicTable();
		// call method from DynamicTable class and pass some arbitrary query string
		d.buildData("Select name,job_name,result from candidate c join apply a on c.cid=a.cid join job j on  a.job_id=j.job_id ");

	}

	public void updateApp() {
        pane1.setVisible(true);
        pane2.setVisible(false);
		pane3.setVisible(false);



	}

	public void addJob() {

		pane1.setVisible(false);
		pane2.setVisible(true);
		pane3.setVisible(false);
	}

    public void deleteJob() {

        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(true);

    }



	public void submitUpdateApp() {
        System.out.println("Update Submit button pressed");
        // INSERT INTO BANK TABLE
        try {
            stmt = conn.getConnection().createStatement();
            String sql;
            sql ="update apply INNER JOIN candidate on apply.cid=candidate.cid\n" +
                    "INNER JOIN job on apply.job_id=job.job_id\n"                 +
                    "SET apply.result='"+appResult.getText()+"'"                  +
                    "WHERE candidate.`name`='"+cName.getText()+"'"                +
                    "and job.job_name='"+jName.getText()+"'";
            stmt.executeUpdate(sql);
            System.out.println("Bank Record created");

//            conn.getConnection().close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
    }

    public void submitAddJob()  {

        String sql ="insert into job(job_id,job_name,job_desc,company) values(?,?,?,?)";
        // INSERT INTO BANK TABLE
        try(PreparedStatement stmt = conn.getConnection().prepareStatement(sql)){
            // Execute a query
            System.out.println("Inserting records into the table...");
            stmt.setString(1, job_id.getText());
            stmt.setString(2, job_name.getText());
            stmt.setString(3, job_desc.getText());
            stmt.setString(4, company.getText());
            stmt.executeUpdate();
//            conn.getConnection().close();
        } catch (SQLException se) {
            se.printStackTrace();
//            System.out.println("sql eee");
        }
    }

	public void SubmitDelJob() {

		System.out.println("Delete delete button pressed");
        String job_sql ="delete from job  where job_id=?";
        // INSERT INTO BANK TABLE
        try(PreparedStatement stmt = conn.getConnection().prepareStatement(job_sql)){
            // Execute a query
            System.out.println("Delete records from the table...");
            stmt.setString(1, del_jid.getText());
            stmt.executeUpdate();
//            conn.getConnection().close();
        } catch (SQLException se) {
            se.printStackTrace();
//            System.out.println("sql eee");
        }
        String app_sql ="update  apply  set result='fail' where job_id=?";
        try(PreparedStatement stmt = conn.getConnection().prepareStatement(app_sql)){
            System.out.println("update records from the table...");
            stmt.setString(1, del_jid.getText());
            stmt.executeUpdate();
//            conn.getConnection().close();
        } catch (SQLException se) {
            se.printStackTrace();
//            System.out.println("sql eee");
        }
	}

}
