package coordinate_calculator.domain;

import java.util.List;

public class Triangle extends Shape implements AreaCalculable {

    private Triangle(List<Point> points) {
        super(points);
    }

    public static Triangle create(List<Point> points) {
        if (!isUnique(points)) {
            throw new IllegalArgumentException("삼각형을 이루는 좌표는 중복될 수 없습니다.");
        }
        if (isColinear(points)) {
            throw new IllegalArgumentException("삼각형을 이루는 세 좌표는 하나의 직선 위에 있지 않아야 합니다.");
        }
        return new Triangle(points);
    }

    @Override
    public double getArea() {
        return 0;
    }

    private static boolean isColinear(List<Point> points) {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        return point1.isColinear(point2, point3);
    }
}
