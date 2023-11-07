# 미션 - 로또

## 🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

-[x] 구매급액 입력받기
-[x] 로또 번호의 숫자 범위는 1~45까지이다.
-[x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
-[x] 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
-[x] 일치하는 롯도 번호 개수를 구한다.
-[x] 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
-[x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
-[x] 로또 1장의 가격은 1,000원이다.
-[x] 당첨 번호 입력받는다.
-[x]보너스 번호를 입력받는다.
-[x]사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
-[x] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 추가된 요구 사항

-[ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
-[ ] else를 지양한다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
    - 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.
-[x] Enum 클래스를 적용해 프로그래밍을 구현한다.
-[x] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
    - 단위 테스트 작성이 익숙하지 않다면 `test/kotlin/lotto/LottoTest`를 참고하여 학습한 후 테스트를 구현한다.
-[x] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
-[x] 제공된 `Lotto` 클래스를 활용해 구현해야 한다.

## MVC모델 활용

### Model
- [x] Lotto 클래스에 번호 저장

### View
- [x] 메시지 출력

### Controller
- [x] LottoController : 숫자 입력 받은 것 처리 및 게임 실행
- [x] 사용자에게 숫자 입력 받기
