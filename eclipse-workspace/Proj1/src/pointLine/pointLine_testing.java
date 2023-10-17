package pointLine;
import java.util.*;
public class pointLine_testing {
	public static void main(String [] args){
		Point p = new Point(2.5,3.1);
		Point p1 = new Point(3.6,2.4);
		Line l = new Line(1,5);
		Line l2 = new Line(1,5);
		System.out.println(p.getX());
		System.out.println(p.getY());
		System.out.println(p);
		System.out.println(Point.distanceFrom(p,p1));
		System.out.println(l);
		System.out.println(l.evaluateY(3.4));
		Optional<Point> p2 = l.intersection(l2);
		if (p2.isEmpty())
			System.out.println("Hey, Lines are parallel");
		else
			System.out.print(p2);
		System.out.println(Line.distanceFromOrg(p));
	}
}
