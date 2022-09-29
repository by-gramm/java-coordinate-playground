package coordinate_calculator.domain;

import java.util.Objects;

public class Line {

    private final Point point1;
    private final Point point2;

    private Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public static Line of(Point point1, Point point2) {
        if (point1.equals(point2)) {
            throw new IllegalArgumentException("직선을 이루는 두 좌표는 달라야 합니다.");
        }

        return new Line(point1, point2);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(point1, line.point1) && Objects.equals(point2, line.point2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(point1, point2);
    }

    public double getDistance() {
        double dx = point1.getX() - point2.getX();
        double dy = point1.getY() - point2.getY();

        return Math.pow(dx * dx + dy * dy, 0.5);
    }
}
