package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Lorry extends Application {
    public static void main (String args[]) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene (root, 1024, 500);

        //ковш
        Rectangle rect = new Rectangle(200, 30, 100, 200);
        rect.setFill(Color.color(0,0,0.6, 0.9));
        Rotate rotate = new Rotate();
        rotate.setPivotX(rect.getX());
        rotate.setPivotY(rect.getY());
        rotate.setAngle(60);
        rect.getTransforms().add(rotate);
        root.getChildren().add(rect);

        //кузов
        rect = new Rectangle(100, 150, 200, 100);
        rect.setFill(Color.color(0.9, 0.9, 0, 1));
        rect.setStroke(Color.BLACK);
        rect.setStrokeType(StrokeType.OUTSIDE);
        root.getChildren().add(rect);

        //вихлопна труба
        Arc arc = new Arc();
        arc.setFill(Color.DARKBLUE);
        arc.setType(ArcType.OPEN);
        arc.setCenterX(100.0f);
        arc.setCenterY(230.0f);
        arc.setRadiusX(15.0f);
        arc.setRadiusY(10.0f);
        arc.setStartAngle(90.0f);
        arc.setLength(180.0f);
        root.getChildren().add(arc);

        //мигалка
        Circle circle = new Circle(415,100,10);
        circle.setFill(Color.DARKBLUE);
        root.getChildren().add(circle);

        //кабіна
        Polygon polygon = new Polygon(300.0, 50.0,
                300.0, 250.0,
                430.0, 250.0,
                430.0, 150.0,
                400.0, 50.0);
        polygon.setFill(Color.color(0.9, 0.9, 0, 1));
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeType(StrokeType.OUTSIDE);
        root.getChildren().add(polygon);

        //вікно
        polygon = new Polygon(310.0, 60.0,
                310.0, 150.0,
                420.0, 150.0,
                390.0, 60.0);
        polygon.setFill(Color.color(0, 0.2, 0.6, 1));
        polygon.setStroke(Color.BLACK);
        polygon.setStrokeType(StrokeType.OUTSIDE);
        root.getChildren().add(polygon);

        //колеса
        circle = new Circle(150,250,45);
        root.getChildren().add(circle);
        circle = new Circle(370,250,45);
        root.getChildren().add(circle);
        circle = new Circle(150,250,10);
        root.getChildren().add(circle);
        circle.setFill(Color.YELLOW);
        circle = new Circle(370,250,10);
        root.getChildren().add(circle);
        circle.setFill(Color.YELLOW);

        //ручка
        Ellipse ellipse = new Ellipse(320,160,15, 5);
        ellipse.setFill(Color.YELLOW);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeType(StrokeType.OUTSIDE);
        root.getChildren().add(ellipse);

        // Animation
        int cycleCount = 2;
        int time = 2000;

        ScaleTransition s1 = new ScaleTransition(Duration.millis(time), root);
        s1.setToX(0.5);
        s1.setToY(0.5);

        ScaleTransition s2 = new ScaleTransition(Duration.millis(time), root);
        s2.setToX(1);
        s2.setToY(1);

        RotateTransition r1 = new RotateTransition(Duration.millis(time), root);
        r1.setByAngle(180);

        RotateTransition r2 = new RotateTransition(Duration.millis(time), root);
        r2.setByAngle(180);

        TranslateTransition ptr1 = new TranslateTransition(Duration.millis(time), root);
        ptr1.setFromY(0);
        ptr1.setToY(250);

        TranslateTransition ptr2 = new TranslateTransition(Duration.millis(time), root);
        ptr2.setFromY(250);
        ptr2.setToY(0);

        TranslateTransition t1 = new TranslateTransition(Duration.millis(time), root);
        t1.setFromX(300);
        t1.setToX(50);

        TranslateTransition t2 = new TranslateTransition(Duration.millis(time), root);
        t2.setFromX(50);
        t2.setToX(300);

        ParallelTransition tr1 = new ParallelTransition(r1, s1, ptr1);

        ParallelTransition tr2 = new ParallelTransition(r2, s2, ptr2);

        SequentialTransition wrap = new SequentialTransition();
        wrap.getChildren().addAll( t2, tr1, t1, tr2 );
        wrap.setCycleCount(Timeline.INDEFINITE);
        wrap.play();
        // End of animation

        primaryStage.setTitle("Lorry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}