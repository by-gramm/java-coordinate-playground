package coordinate_calculator;

import coordinate_calculator.domain.Point;
import coordinate_calculator.domain.Rectangle;
import coordinate_calculator.domain.Shape;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {

    @Test
    void 직사각형_생성() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(22, 10),
                Point.of(22, 18), Point.of(10, 18)
        );

        Rectangle rectangle = Rectangle.create(points);
        assertThat(rectangle).isInstanceOf(Rectangle.class);
    }

    @Test
    void 직사각형의_점의_개수는_4() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(22, 10), Point.of(22, 18)
        );

        assertThatThrownBy(() -> Rectangle.create(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형의 점의 개수는 4개여야 합니다.");
    }

    @Test
    void 좌표는_중복_불가() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(10, 10),
                Point.of(20, 20), Point.of(20, 20)
        );

        assertThatThrownBy(() -> Shape.of(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형을 이루는 좌표는 중복될 수 없습니다.");
    }

    @Test
    void 직사각형만_허용() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(20, 20),
                Point.of(10, 20), Point.of(20, 18)
        );

        assertThatThrownBy(() -> Shape.of(points))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형 이외의 사각형은 만들 수 없습니다.");
    }

    @Test
    void 넓이_계산() {
        List<Point> points = Arrays.asList(
                Point.of(10, 10), Point.of(22, 10),
                Point.of(22, 18), Point.of(10, 18)
        );

        Rectangle rectangle = (Rectangle) Shape.of(points);

        assertThat(rectangle.getArea()).isEqualTo(96);
    }
}
