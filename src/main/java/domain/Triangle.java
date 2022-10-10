package domain;

import java.util.List;

public class Triangle extends AbstractShape {

    private Triangle(List<Point> points) {
        super(points);
    }

    public static Triangle of(List<Point> points) {
        return new Triangle(points);
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
