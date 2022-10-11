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

    @Override
    public String getType() {
        return "직선";
    }

    @Override
    public String getAreaInfo() {
        return getType() + "의 길이는 " + getArea();
    }
}
