package coordinate_calculator;

import coordinate_calculator.domain.Point;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {

    private final List<Point> points;

    private Rectangle(List<Point> points) {
        this.points = points;
    }

    public static Rectangle of(List<Point> points) {
        return new Rectangle(points);
    }
}
