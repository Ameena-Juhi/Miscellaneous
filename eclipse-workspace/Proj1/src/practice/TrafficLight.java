package practice;

public class TrafficLight {
	
	public String color;
	public int duration;
	
	public TrafficLight(String color, int duration) {
		this.color = color;
		this.duration = duration;
	}
	
	public void changeColor(String newColor) {
		color = newColor;
	}
	
	public boolean isRed() {
		return(color.equals("Red"));
	}
	
	public boolean isGreen() {
		return(color.equals("Green"));
	}
	
	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int newDuration) {
		this.duration = newDuration;
	}
	
	public static void main(String[] args) {
		TrafficLight TF = new TrafficLight("Red",30);
		System.out.println(TF.isRed());
		System.out.println(TF.isGreen());
		System.out.println(TF.getDuration());
		TF.changeColor("Green");
		TF.setDuration(50);
		System.out.println(TF.isGreen());
		System.out.println(TF.getDuration());
	}
}
