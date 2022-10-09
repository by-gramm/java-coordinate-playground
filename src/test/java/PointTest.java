import domain.Point;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    void 좌표_생성() {
        Point point = Point.of(10, 10);
        assertThat(point).isInstanceOf(Point.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:0", "10:25"}, delimiter = ':')
    void 좌표의_x값과_y값은_0이상_24이하여야_한다(int x, int y) {
        assertThatThrownBy(() -> Point.of(x, y))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌표값은 0 이상 24이하여야 합니다.");
    }
}
