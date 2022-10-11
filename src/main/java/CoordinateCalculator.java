import domain.Shape;
import view.InputView;

public class CoordinateCalculator {

    public static void run() {
        // 좌표값 입력받기
        Shape shape = InputView.getInput();
        // 도형 생성하기
        System.out.println(shape.getArea());
        // 도형 출력하기
    }
}
