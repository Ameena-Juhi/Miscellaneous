package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Servlet implementation class ValidatePassword
 */
public class ValidatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String password = request.getParameter("pwd");
		 out.println("<h1>Submitted password: </h1>" + password);

//		    try {
//		        Path filePath = Paths.get("/home/ameenajuhi/eclipse-workspace/webLearning/src");
//		        
//		        if (!Files.exists(filePath)) {
//		            Files.createFile(filePath);
//		            out.println("<p>File created: " + filePath.toString() + "</p>");
//		            return;
//		        }
//		        
		        List<String> passwords = Files.lines(Path.of("/home/ameenajuhi/eclipse-workspace/webLearning/src/passwords.txt")).toList();
		        
		        if (passwords.contains(password)) {
		            out.println("<p><h1>Password is invalid.</h1></p>");
		        } else {
		            out.println("<p><h1>Success!</h1></p>");
		        }
//		    } catch (IOException e) {
//		        out.println("<p>Error reading or creating password file: " + e.getMessage() + "</p>");
//		    }
		}
	




		





	}


