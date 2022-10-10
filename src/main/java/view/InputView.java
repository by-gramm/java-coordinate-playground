package view;

import domain.Point;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {

    private static final String SINGLE_COORDINATE_PATTERN = "\\((\\d{1,2}),(\\d{1,2})\\)";

    public static List<Point> inputCoordinates(String inputString) {
        inputString = inputString.replace(" ", "");
        String[] pointStrings = inputString.split("-");

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
