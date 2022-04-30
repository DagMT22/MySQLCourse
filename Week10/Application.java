package com.promineotech.world;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Application {
	
	static String connectionString = "jdbc:mysql://localhost:3306/week10";
	static String username = "root";
	static String password = "password";
	
	public static void printAll() {
		//Open Connection
		try {
			Connection connection = DriverManager.getConnection(connectionString, username, password);
//			System.out.println("MySQL connected at: " + connectionString);
			
			//Prepare SQL Statement
			String sql = "SELECT * FROM planes";
			Statement statement = connection.createStatement();
//			System.out.printf("SQL: %s%n", sql);
			
			// Execute / Open Reader
			ResultSet rs = statement.executeQuery(sql);
						
			System.out.println("Model                    || Manufacturer        || Year ||     Price     ||Cruise (kn)||Range(nm)||");
			System.out.println("===================================================================================================");
			// Iterate			
			while(rs.next()) {				
				System.out.printf("%-24s || %-20s|| %d ||$ %,13.2f||   %4d    ||  %,5d  ||%n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5),rs.getInt(6));
			}
			System.out.println("***************************************************************************************************");
			
			//Close Connection
			connection.close();
//			System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.printf("Database connection error: %s", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void printSearch(String model) {
		//Open Connection
		try {
			Connection connection = DriverManager.getConnection(connectionString, username, password);
//			System.out.println("MySQL connected at: " + connectionString);
			
			//Prepare SQL Statement
			String sql = "SELECT * FROM planes WHERE Model LIKE ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model+"%");
//			System.out.printf("SQL: %s%n", statement.toString());
			
			// Execute / Open Reader
			ResultSet rs = statement.executeQuery();
						
			System.out.println("Model                    || Manufacturer        || Year ||     Price     ||Cruise (kn)||Range(nm)||");
			System.out.println("===================================================================================================");
			// Iterate			
			while(rs.next()) {				
				System.out.printf("%-24s || %-20s|| %d ||$ %,13.2f||   %4d    ||  %,5d  ||%n",rs.getString(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5),rs.getInt(6));
			}
			System.out.println("***************************************************************************************************");
						
			//Close Connection
			connection.close();
//			System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.printf("Database connection error: %s", e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void addPlane(String model, String manufacturer, int year, double price, int cruise, int range) {
		//Open Connection
		try {
			Connection connection = DriverManager.getConnection(connectionString, username, password);
//			System.out.println("MySQL connected at: " + connectionString);
			
			//Prepare SQL Statement			
			String sql = "INSERT INTO planes VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, model);
			statement.setString(2, manufacturer);
			statement.setInt(3, year);
			statement.setDouble(4, price);
			statement.setInt(5, cruise);
			statement.setInt(6, range);				
//			System.out.printf("SQL: %s%n", statement.toString());
			
			// Execute / Open Reader
			int updates = statement.executeUpdate();
						
			
			// Iterate			
			System.out.println("Entries Added: " + updates);
						
			//Close Connection
			connection.close();
//			System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.printf("Database connection error: %s", e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void updateSome(String update, int column, String value) {
		//Open Connection
		try {
			Connection connection = DriverManager.getConnection(connectionString, username, password);
//			System.out.println("MySQL connected at: " + connectionString);
			
			//Prepare SQL Statement
			String sql = "";
			switch (column) {
				case 1: sql = "UPDATE planes SET Model=? WHERE model LIKE ?";
						break;
				case 2: sql = "UPDATE planes SET Manufacturer=? WHERE model LIKE ?";
						break;
				case 3: sql = "UPDATE planes SET Year=? WHERE model LIKE ?";
					break;
				case 4: sql = "UPDATE planes SET Price=? WHERE model LIKE ?";
					break;
				case 5: sql = "UPDATE planes SET Cruise_speed_kn=? WHERE model LIKE ?";
					break;
				case 6: sql = "UPDATE planes SET Flight_range_nmi=? WHERE model LIKE ?";
					break;
			}					
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//set Value type depending on which column was selected
			switch (column) {
				case 1: statement.setString(1, value);
						break;
				case 2: statement.setString(1, value);
						break;
				case 3: statement.setInt(1, Integer.parseInt(value));
						break;
				case 4: statement.setDouble(1, Double.parseDouble(value));
						break;
				case 5: statement.setInt(1, Integer.parseInt(value));
						break;
				case 6: statement.setInt(1, Integer.parseInt(value));
						break;
			}					
			statement.setString(2, update + "%");
//			System.out.printf("SQL: %s%n", statement.toString());
			
			// Execute / Open Reader
			int updates = statement.executeUpdate();
						
			
			// Iterate			
			System.out.println("Entries Updated: " + updates);
						
			//Close Connection
			connection.close();
//			System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.printf("Database connection error: %s", e.getMessage());
			e.printStackTrace();
		}
	}

	private static void deleteSome(String delete) {
		//Open Connection
		try {
			Connection connection = DriverManager.getConnection(connectionString, username, password);
//			System.out.println("MySQL connected at: " + connectionString);
			
			//Prepare SQL Statement
			String sql = "DELETE FROM planes WHERE Model LIKE ?";				
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, delete + "%");				
		
//			System.out.printf("SQL: %s%n", statement.toString());
			
			// Execute / Open Reader
			int updates = statement.executeUpdate();
						
			
			// Iterate			
			System.out.println("Entries Deleted: " + updates);
						
			//Close Connection
			connection.close();
//			System.out.println("Connection closed.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.printf("Database connection error: %s", e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);		
		int option;
		do {
			System.out.println("Pick an Option");
			System.out.println("[1] Print All");
			System.out.println("[2] Print Some");
			System.out.println("[3] Add One");
			System.out.println("[4] Update Some");
			System.out.println("[5] Delete Some");
			System.out.println("[0] Quit");
			option = input.nextInt();
			input.nextLine();//Use to clean up the /n that was left over after the nextInt()
			switch (option) {
				case 1: printAll();
						break;
				case 2: System.out.println("Enter a search String to look up the model(s)");
						String search = input.nextLine();
						printSearch(search);
						break;
				case 3: System.out.println("Model Name:");
						String model = input.nextLine();
						System.out.println("Manufacturer");
						String manufacturer = input.nextLine();
						System.out.println("Year:");						
						int year = input.nextInt(); 
						System.out.println("Price:");
						double price = input.nextDouble(); 
						System.out.println("Cruise Speed (kn):");
						int cruise = input.nextInt(); 
						System.out.println("Range (nm):");
						int range = input.nextInt(); 
						// Example: Air-Bike 103,JordanLakeAero,2022,6995.00,55,115
						addPlane(model, manufacturer, year, price, cruise, range);
						printSearch(model);
						break;
				case 4: System.out.println("Update Some - enter a search string to look up the model(s)");
						String update = input.nextLine();
						printSearch(update);
						int column;
						do {
						System.out.println("Enter Column # to update, or 0 to exit");
						column = input.nextInt(); input.nextLine();
						if (column < 1 || column > 6) {break;}
						System.out.println("Enter new value:");
						String value = input.nextLine();
						updateSome(update, column, value);
						printSearch(update);
						} while(column > 0 && column < 7);						
						break;
				case 5: System.out.println("Delete Some - enter a search string to look up the model(s)");
						String delete = input.nextLine();
						printSearch(delete);
						System.out.println("Type DELETE to confirm delete, else enter to return to main menu");
						String confirm = input.nextLine();
						if(confirm.equals("DELETE")) {
							deleteSome(delete);
						}
			}
		} while (option > 0);
		
		input.close();
		System.out.println("Have a good day!!");

	}

}
