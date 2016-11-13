package hu.daniels.javafx.firsttry;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;

import java.util.List;

/**
 * Created by Dani on 2016.11.12..
 */
public class Hexagon extends Polygon {
    private double size;
    private Point2D center;
    private boolean flatTop;

    public Hexagon(double size , Point2D center, boolean flatTop) {
        this.size = size;
        this.center = center;
        this.flatTop = flatTop;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    public boolean isFlatTop() {
        return flatTop;
    }

    public void setFlatTop(boolean flatTop) {
        this.flatTop = flatTop;
    }
}
