package com.prodapt.learningspring;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	List<Student> students = new ArrayList<>();
	
	String message = "";

    @GetMapping
    public String studentForm(Model model) {
    	model.addAttribute("message", message);
    	model.addAttribute("students", students);
        return "StudentForm";
    }

    // Add POST mapping for processing form submission here
    @PostMapping
    public void processStudentForm(String name, String score, HttpServletResponse resp) throws IOException{
    	message = String.format("I am currently processing student with %s %s", name, score);
    	int scoreAsInt = Integer.valueOf(score);
    	var student = new Student(name, scoreAsInt);
    	students.add(student);
    	resp.sendRedirect("/student");
    }
    
    @PostMapping("/delete")
    public void deleteStudent(int id, HttpServletResponse resp) throws IOException {
    	Optional<Student> toEdit = students.stream().filter(student -> student.getId() == id).findFirst();
    	if (!toEdit.isEmpty()) {
    		students.remove(toEdit.get());
    		message = "successfully deleted";
    	}
    	resp.sendRedirect("/student");
    }
}
