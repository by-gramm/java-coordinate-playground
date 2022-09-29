package coordinate_calculator;

import coordinate_calculator.domain.Point;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void 직선_생성() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(15, 20);
        Line line = Line.of(point1, point2);
        assertThat(line).isInstanceOf(Line.class);
    }
}
