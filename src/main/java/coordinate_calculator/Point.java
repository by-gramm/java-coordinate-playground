package coordinate_calculator;

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
        if (Math.max(x, y) > MAX_COORDINATE_VALUE || Math.min(x, y) < MIN_COORDINATE_VALUE) {
            throw new IllegalArgumentException("좌표값은 0 이상 24 이하의 수만 가능합니다.");
        }

        return new Point(x, y);
    }
}
