import domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;

public class ShapeFactoryTest {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;
    private Point pointE;

    @BeforeEach
    void setup() {
        pointA = Point.of(5, 5);
        pointB = Point.of(5, 10);
        pointC = Point.of(15, 10);
        pointD = Point.of(15, 5);
        pointE = Point.of(20, 20);
    }

    @Test
    void 직선_생성() {
        Shape line = ShapeFactory.create(Arrays.asList(pointA, pointC));
        assertThat(line).isInstanceOf(Line.class);
    }

    @Test
    void 삼각형_생성() {
        Shape triangle = ShapeFactory.create(Arrays.asList(pointA, pointB, pointC));
        assertThat(triangle).isInstanceOf(Triangle.class);
    }

    @Test
    void 사각형_생성() {
        Shape rectangle = ShapeFactory.create(Arrays.asList(pointA, pointB, pointC, pointD));
        assertThat(rectangle).isInstanceOf(Rectangle.class);
    }

    @Test
    void 좌표는_2개_이상_4개_이하여야_한다() {
        assertThatThrownBy(() -> ShapeFactory.create(Collections.singletonList(pointA)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("도형을 이루는 좌표는 2개 이상 4개 이하여야 합니다.");

        assertThatThrownBy(() -> ShapeFactory.create(Arrays.asList(pointA, pointB, pointC, pointD, pointE)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("도형을 이루는 좌표는 2개 이상 4개 이하여야 합니다.");
    }
}
