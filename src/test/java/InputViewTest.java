import domain.Point;
import domain.Shape;
import domain.ShapeFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import java.util.Arrays;
import java.util.InputMismatchException;

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
        Shape shape = InputView.inputCoordinates("(5,5)-(10,15)");
        assertThat(shape).isEqualTo(ShapeFactory.create(Arrays.asList(pointA, pointB)));
    }
}
