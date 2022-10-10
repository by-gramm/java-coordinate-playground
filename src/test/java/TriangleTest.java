import domain.Point;
import domain.Triangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    @BeforeEach
    void setup() {
        pointA = Point.of(5, 5);
        pointB = Point.of(10, 10);
        pointC = Point.of(15, 5);
        pointD = Point.of(15, 15);
    }

    @Test
    void 삼각형_생성() {
        Triangle triangle = Triangle.of(Arrays.asList(pointA, pointB, pointC));
        assertThat(triangle).isInstanceOf(Triangle.class);
    }

    @Test
    void 좌표_중복_불가() {
        assertThatThrownBy(() -> Triangle.of(Arrays.asList(pointA, pointB, pointA)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형을 이루는 좌표값은 중복될 수 없습니다.");
    }

    @Test
    void 삼각형의_세_좌표는_일직선상에_있지_않아야_한다() {
        assertThatThrownBy(() -> Triangle.of(Arrays.asList(pointA, pointB, pointD)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("삼각형의 세 좌표는 일직선상에 있지 않아야 합니다.");
    }

    @Test
    void 넓이_계산() {
        Triangle triangle = Triangle.of(Arrays.asList(pointA, pointB, pointC));
        assertThat(triangle.getArea())
                .isEqualTo(25.0, offset(0.0001));
    }
}
