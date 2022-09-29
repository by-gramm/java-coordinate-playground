package coordinate_calculator;

import coordinate_calculator.domain.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RectangleTest {

    @Test
    void 직사각형_생성() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(22, 10),
                Point.of(22, 18), Point.of(10, 18)
        );

        Rectangle rectangle = Rectangle.of(points);
        Assertions.assertThat(rectangle).isInstanceOf(Rectangle.class);
    }
}
