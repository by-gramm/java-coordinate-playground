package coordinate_calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape implements AreaCalculable {

    private final List<Double> distances = new ArrayList<>();

    private Triangle(List<Point> points) {
        super(points);

        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);

        distances.add(pointA.getDistance(pointB));
        distances.add(pointA.getDistance(pointC));
        distances.add(pointB.getDistance(pointC));
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
        // 삼각형의 세 변의 길이가 a, b, c이고 s = (a + b + c) // 2일 때,
        // 삼각형의 넓이 = ( s * (s - a) * (s - b) * (s - c) ) ** 0.5
        double distanceA = distances.get(0);
        double distanceB = distances.get(1);
        double distanceC = distances.get(2);
        double s = (distanceA + distanceB + distanceC) / 2;

        return Math.sqrt(s * (s - distanceA) * (s - distanceB) * (s - distanceC));
    }

    private double getPerimeter() {
        return distances.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    private static boolean isColinear(List<Point> points) {
        Point pointA = points.get(0);
        Point pointB = points.get(1);
        Point pointC = points.get(2);

        return pointA.isColinear(pointB, pointC);
    }
}
