# 좌표계산기

### TODO

1. 선 길이
   1. [x] 사용자로부터 좌표 정보를 입력받는다.
      1. [x] 좌표 정보는 괄호로 둘러쌓여 있으며, 쉼표로 X, Y값을 구분한다.
      2. [x] 좌표를 여러 개 입력하는 경우, 좌표값 사이는 '-' 문자로 구분한다.
      3. [x] X, Y 좌표 모두 0 이상 24 이하여야 한다.
      4. [x] 입력 범위를 벗어난 경우, 에러 문구를 출력하고 다시 입력을 받는다.
   2. [x] 사용자가 입력한 좌표에 특수문자를 표시한다.
   3. [x] 좌표값을 2개 입력한 경우, 두 점을 잇는 직선의 거리를 계산한다.
   4. [x] 계산한 거리를 출력한다.

2. 사각형 면적
   - [ ] 좌표값을 4개 입력한 경우, 네 점을 연결하는 사각형으로 가정한다.
     - [ ] 네 점이 만드는 사각형이 직사각형이 아니면, 에러 문구를 출력하고 다시 입력을 받는다.
   - [ ] 직사각형의 넓이를 계산한다.
   - [ ] 계산한 넓이를 출력한다.

3. 삼각형 면적
   - [ ] 좌표값을 3개 입력한 경우, 세 점을 연결하는 삼각형의 넓이를 계산한다.
   - [ ] 계산한 넓이를 출력한다.

<br>

### 프로그래밍 요구사항

- 상속과 인터페이스를 적용해 중복 코드를 제거한다. **(삼각형 면적 과제 only!)**
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

<br>

# 연료 주입

### 기능 요구사항

우리 회사는 렌터카를 운영하고 있다. 현재 보유하고 있는 차량은 Sonata 2대, Avante 1대, K5 2대로 총 5대의 차량을 보유하고 있다.

우리 회사는 고객이 인터넷으로부터 예약할 때 여행할 목적지의 대략적인 이동거리를 입력 받는다. 이 이동거리를 활용해 차량 별로 필요한 연료를 주입한다.

차량 별로 주입해야 할 연료량을 확인할 수 있는 보고서를 생성해야 한다.

### 프로그래밍 요구사항 - 1단계

- 상속과 추상 메소드를 활용한다.
- 위 요구사항을 if/else 절을 쓰지 않고 구현해야 한다.

### 프로그래밍 요구사항 - 2단계

- 인터페이스를 적용해 구현한다.