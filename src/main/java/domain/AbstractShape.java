package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractShape implements Shape {

    private final List<Point> pointList = new ArrayList<>();

    protected AbstractShape(List<Point> points) {
        points.forEach(point -> {
            checkDuplicate(point);
            this.pointList.add(point);
        });
    }

    @Override
    public void checkDuplicate(Point point) {
        if (this.pointList.contains(point)) {
            throw new IllegalArgumentException(this.getType() + "을 이루는 좌표값은 중복될 수 없습니다.");
        }
    }

    @Override
    public List<Point> getPoints() {
        return this.pointList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractShape that = (AbstractShape) o;
        return Objects.equals(pointList, that.pointList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointList);
    }
}
