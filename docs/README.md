1. 프로그래밍 요구 사항
 1-1 1주차
   - 프로그램 실행의 시작점은 Application의 main()이다.
   - Kotlin 코드 컨벤션 가이드를 준수하며 프로그래밍한다.
 1-2 2주차
   - indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
   - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
   - JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.
 1-3 2주차 공통 피드백
   - 문자열, 숫자 등의 값을 하드 코딩하지 마라. 
   - 구현 순서도 코딩 컨벤션이다
     - 클래스는 프로퍼티, init 블록, 부 생성자, 메서드, 동반 객체 순으로 작성한다.
   - 한 함수가 한 가지 기능만 담당하게 한다
 1-4 3주차
   - 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
     - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
   - else를 지양한다.
     - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
     - 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
   - Enum 클래스를 적용해 프로그래밍을 구현한다.
   - 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
     - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
     - 단위 테스트 작성이 익숙하지 않다면 test/kotlin/lotto/LottoTest를 참고하여 학습한 후 테스트를 구현한다.

2. 구현할 기능 목록

   - [x] application.kt
     - [x] 게임 시작

   - [x] Lotto.kt - Lotto 객체 선언
     - [x] numbers 유효성 검사
     - [x] 정렬된 로또 번호 출력
   - [x] LottaGame.kt - LottaGame 객체 선언
     -  [x] count값에 맞는 Lottos 객체 생성
   - [x] InputValidator.kt - 입력에 대한 유효성 검사 클래스
     - [x] 보너스 번호와 당첨 번호의 중복 여부 확인
   - [x] LottoResult.kt 당첨 여부 및 출력
     - [x] 로또 번호 비교 및 등수 산정
     - [x] 당첨 내역 계산
     - [x] 수익률 계산
     - [x] 당첨 내역 및 수익률 출력

  - [x] Lotto 및 Lottos 인스턴스 생성 실패 시 예외 던지기
 
    - [x] 입력 처리
      - [x] 로또 구입 금액 입력 처리
      - [x] 당첨 번호 입력 처리
      - [x] 보너스 번호 입력 처리
      - [x] 기준에 맞지 않는 입력이 들어왔을 경우 예외처리 및 재입력 처리

    - [x] pickUniqueNumbersInRange()를 로또 번호 발행 처리

    - [x] 출력 처리
      - [x] 발행한 로또 수량 및 번호 출력
      - [x] 당첨 내역 출력
      - [x] 총 수익률 출력
      - [x] 에러 문구 출력
      - [x] 올바른 개행 처리

    - [x] 유닛 테스트
      - [x] 올바르지 않은 구입 금액 입력(숫자 외의 문자)
      - [x] 올바르지 않은 구입 금액 입력(0보다 작거나 1000으로 나누어떨어지지 않는 숫자)
      - [x] 올바르지 않은 로또 번호
      - [x] 올바르지 않은 당첨 번호 입력 (숫자 외의 문자)
      - [x] 올바르지 않은 당첨 번호 입력 (1~45가 아닌 숫자)
      - [x] 올바르지 않은 보너스 번호 입력 (숫자 외의 문자)
      - [x] 올바르지 않은 보너스 번호 입력 (1~45가 아닌 숫자)
      - [x] 당첨 번호에 따른 등수 산정 테스트

    - [x] CHANGELOG.md 추가

3. 개선할 사항
   - 테스트 코드 작성 시 라이브러리를 호출해도 되는가? 
     - junit 라이브러리니까 OK
   - [ ] 구조 개선을 통해 test용 getter 없이도 테스트 코드 동작하게 하기(mvp)
   - factory method 등 학습
   - [x] enum class를 통한 상수 선언 (prize)
   - [x] round 계산 시의 수익률 오버플로우를 고려한 자료형 책정.
   - [x] 가로 120줄이 넘는 구문 처리.
   - [x] validateWinningNumber 함수의 구조가 다소 복잡함.
     - toInt() 메서드로 NumberFormatException를 던지면서 해결함.

4. 학습한 내용
   - IllegalStateException vs IllegalArugumentException
     - IllegalStateException의 경우 enum을 통해서 프로그램의 state(시작, 입력, 당첨처리, 출력)에 이상이 있는 경우에 발생하는 에러를
       내보내는 것으로 이해하였지만 state관리가 어려워서 보류...

   - toInt() 메서드를 통해 발생하는 NumberFormatException 오픈 클래스가 IllegalArugumentException 클래스를 상속받는 형태로 되어 있어
     별도의 처리를 하지 않아도 catch(e: IllegalArugumentException) 구문에서 잡힘.