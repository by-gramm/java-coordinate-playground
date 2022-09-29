package coordinate_calculator;

import coordinate_calculator.domain.Point;

public class Line {

    private final Point point1;
    private final Point point2;

    private Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public static Line of(Point point1, Point point2) {
        return new Line(point1, point2);
    }
}
