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

    @BeforeEach
    void setup() {
        pointA = Point.of(5, 5);
        pointB = Point.of(10, 10);
        pointC = Point.of(15, 15);
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
}
