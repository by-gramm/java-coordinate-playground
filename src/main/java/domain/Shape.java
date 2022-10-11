package domain;

import java.util.List;

public interface Shape {

    void checkDuplicate(Point point);

    List<Point> getPoints();

    double getArea();

    String getType();

    String getAreaInfo();
}
