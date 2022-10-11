package view;

import domain.Point;
import domain.Shape;
import domain.ShapeFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String SINGLE_COORDINATE_PATTERN = "\\((\\d{1,2}),(\\d{1,2})\\)";
    private static final String DELIMETER = "-";

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Shape getInput() {
        System.out.println("좌표를 입력하세요.");

        String inputString = readInput();

        return inputCoordinates(inputString);
    }

    private static String readInput() {
        String inputString = null;

        try {
            inputString = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return inputString;
    }

    public static Shape inputCoordinates(String inputString) {
        inputString = inputString.replace(" ", "");
        String[] pointStrings = inputString.split(DELIMETER);
        List<Point> points;

        try {
            points = toPoints(pointStrings);
            return ShapeFactory.create(points);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getInput();
        }
    }

    private static List<Point> toPoints(String[] pointStrings) {
        return Arrays.stream(pointStrings)
                .map(InputView::toPoint)
                .collect(Collectors.toList());
    }

    private static Point toPoint(String pointString) {
        Pattern pattern = Pattern.compile(SINGLE_COORDINATE_PATTERN);
        Matcher matcher = pattern.matcher(pointString);

        if (!matcher.find()) {
            throw new InputMismatchException("입력 형식이 올바르지 않습니다.");
        }

        int x = Integer.parseInt(matcher.group(1));
        int y = Integer.parseInt(matcher.group(2));
        return Point.of(x, y);
    }
}
