package coordinate_calculator.domain;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Shape {

    public static final int LINE_SIZE = 2;

    private final List<Point> points;

    public Shape(List<Point> points) {
        this.points = points;
    }

    // 도형 생성
    public static Shape of(List<Point> points) {
        if (points.size() == LINE_SIZE) {
            return Line.create(points);
        }

        return Rectangle.create(points);
    }

    // 좌표 중복 여부 검사
    public static boolean isUnique(List<Point> points) {
        AtomicInteger index = new AtomicInteger();

        return points.stream()
                .allMatch(point -> point.isUnique(points, index.getAndIncrement()));
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(points, shape.points);
    }

    @Override
    public int hashCode() {
        return Objects.hash(points);
    }
}
