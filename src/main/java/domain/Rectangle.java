package domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Rectangle extends AbstractShape {

    private Rectangle(List<Point> points) {
        super(points);
    }

    public static Rectangle of(List<Point> points) {
        checkRectangle(points);
        return new Rectangle(points);
    }

    private static void checkRectangle(List<Point> points) {
        List<Integer> xList = getXList(points);
        List<Integer> yList = getYList(points);

        checkPairs(xList);
        checkPairs(yList);
    }

    private static void checkPairs(List<Integer> numList) {
        Map<Integer, Integer> numCount = numList.stream()
                .collect(Collectors.toMap(k -> k, v -> 1, Integer::sum));

        numCount.forEach((num, count) -> {
            checkTwo(count);
        });
    }

    private static void checkTwo(Integer count) {
        if (count != 2) {
            throw new IllegalArgumentException("직사각형이 아닌 사각형은 생성할 수 없습니다.");
        }
    }

    private static List<Integer> getXList(List<Point> points) {
        return points.stream()
                .map(Point::getX)
                .collect(Collectors.toList());
    }

    private static List<Integer> getYList(List<Point> points) {
        return points.stream()
                .map(Point::getY)
                .collect(Collectors.toList());
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public String getType() {
        return "사각형";
    }
}
