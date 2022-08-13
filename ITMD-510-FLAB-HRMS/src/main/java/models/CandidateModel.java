package models;

import Dao.DBConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CandidateModel extends DBConnect {

	private String cid;
	private String name;
	private String job_name;

    private String Result;



	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;
	

	public CandidateModel() {
		conn = new DBConnect();
	}
 
	/* getters & setters */
	
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getJob_name() {
        return job_name;
    }

    public void setJob_name(String job_name) {
        this.job_name = job_name;
    }

    // INSERT INTO METHOD
	public void insertRecord(String cid, String job_id) {

		try {
			setCid(cid);
			// Execute a query
			System.out.println("Inserting record into the apply...");
			stmt = conn.getConnection().createStatement();
			String sql = null;

			// Include data to the database table

			sql = " insert into apply(cid,result, job_id) values('" + cid + "','waiting' ,'" + job_id + "')";

			stmt.executeUpdate(sql);
			conn.getConnection().close();

			System.out.println(" inserted " + cid + " apply for  " + job_id);

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public List<CandidateModel> getAppList(String cid) {
		List<CandidateModel> candidateModels = new ArrayList<>();
		String query = "Select a.cid,name,job_name,result from candidate c join apply a on c.cid=a.cid join job j on  a.job_id=j.job_id  WHERE c.cid = ?;";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, cid);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CandidateModel candiate = new CandidateModel();
				// grab record data by table field name into CandidateModel  object
                candiate.setCid(resultSet.getString("cid"));
                candiate.setName(resultSet.getString("name"));
                candiate.setResult(resultSet.getString("result"));
                candiate.setJob_name(resultSet.getString("job_name"));
                candidateModels.add(candiate);
			}
		} catch (SQLException e) {
			System.out.println("Error fetching job app info: " + e);
		}
		return candidateModels; // return arraylist
	}

}