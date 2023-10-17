package com.prodapt.learningspring;

public class Student {
	
	private String name;
	private int score;
	private int id;
	
	private static int idCounter = 1;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
		this.id = idCounter++;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getScore(int score) {
		return score;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return String.format("%s %d", name, score);
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other == this)
			return true;
		if (other.getClass() != getClass())
			return false;
		Student otherStudent = (Student) other;
		return otherStudent.id == this.id;
	}

}
