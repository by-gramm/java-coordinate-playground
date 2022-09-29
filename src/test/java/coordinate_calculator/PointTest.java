package coordinate_calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    void 좌표_생성() {
        Point point = Point.of(10, 20);
        assertThat(point).isInstanceOf(Point.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:-1:true", "24:24:false", "0:0:false", "10:25:true"}, delimiter = ':')
    void 좌표값_예외_처리(int x, int y, boolean isException) {
        if (isException) {
            assertThatThrownBy(() -> Point.of(x, y))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("좌표값은 0 이상 24 이하의 수만 가능합니다.");
        }

        if (!isException) {
            assertThatCode(() -> Point.of(x, y))
                    .doesNotThrowAnyException();
        }
    }
}
