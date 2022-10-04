package coordinate;

import coordinate.creator.FigureCreator;
import coordinate.creator.LineCreator;
import coordinate.creator.RectangleCreator;
import coordinate.creator.TriangleCreator;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class FigureFactory {

    private static final ConcurrentHashMap<Integer, FigureCreator> shapeMap = new ConcurrentHashMap<>();

    static {
        shapeMap.put(Line.LINE_POINT_SIZE, new LineCreator());
        shapeMap.put(Triangle.TRIANGLE_POINT_SIZE, new TriangleCreator());
        shapeMap.put(Rectangle.RECTANGLE_POINT_SIZE, new RectangleCreator());
    }

    static Figure getInstance(List<Point> points) {
        if (!shapeMap.containsKey(points.size())) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }

        FigureCreator creator = shapeMap.get(points.size());
        return creator.create(points);
    }
}
