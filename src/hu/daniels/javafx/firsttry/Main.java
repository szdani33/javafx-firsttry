package hu.daniels.javafx.firsttry;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 450);

        Point2D center = calcWindowCenter(scene);
        Hexagon hexagon = new Hexagon(110, center, true);
        hexagon.setFill(Color.CORAL);
        Hexagon hexagon2 = new Hexagon(70, new Point2D(200, 350), true);
        hexagon2.setFill(Color.DARKSEAGREEN);
        Hexagon hexagon3 = new Hexagon(20, new Point2D(700, 400), false);
        hexagon3.setFill(Color.GOLD);
        Hexagon hexagon4 = new Hexagon(50, new Point2D(700, 200), true);
        hexagon4.setFill(Color.LIGHTSKYBLUE);
        Hexagon hexagon5 = new Hexagon(20, new Point2D(30, 100), false);
        hexagon5.setFill(Color.DARKBLUE);
        List<Hexagon> hexagons = Arrays.asList(hexagon, hexagon2, hexagon3, hexagon4, hexagon5);

        root.getChildren().addAll(hexagons);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("Pulsing Hexagons");
        primaryStage.setScene(scene);
        primaryStage.show();

        pulseHexagon(hexagons);
    }

    private void pulseHexagon(final List<Hexagon> hexagons) {
        new AnimationTimer() {
            HexagonTransformer ht = new HexagonTransformer();
            int counter = 0;

            @Override
            public void handle(long now) {
                for (Hexagon hex : hexagons) {
                    pulse(hex);
                }
                counter += 5;
            }

            private void pulse(Hexagon hexagon) {
                double sizeDiff = hexagon.getSize() / 3 * Math.sin(counter * Math.PI / 180);
                ht.changeSize(hexagon, sizeDiff);
            }
        }.start();

    }

    private Point2D calcWindowCenter(Scene scene) {
        return new Point2D(scene.getWidth() / 2, scene.getHeight() / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
