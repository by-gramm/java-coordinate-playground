import domain.Shape;
import view.InputView;
import view.ResultView;

public class CoordinateCalculator {

    public static void run() {
        // 좌표값 입력받기 + 도형 생성하기
        Shape shape = InputView.getInput();

        // 좌표 출력하기
        ResultView.showCoordinates(shape.getPoints());

        // 거리 or 넓이 출력하기
        ResultView.showResult(shape);
    }
}
