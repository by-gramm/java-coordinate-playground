package domain;

import java.util.Objects;

public class Point {
    public static final int MIN_COORDINATE_VALUE = 0;
    public static final int MAX_COORDINATE_VALUE = 24;

    private final int x;
    private final int y;

    private Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Point of(int x, int y) {
        checkRange(x);
        checkRange(y);

        return new Point(x, y);
    }

    private static void checkRange(int value) {
        if (value < MIN_COORDINATE_VALUE || value > MAX_COORDINATE_VALUE) {
            throw new IllegalArgumentException("좌표값은 0 이상 24이하여야 합니다.");
        }
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
}
