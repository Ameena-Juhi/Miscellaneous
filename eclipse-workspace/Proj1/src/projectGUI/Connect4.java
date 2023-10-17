package projectGUI;

import javafx.animation.*;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;
import javafx.stage.Stage;

public class Connect4 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Hello!");
		Circle circle = new Circle();
		circle.setCenterX(100.0f);
		circle.setCenterY(100.0f);
		circle.setRadius(10.0f);
		circle.setFill(Color.BLUE);
		circle.setStroke(Color.BROWN);
		Path path = new Path();
		path.getElements().add(new MoveTo(90.0f, 90.0f));
		path.getElements().add(new LineTo (90.0f, 180.0f));
		//path.getElements().add(new CubicCurveTo ());
		PathTransition pathTransition = new PathTransition();
		pathTransition.setDuration(Duration.millis(1000));
		pathTransition.setNode(circle);
		pathTransition.setPath(path);
		pathTransition.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
		
		pathTransition.setCycleCount(1);
		pathTransition.play();
		
		Button btn = new Button();
		btn.setText("Animate!");
		btn.setOnAction(event -> pathTransition.play());
		
		
		Group root = new Group();
		root.getChildren().addAll(circle,btn);
		primaryStage.setScene(new Scene(root, 700, 350, Color.AZURE));
		primaryStage.show();
		
}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}


