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
        return new Line(point1, point2);
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
}
