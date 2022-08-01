package YMSRecords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YMSRecords extends Client  {
	
	//static objects for IO processing
	static YMSRecords robjs[] = new YMSRecords[18]; //array of BankRecords objects
	static ArrayList<List<String>> array = new ArrayList<>();  //array list to hold spreadsheet rows & columns
	//instance fields
	private String id;
	private String rooms;
	private String days;
	protected double cume;
 
	public void readData() {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(new File("data.csv")));

			String line;
			while ((line = br.readLine()) != null) {
				array.add(Arrays.asList(line.split(",")));
				//System.out.println(line);
			}
		} catch (Exception e) {
			System.out.println("There was a problem loading the file");
		}
     processData();
	}

	public void processData() {
	     
		 	int idx=0;
		    //create loop to grab each array index containing a list of values
		    //and PASS that data into your record objects' setters 
		 
		    /*get room demand 
		    evaluate prob. based on fares*/
		  
		    for (List<String> rowData: array){
		      	//initialize array of objects
		    	robjs[idx] = new YMSRecords();
		    	//call setters below 
		    	robjs[idx].setId(rowData.get(0)); //get first column
		    	robjs[idx].setRooms(rowData.get(1)); //get second column
		    	robjs[idx].setDays(rowData.get(2)); 
		    	robjs[idx].setCume(Double.parseDouble(rowData.get(3))); 
		    	 
		         
		    idx++;
		    }
	    printData();
	}
 
	public void printData() {
		    //local vars set up for calcs
		    int book_limit;
		    double full_fare,discount_fare,optimal_pct;
		    String protection_limit = null;
		    double curCume, oldCume = 0;
			book_limit = 210;
			full_fare = 159.0;
			discount_fare = 105.0;
			
		    optimal_pct = (full_fare-discount_fare)/full_fare;
	 
		    //Set heading
		    System.out.println("Historic demand:\n\nID\t\tRooms\t\tDays\t\tCume");
		
		    //create for loop and grab each record objects' data onto the console
		    for (int i=0;i<18;i++){
						
		    	String s=String.format("%s\t\t%s\t\t%s\t\t%.2f", robjs[i].getId(),
					robjs[i].getRooms(),robjs[i].getDays(),robjs[i].getCume());
		    	System.out.println(s);
		    	
		    	//check point for protection level
		    	curCume = robjs[i].getCume();
		    	if (curCume>optimal_pct && optimal_pct > oldCume)  
		    		protection_limit=robjs[i].getRooms();
		    	 
			    oldCume=curCume; //swap
		}
         System.out.println("\nReserve (protection) limit to be set at: " + protection_limit);
	}
	//getters & setters
	 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public double getCume() {
		return cume;
	}

	public void setCume(double cume) {
		this.cume = cume;
	}

	public static void main(String[] args) {
	 
		YMSRecords ymsr = new YMSRecords();
		ymsr.readData();

	}


}