package domain;

import java.util.List;

public class Line extends AbstractShape {

    private Line(List<Point> points) {
        super(points);
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }
}
