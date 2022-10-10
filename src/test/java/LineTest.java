import domain.Line;
import domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    private Point pointA;
    private Point pointB;
    
    @BeforeEach
    void setup() {
        pointA = Point.of(10, 10);
        pointB = Point.of(15, 15);
    }

    @Test
    void 직선_생성() {
        Line line = Line.of(Arrays.asList(pointA, pointB));
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    void 좌표값_중복_검사() {
        assertThatThrownBy(() -> Line.of(Arrays.asList(pointA, pointA)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("도형을 이루는 좌표값은 중복될 수 없습니다.");
    }
}
