package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Servlet implementation class Fibonacci
 */
public class Fibonacci extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.getWriter().append("Served at: ").append(req.getContextPath());
		try {
		      Map<String, String[]> parameterMap = req.getParameterMap();
		      parameterMap.entrySet().stream().forEach(entry -> {
		        System.out.print("key: " + entry.getKey());
		        System.out.print(" values: " + Arrays.toString(entry.getValue()) + "\n");
		      });
		      PrintWriter out = resp.getWriter();
		      //String userName = parameterMap.get("n")[0];
		      int n = Integer.valueOf(parameterMap.get("n")[0]);
		      out.println(n);
		      out.println(fibonacci(n));
		      //out.println(String.format("<h1>Hello, %s!</h1>", userName));
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		  
	}
	public int fibonacci(int n) {
		int f[] = new int[n+2];
		if (n<=1)
			return n;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  PrintWriter out = response.getWriter();

		      int limit = Integer.valueOf(request.getParameter("formLimit"));
		      out.println(fibonacci(limit));
		    
		  }
	

}
