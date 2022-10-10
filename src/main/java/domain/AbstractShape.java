package domain;

import java.util.ArrayList;
import java.util.List;

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
}
