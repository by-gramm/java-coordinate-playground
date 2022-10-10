import domain.Point;
import domain.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RectangleTest {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    @BeforeEach
    void setup() {
        pointA = Point.of(5, 5);
        pointB = Point.of(15, 5);
        pointC = Point.of(15, 10);
        pointD = Point.of(5, 10);
    }

    @Test
    void 사각형_생성() {
        Rectangle rectangle = Rectangle.of(Arrays.asList(pointA, pointB, pointC, pointD));
        assertThat(rectangle).isInstanceOf(Rectangle.class);
    }

    @Test
    void 직사각형_여부_확인() {
        Point pointE = Point.of(5, 11);
        assertThatThrownBy(() -> Rectangle.of(Arrays.asList(pointA, pointB, pointC, pointE)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("직사각형이 아닌 사각형은 생성할 수 없습니다.");
    }

    @Test
    void 넓이_계산() {
        Rectangle rectangle = Rectangle.of(Arrays.asList(pointA, pointB, pointC, pointD));
        assertThat(rectangle.getArea()).isEqualTo(50);
    }
}
