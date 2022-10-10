import domain.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class InputViewTest {

    private Point pointA;
    private Point pointB;

    @BeforeEach
    void setup() {
        pointA = Point.of(5, 5);
        pointB = Point.of(10, 15);
    }

    @Test
    void 입력값_받기() {
        List<Point> points = InputView.inputCoordinates("(5,5)-(10,15)");
        assertThat(points).isEqualTo(Arrays.asList(pointA, pointB));
    }

    @ParameterizedTest
    @ValueSource(strings = {"(10)-(5,5)", "10,10-20,20", "(1.5,2.5)-(10,10)", "(,10)-(5,15)"})
    void 입력값_형식_검사(String inputString) {
        assertThatThrownBy(() -> InputView.inputCoordinates(inputString))
                .isInstanceOf(InputMismatchException.class)
                .hasMessage("입력 형식이 올바르지 않습니다.");
    }
}
