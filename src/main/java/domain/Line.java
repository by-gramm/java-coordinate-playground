package domain;

import java.util.List;

public class Line extends AbstractShape {

    private Line(List<Point> points) {
        super(points);
    }

    public static Line of(List<Point> points) {
        return new Line(points);
    }

    @Override
    public double getArea() {
        List<Point> points = getPoints();
        Point pointA = points.get(0);
        Point pointB = points.get(1);

        return pointA.getDistance(pointB);
    }
}
