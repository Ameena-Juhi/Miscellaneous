package projectGUI;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class confettiParticles extends Rectangle{
	
	public confettiParticles(double x, double y, double size, Color color) {
		super(x,y,size,size);
		this.setFill(color);
	}
	
	
}