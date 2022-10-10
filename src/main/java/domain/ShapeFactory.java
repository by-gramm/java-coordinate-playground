package domain;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class ShapeFactory {

    private static final int LINE_SIZE = 2;
    private static final int TRIANGLE_SIZE = 3;
    private static final int RECTANGLE_SIZE = 4;

    private static final HashMap<Integer, Function<List<Point>, Shape>> shapeMap = new HashMap<>();

    static {
        shapeMap.put(LINE_SIZE, Line::of);
        shapeMap.put(TRIANGLE_SIZE, Triangle::of);
        shapeMap.put(RECTANGLE_SIZE, Rectangle::of);
    }

    public static Shape create(List<Point> points) {
        checkLength(points);

        return shapeMap.get(points.size()).apply(points);
    }

    private static void checkLength(List<Point> points) {
        if (points.size() < LINE_SIZE || points.size() > RECTANGLE_SIZE) {
            throw new IllegalArgumentException("도형을 이루는 좌표는 2개 이상 4개 이하여야 합니다.");
        }
    }
}
