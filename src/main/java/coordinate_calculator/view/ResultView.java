package coordinate_calculator.view;

import coordinate_calculator.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ResultView {

    public static final int MAX_COORDINATE_VALUE = 24;
    public static final int MIN_COORDINATE_VALUE = 0;

    public void showCoordinates(List<Point> points) {
        List<String> lines = createLines(points);

        lines.forEach(System.out::println);

        showEndLines();
    }

    private List<String> createLines(List<Point> points) {
        List<String> lines = createDefault();

        Collections.sort(points);  // x좌표 값 기준 오름차순 정렬

        points.forEach(point -> addPoint(lines, point));

        return lines;
    }

    private void addPoint(List<String> coordinates, Point point) {
        int distanceY = MAX_COORDINATE_VALUE - (int) point.getY();
        String currentLine = coordinates.get(distanceY);

        int distanceX = 3 * (int) point.getX() + 1 - currentLine.length();

        coordinates.set(distanceY, currentLine + " ".repeat(distanceX) + "*");
    }

    public List<String> createDefault() {
        List<String> coordinates = new ArrayList<>();

        for (int y = MAX_COORDINATE_VALUE; y >= MIN_COORDINATE_VALUE; y--) {
            coordinates.add(getLine(y));
        }

        return coordinates;
    }

    private String getLine(int y) {
        if (y % 2 == 0) {
            return String.format("%2d|", y);
        }
        return "  |";
    }

    private void showEndLines() {
        System.out.println("  +" + "-".repeat(MAX_COORDINATE_VALUE * 3));
        System.out.print(" 0 ");

        for (int num = 2; num <= MAX_COORDINATE_VALUE; num = num + 2) {
            System.out.printf("%6d", num);
        }
    }

    public void showResult(Shape shape) {
        System.out.println("\n" + shape);
    }
}
