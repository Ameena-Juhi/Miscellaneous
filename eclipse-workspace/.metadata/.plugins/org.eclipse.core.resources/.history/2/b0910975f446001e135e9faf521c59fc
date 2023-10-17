package com.prodapt.learningspring.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

@Component
public class StudentDB {
	
public void addStudent(Student student) {
	
	try(Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/persistence","Ameena","Ameena")) {

	PreparedStatement insert = null;
	
	String insertstudent = "INSERT INTO StudentList(Ranks,Name,Score) VALUES (?,?,?)";
	insert = cnx.prepareStatement(insertstudent);

		insert.setInt(1, student.getRank() );
		insert.setString(2, student.getName());
		insert.setInt(3, student.getScore() );
		insert.executeUpdate();
	}
	catch (SQLException e) {
	      e.printStackTrace();
	    }
	}


}
