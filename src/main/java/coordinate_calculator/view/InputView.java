package coordinate_calculator.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public String takeCoordinates() throws IOException {
        System.out.println("좌표를 입력하세요.");
        return reader.readLine();
    }
}
