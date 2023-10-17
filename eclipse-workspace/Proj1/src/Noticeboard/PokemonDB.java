package Noticeboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.Driver;

public class PokemonDB {
	 public static void main(String[] args) {
		    PreparedStatement insert = null;
		    PreparedStatement update = null;
		    Statement stmt = null;
		    Connection cnx = null;
		    ResultSet rs = null;
		    
		    String insertMoves = "INSERT INTO Moves(pokemonName,moveName) VALUES (?,?)";
		    String updateMoveName = "UPDATE Moves SET moveName=?";
		    
		    
		    try {
				cnx =  DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","Ameena","Ameena");
				insert = cnx.prepareStatement(insertMoves);
				update = cnx.prepareStatement(updateMoveName);
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter pokemon name: ");	
				String name = sc.nextLine();
				System.out.println("Enter move name");
				String move = sc.nextLine();
				
				insert.setString(1, name);
				insert.setString(2, move);
				insert.executeUpdate();
				
				stmt = cnx.createStatement();
				rs = stmt.executeQuery("SELECT * FROM MovesPower mp ");
				
				System.out.println("moveName, pokPrimaryType");
				while(rs.next()) {
					String moveName = rs.getString("mp.moveName");
					//int power = rs.getInt("mp.power");
					String pokPrimaryType = rs.getString("mp.pokPrimaryType");
					System.out.println(moveName + "," + pokPrimaryType);
				}
				
			} catch(SQLException e) {
				
				e.printStackTrace();
			}
	 }
}
