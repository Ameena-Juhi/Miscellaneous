package projectGUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ScrollToCenter extends Application {

  private ScrollPane scrollPane;
  private GridPane gridPane;
  private double dimensionX;
  private double dimensionY;

  @Override
  public void start(Stage primaryStage) {
    scrollPane = new ScrollPane();
    gridPane   = new GridPane();
    dimensionX = 20;
    dimensionY = 20;

    for(int x = 0; x < dimensionX; ++x){
      for(int y = 0; y < dimensionY; ++y){
        Pane temp = new Pane();
        temp.setPrefSize(10,10);
        temp.setOnMouseClicked( e -> {
          centerViewOn(GridPane.getColumnIndex(temp), GridPane.getRowIndex(temp));
          temp.setStyle("-fx-background-color: blue");
        });
        gridPane.add(temp, x, y);
      }
    }

    gridPane.setGridLinesVisible(true);
    scrollPane.setContent(gridPane);

    primaryStage.setScene(new Scene(scrollPane));
    primaryStage.show();
  }

  private void centerViewOn(double x, double y){
    double viewportWidth    = scrollPane.getViewportBounds().getWidth();
    double maxHscrollPixels = gridPane.getWidth() - viewportWidth;
    double hscrollPixels    =  (x + 0.5) * gridPane.getWidth() / dimensionX - viewportWidth / 2;
    scrollPane.setHvalue(hscrollPixels / maxHscrollPixels);

    double viewportHeight   = scrollPane.getViewportBounds().getHeight();
    double maxVscrollPixels = gridPane.getHeight() - viewportHeight;
    double vscrollPixels    =  (y + 0.5) * gridPane.getHeight() / dimensionY - viewportHeight / 2;
    scrollPane.setVvalue(vscrollPixels / maxVscrollPixels);
  }

  public static void main(String[] args) {
    launch(args);
  }
}







//import javafx.animation.TranslateTransition;
//import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.scene.Scene;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Circle;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//
//public class Test extends Application {
//    private Circle circle;
//    private TranslateTransition transition;
//
//    @Override
//    public void start(Stage stage) throws Exception {
//
//        /**
//         * MShape
//         */
//        circle = new Circle(20);
//        circle.setCenterX(10);
//        circle.setCenterY(10);
//        circle.setFill(Color.RED);
//
//
//        transition = new TranslateTransition();
//        //transition.setToX(0);
//        transition.setToY(300);
//
//        transition.setDuration(Duration.seconds(5));
//        transition.setNode(this.circle);
//
////      this.getChildren().add(circle);
//
//        circle.setOnMouseClicked((EventHandler<? super MouseEvent>) new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent paramT) {
//                transition.play();
//                System.out.println("hello  " + circle.getCenterX() + "  " + circle.getCenterY());
//
//            }
//            
//        }
//        );
//
//        VBox root = new VBox();
//        Scene scene = new Scene(root, 800, 600);
//        stage.setScene(scene);
//
//        root.getChildren().add(circle);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}