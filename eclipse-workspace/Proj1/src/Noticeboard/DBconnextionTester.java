package Noticeboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

			
public class DBconnextionTester {
	static	PreparedStatement insert = null;
	static	PreparedStatement update = null;
	static Statement  stmt = null;
	static Connection cnx = null;
	static ResultSet rs= null;
	static String insertPosts = "INSERT INTO Posts(PostID,UserID, Title) values (?,?,?));";
	static String updateUserID = "UPDATE UserIDs SET UserID=? ;";
	
		public static void addCommentWithInput() {
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter the postID: ");
				int postid = sc.nextInt();
				System.out.println("Enter the userId: ");
				int userid = sc.nextInt();
				System.out.println("Enter the Comment: ");
				String title = sc.nextLine();
				
		try (Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/NEWDB","Ameena","Ameena")){
			
			String sql = "INSERT INTO Comments(PostID,UserID,Comment) values (?,?,?)";
			try(PreparedStatement insert = cnx.prepareStatement(sql)) {
				insert.setInt(1, postid);
				insert.setInt(2, userid);
				insert.setString(3,title);
				insert.executeUpdate();
				System.out.println("Successful");
			}
		}
			
			catch(SQLException e) {
				e.printStackTrace();
			}
			}
			}
	
		public static void main(String[] args) {
			try {
				cnx =  DriverManager.getConnection("jdbc:mysql://localhost:3306/NEWDB","Ameena","Ameena");
				
				Statement stmt = cnx.createStatement();
				insert = cnx.prepareStatement(insertPosts);
				System.out.println(insert.getClass());
				update = cnx.prepareStatement(updateUserID);			
				rs = stmt.executeQuery("SELECT * FROM Posts p ");
				System.out.println("PostID, UserID,Title");
				while(rs.next()) {
					int PostID = rs.getInt("p.PostID");
					int UserID = rs.getInt("p.UserID");
					String Title = rs.getString("p.Title");
					
					System.out.println(PostID +"," + UserID+","+ Title);
				}
				
			} catch(SQLException e) {
				
				e.printStackTrace();
			}
			addCommentWithInput();
		}

}


	
			
			
	
//		finally {
//			if (rs != null) {
//		        try {
//		          rs.close();
//		        } catch (SQLException sqlEx) { } // ignore
//
//		        rs = null;
//		      }
//
//		      if (stmt != null) {
//		        try {
//		          stmt.close();
//		        } catch (SQLException sqlEx) { } // ignore
//		      }
//		      
//		      if (cnx != null) {
//	        try {
//	          cnx.close();
//	        } catch (SQLException sqlEx) { } //ignore	      }
//		
//		}
//}