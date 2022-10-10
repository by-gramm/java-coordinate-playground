# 좌표계산기 (2번째 구현)

### 2번째 구현의 추가 목표

- Java 기본 제공 함수형 인터페이스를 활용한다.
- 정규표현식으로 입력값 형식이 유효한지 확인한다.
- 예외 처리시 if문을 사용하지 않는 패턴을 활용해본다.

    ```java
    // before
    method() {
        if (!isDuplicate) { throw new ~~Exception }
        // 메인 로직 수행
    }
    
    boolean isDuplicate()
    
    // after
    method() {
        checkDuplication();
        // 메인 로직 수행
    }
    
    void checkDuplication() { if (~~) throw new ~~Exception }`
    ```

<br>

### TODO

- [ ] 좌표 정보 입력받기
  - [ ] 좌표 정보는 괄호로 둘러쌓여 있으며, 쉼표로 X, Y값을 구분한다.
  - [ ] 좌표를 여러 개 입력하는 경우, 좌표값 사이는 '-' 문자로 구분한다.
  - [ ] 좌표 정보 예외 처리
    - [ ] 입력값 형식이 유효한 좌표 정보여야 한다.
    - [x] X, Y 좌표 모두 0 이상 24 이하의 **정수**여야 한다.
    - [ ] 좌표값은 2개 이상 4개 이하여야 한다.
    - [x] 좌표는 서로 중복되지 않아야 한다.
- [ ] 입력받은 좌표 정보 저장하기
  - [x] 좌표값을 2개 입력한 경우, 두 점을 잇는 직선으로 가정한다.
    - [x] 직선의 거리를 계산한다.
  - [x] 좌표값을 3개 입력한 경우, 세 점을 연결하는 삼각형으로 가정한다.
    - [x] 삼각형 좌표 정보 예외 처리
      - [x] 3개의 좌표는 일직선상에 있지 않아야 한다.
    - [x] 삼각형의 넓이를 계산한다. (헤론의 공식 활용)
  - [x] 좌표값을 4개 입력한 경우, 네 점을 연결하는 직사각형으로 가정한다.
    - [x] 직사각형 좌표 정보 예외 처리
      - [x] 4개의 좌표가 만드는 사각형은 직사각형이어야 한다.
    - [ ] 직사각형의 넓이를 계산한다.
- [ ] 좌표 정보 출력하기
  - [ ] 0 ~ 24 사이의 값을 나타낼 수 있는 X축과 Y축을 출력한다.
  - [ ] 좌표들을 출력한다.
  - [ ] 좌표가 2개면 직선의 거리를, 3 or 4개면 도형의 넓이를 출력한다.

<br>

### 프로그래밍 요구사항

- 상속과 인터페이스를 적용해 중복 코드를 제거한다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)을 원칙으로 한다.
    - 단, 들여쓰기는 '2 spaces'가 아닌 '4 spaces'로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
    - else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
    - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- 함수(또는 메서드)의 길이가 10라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메소드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- 모든 원시 값과 문자열을 포장한다
- 줄여 쓰지 않는다(축약 금지).
- 일급 컬렉션을 쓴다.