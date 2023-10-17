package pointLine;
import java.util.Optional;

public class Line {
	public double slope;
	public double yIntercept;
	
	public Line(double slope, double yIntercept ) {
		this.slope = slope;
		this.yIntercept = yIntercept;
	}
	
	public double getSlope() {
		return slope;
	}
	
	public double getyIntercept() {
		return yIntercept;
	}
	
	public double evaluateY(double x) {
	        return slope * x + yIntercept;
	    }
	
	public Optional<Point> intersection(Line l1){
		double m1 = this.slope; 
		double m2 = l1.getSlope();
		double b1 = this.yIntercept;
		double b2 = l1.getyIntercept();
		
		if (m1 == m2)
			return Optional.empty();
		
		double x = (b2 - b1)/(m1 - m2);
		double y = m1 * x + b1;
		Point point = new Point(x,y);
		return Optional .of(point);
		
	}
	
	public static double distanceFromOrg(Point p1) {
		Point p = new Point(0,0);
		return Point.distanceFrom(p,p1);
	}

	 @Override
	 public String toString() {
	        return "y = " + slope +"x + " + yIntercept;
	    }
	

}
