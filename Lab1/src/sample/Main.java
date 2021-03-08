package sample;

import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.shape.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root, 400, 250);
        scene.setFill(Color.rgb(15, 127, 18));

        Line leftEye = new Line(64, 20, 120, 20);
        root.getChildren().add(leftEye);
        leftEye.setStroke(Color.BLUE);
        leftEye.setStrokeWidth(7.0);

        Line rightEye = new Line(233, 20, 302, 20);
        root.getChildren().add(rightEye);
        rightEye.setStroke(Color.BLUE);
        rightEye.setStrokeWidth(7.0);

        Polygon nose = new Polygon(180, 20, 113, 173, 280, 173);
        root.getChildren().add(nose);
        nose.setFill(Color.rgb(255, 253, 56));

        Polyline mice = new Polyline(new double[]{
                20.0, 20.0, 84.0, 222.0, 313.0, 222.0, 370.0, 19.0
        });
        root.getChildren().add(mice);
        mice.setStroke(Color.RED);
        mice.setStrokeWidth(7.0);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
