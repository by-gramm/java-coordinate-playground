package coordinate_calculator.domain;

import java.util.List;

public class Triangle extends Shape implements AreaCalculable {

    private Triangle(List<Point> points) {
        super(points);
    }

    public static Triangle create(List<Point> points) {
        return new Triangle(points);
    }

    @Override
    public double getArea() {
        return 0;
    }
}
