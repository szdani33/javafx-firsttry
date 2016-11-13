package hu.daniels.javafx.firsttry;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Dani on 2016.11.12..
 */
public class HexagonTransformer {

    public void changeSize(Hexagon hexagon, double sizeDiff) {
        hexagon.getPoints().setAll(calcHexagonCorners(hexagon.getCenter(), hexagon.getSize() + sizeDiff, hexagon.isFlatTop()));
    }

    private Collection<Double> calcHexagonCorners(Point2D center, double size, boolean flatTop) {
        ArrayList<Double> coordinates = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            int degree = 60 * i + (flatTop ? 30 : 0);
            double rad = Math.PI / 180 * degree;
            coordinates.add(center.getX() + size * Math.sin(rad));
            coordinates.add(center.getY() + size * Math.cos(rad));
        }
        return coordinates;
    }
}
