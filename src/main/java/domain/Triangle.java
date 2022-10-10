package domain;

import java.util.List;

public class Triangle extends AbstractShape {

    private Triangle(List<Point> points) {
        super(points);
    }

    public static Triangle of(List<Point> points) {
        checkColinear(points);
        return new Triangle(points);
    }

    private static void checkColinear(List<Point> points) {
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);

        pointA.checkColinear(pointB, pointC);
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public String getType() {
        return "삼각형";
    }
}
