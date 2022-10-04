package coordinate_calculator;

import coordinate_calculator.domain.Point;
import coordinate_calculator.domain.Shape;
import coordinate_calculator.domain.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    @Test
    void 삼각형_생성() {
        Triangle triangle = Triangle.create(Arrays.asList(
                Point.of(5, 5), Point.of(10, 10), Point.of(15, 5)
        ));

        assertThat(triangle).isInstanceOf(Triangle.class);
    }

    @Test
    void 좌표_중복_불가() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(10, 10), Point.of(20, 20)
        );

        assertThatThrownBy(() -> Shape.of(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형을 이루는 좌표는 중복될 수 없습니다.");
    }

    @Test
    void 삼각형의_세_좌표는_한_직선_위에_있지_않아야_한다() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(13, 13.5), Point.of(19, 20.5)
        );

        assertThatThrownBy(() -> Shape.of(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형을 이루는 세 좌표는 하나의 직선 위에 있지 않아야 합니다.");
    }

    @Test
    void 넓이_계산() {
        Triangle triangle = (Triangle) Shape.of(Arrays.asList(
                Point.of(5, 5), Point.of(10, 10), Point.of(15, 5)
        ));

        assertThat(triangle.getArea())
                .isEqualTo(25.0, offset(0.0001));
    }
}
