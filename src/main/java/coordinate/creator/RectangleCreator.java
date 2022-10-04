package coordinate.creator;

import coordinate.Figure;
import coordinate.Point;
import coordinate.Rectangle;

import java.util.List;

public class RectangleCreator implements FigureCreator {

    @Override
    public Figure create(List<Point> points) {
        return new Rectangle(points);
    }
}
