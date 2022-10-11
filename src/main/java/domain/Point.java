package domain;

import java.util.Objects;

public class Point implements Comparable<Point> {
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

    public double getDistance(Point point) {
        double xSquare = Math.pow(getXDifference(point), 2);
        double ySquare = Math.pow(getYDifference(point), 2);

        return Math.pow(xSquare + ySquare, 0.5);
    }

    private int getXDifference(Point point) {
        return this.getX() - point.getX();
    }

    private int getYDifference(Point point) {
        return this.getY() - point.getY();
    }

    public void checkColinear(Point pointA, Point pointB) {
        if (isVertical(pointA) ^ isVertical(pointB)) {
            return;
        }
        if (isVertical(pointA) && isVertical(pointB)) {
            throw new IllegalArgumentException("삼각형의 세 좌표는 일직선상에 있지 않아야 합니다.");
        }
        if (getInclination(pointA) == getInclination(pointB)) {
            throw new IllegalArgumentException("삼각형의 세 좌표는 일직선상에 있지 않아야 합니다.");
        }
    }

    private double getInclination(Point point) {
        int dx = getXDifference(point);
        int dy = getYDifference(point);

        return dy / dx;
    }

    private boolean isVertical(Point point) {
        return this.getX() == point.getX();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
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
