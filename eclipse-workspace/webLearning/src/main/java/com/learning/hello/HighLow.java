package com.learning.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import com.learning.hello.controller.HiLoController;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HighLow")
public class HighLow extends HttpServlet {

	private static final long serialVersionUID = 5579543055518933545L;
	
	public int guess;
	public int correct;
	private JakartaServletWebApplication application;
	private TemplateEngine templateEngine;
	
	
	public void setGuess(int Guess) {
		this.guess = Guess;
	}
	
	public void reset() {
		this.correct = new Random().nextInt(0,100);
		}
	
	public int validate() {
		return Integer.compare(guess, correct);
	}
	
	public String result() {
		return validate() == 0 ? "correct!": validate() == -1 ? "Guess Higher" : "Guess Lower";
	}
	 @Override
	  public void init(ServletConfig config) throws ServletException {
	    super.init(config);
	    reset();
	    application = JakartaServletWebApplication.buildApplication(getServletContext());
	    final WebApplicationTemplateResolver templateResolver = 
	        new WebApplicationTemplateResolver(application);
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setPrefix("/WEB-INF/templates/");
	    templateResolver.setSuffix(".html");
	    templateEngine = new TemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	  }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		this.setGuess(Integer.parseInt(request.getParameter("inputNum")));
	    var out = response.getWriter();
	    final IWebExchange webExchange = 
	        this.application.buildExchange(request, response);
	    final WebContext ctx = new WebContext(webExchange);
	    ctx.setVariable("feedback", this.result());
	    templateEngine.process("HighLowForm", ctx, out);
	    if(validate()==0)
	    	reset();
	}
		
	@Override
	  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    final IWebExchange webExchange = this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    templateEngine.process("HighLowForm", ctx, resp.getWriter());
	  }
}
