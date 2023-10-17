package projectGUI;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class confettiTesting extends Application{
	
	private static final int Window_width = 1000;
	private static final int Window_height = 600;
	private static final int Particle_size = 10;
	private static final int Particle_count = 150;
	private static final int Particle_speed = 3;
	
	@Override
	public void start(Stage stage){
		// TODO Auto-generated method stub
		Pane root = new Pane();
		Scene scene = new Scene(root, Window_width, Window_height);
		stage.setTitle("CONFETTI");
		stage.setScene(scene);
		stage.show();
		
		for (int i=0 ; i < 	Particle_count ; i++) {
			double x = Math.random() * Window_width;
			double y = Math.random() * Window_height;
			Color color = confetti.getcolor();
			confettiParticles particle = new confettiParticles(x, y, Particle_size, color);
			root.getChildren().add(particle);
			
		}
		
		AnimationTimer animationtimer = new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				for (int i=0; i< root.getChildren().size(); i++) {
					confettiParticles particle = (confettiParticles) root.getChildren().get(i);
					particle.setY(particle.getY() + Particle_speed);
					if (particle.getY() > Window_height) {
						particle.setY(0);
						particle.setX(Math.random()*Window_width);
					}
					
				}
				
			}
		};
		
		animationtimer.start();
		
	}
	
	public static void main(String[] args ) {
		launch(args);
	}

}
