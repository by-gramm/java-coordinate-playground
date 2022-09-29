package coordinate_calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    void 좌표_생성() {
        Point point = Point.of(10, 20);
        assertThat(point).isInstanceOf(Point.class);
    }
}
