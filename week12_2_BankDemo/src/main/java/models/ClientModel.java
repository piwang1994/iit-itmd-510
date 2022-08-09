package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import Dao.DBConnect;

public class ClientModel extends DBConnect implements User<Bank>{

	private int cid;
	private int tid;
	private double balance;

	// Declare DB objects
	DBConnect conn = null;
	Statement stmt = null;
	
	Bank custBank; //set up Bank object

	public ClientModel() {

		conn = new DBConnect();
		
		//simulate bank data affiliation of client
		custBank = new Bank();
		custBank.setBankId(100);
		custBank.setBankName("Bank of IIT");
		custBank.setBankAddress("10 W 35th St, Chicago, IL 60616");
	}
 
	/* getters & setters */
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getTid() {
		return tid;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	// INSERT INTO METHOD
	public void insertRecord(int cid, double bal) {

		try {
			setCid(cid);
			// Execute a query
			System.out.println("Inserting record into the table...");
			stmt = conn.getConnection().createStatement();
			String sql = null;

			// Include data to the database table

			sql = " insert into jpapa_accounts(cid, balance) values('" + cid + "', '" + bal + "')";

			stmt.executeUpdate(sql);
			conn.getConnection().close();

			System.out.println("Balance inserted $" + bal + " for ClientID " + cid);

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public List<ClientModel> getAccounts(int cid) {
		List<ClientModel> accounts = new ArrayList<>();
		String query = "SELECT tid,balance FROM jpapa_accounts WHERE cid = ?;";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, cid);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				ClientModel account = new ClientModel();
				// grab record data by table field name into ClientModel account object
				account.setTid(resultSet.getInt("tid"));
				account.setBalance(resultSet.getDouble("balance"));
				accounts.add(account); // add account data to arraylist
			}
		} catch (SQLException e) {
			System.out.println("Error fetching Accounts: " + e);
		}
		return accounts; // return arraylist
	}

	@Override
	public Bank getClientInfo() {
		// TODO Auto-generated method stub
		return custBank;
	}
}