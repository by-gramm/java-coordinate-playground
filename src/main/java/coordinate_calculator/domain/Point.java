package coordinate_calculator.domain;

import java.util.Objects;

public class Point implements Comparable<Point> {

    public static final int MIN_COORDINATE_VALUE = 0;
    public static final int MAX_COORDINATE_VALUE = 24;

    private final double x;
    private final double y;

    private Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(double x, double y) {
        if (Math.max(x, y) > MAX_COORDINATE_VALUE || Math.min(x, y) < MIN_COORDINATE_VALUE) {
            throw new IllegalArgumentException("좌표값은 0 이상 24 이하의 수만 가능합니다.");
        }

        return new Point(x, y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Point point) {
        return (int) (this.x - point.getX());
    }
}
