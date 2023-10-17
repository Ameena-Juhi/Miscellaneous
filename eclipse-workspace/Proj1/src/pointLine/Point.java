package pointLine;

public class Point {
	public double x;
	public double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;	
		
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public static double distanceFrom(Point p1, Point p2) {
		double distance = Math.hypot((p2.getX() - p1.getX()), (p2.getY() - p1.getY()));
		return distance;
	}
	
	@Override
	public String toString() {
		return ("[" + Double.toString(x) + "," + Double.toString(y)+ "]");
		
	}
	

}
