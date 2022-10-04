package coordinate_calculator;

import coordinate_calculator.domain.Point;
import coordinate_calculator.domain.Shape;
import coordinate_calculator.domain.Triangle;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    @Test
    void 삼각형_생성() {
        Triangle triangle = Triangle.create(Arrays.asList(
                Point.of(5, 5), Point.of(10, 10), Point.of(15, 5)
        ));

        assertThat(triangle).isInstanceOf(Triangle.class);
    }
}
