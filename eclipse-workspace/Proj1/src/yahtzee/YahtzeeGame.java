package yahtzee;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;

public class YahtzeeGame{
	PreparedStatement insert = null;
	Statement stmt = null;
	Connection cnx = null;
	
	
	public static void addData() {
		try {
			Connection cnx =  DriverManager.getConnection("jdbc:mysql://localhost:3306/Yahtzee","Ameena","Ameena");
			String query = "UPDATE SCOREBOARD SET ? = ? WHERE GameID = 1;";
			PreparedStatement insert = cnx.prepareStatement(query);
			
//			Scanner sc = new Scanner(System.in);
//			System.out.println("Enter the player name: ");
//			String name = sc.nextLine();
//			System.out.println("Enter the category: ");
//			int categ = sc.nextInt();
//			System.out.println("Enter the player ID: ");
//			int ID = sc.nextInt();
			
			insert.setString(1, "Aces");
			insert.setInt(2, 3);
			insert.executeUpdate();
			System.out.println("Successful");
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		addData();
//		Yahtzee y = new Yahtzee();
//		System.out.println(y.getdieRoll());
//		switch (x) {
//		case 1: {
//			 System.out.println(y.upperSecScore(1)); 
//		}
//		case 2: {
//			 System.out.println( y.upperSecScore(2));
//		}
//		
//		case 3: {
//			 System.out.println(y.upperSecScore(3)); 
//		}
//		case 4: {
//			 System.out.println(y.upperSecScore(4)); 
//		}
//		case 5: {
//			System.out.println(y.upperSecScore(5) );
//		}
//		case 6: {
//			 System.out.println(y.upperSecScore(6)); 
//		}
//		
//		default:
//			throw new IllegalArgumentException("Unexpected value: " + x);
		}
	}
//}