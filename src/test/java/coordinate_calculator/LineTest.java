package coordinate_calculator;

import coordinate_calculator.domain.Line;
import coordinate_calculator.domain.Point;
import coordinate_calculator.utils.LineUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    void 직선_생성() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(15, 20);
        Line line = Line.of(point1, point2);

        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    void 직선의_두_좌표는_달라야_한다() {
        Point point1 = Point.of(10, 10);
        Point point2 = Point.of(10, 10);

        assertThatThrownBy(() -> Line.of(point1, point2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직선을 이루는 두 좌표는 달라야 합니다.");
    }

    @Test
    void 입력값_직선으로_변환() {
        String inputString = "(10,10)-(14,15)";
        Line line = LineUtils.toLine(inputString);

        assertThat(line).isEqualTo(Line.of(
                Point.of(10, 10), Point.of(14, 15)
        ));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:3:9:11:10", "5:5:9:10:6.403124"}, delimiter = ':')
    void 거리_계산(double x1, double y1, double x2, double y2, double distance) {
        Point point1 = Point.of(x1, y1);
        Point point2 = Point.of(x2, y2);
        Line line = Line.of(point1, point2);

        assertThat(line.getDistance())
                .isEqualTo(distance, offset(0.0001));
    }
}
