package projectGUI;

import javafx.scene.paint.Color;
import java.util.Random;


public class confetti {
	
	public static final Random random = new Random();
	
	public static Color getcolor() {
		return Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
	}
}
