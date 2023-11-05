## 기능 목록

- 게임 시작 전
    - [x]  구입 안내 메세지 출력한다. - OutputView#printGameStartMessage()
    - [x]  로또 구매 가격을 입력한다. - InputView#getUserInput()
        - [x]  숫자가 아니면 예외처리한다. - Validator#validateInteger()
        - [x]  로또 가격의 범위가 유효하지 않다면 예외처리한다. - Validator#validateRange()
        - [x]  로또 가격이 1000원 단위가 아니면 예외처리한다. - Validator#validate1000Unit()
- 로또 시작
    - [x]  로또 발행 안내 메세지를 출력한다. - OutputView#printPurchaseCount()
    - [x]  구매 가격만큼 로또를 발행한다. - LottoGenerator#getSortedNumbers()
    - [x]  로또를 구매한 개수만큼 출력한다. - OutputView#printLottoTicket()
        - [x]  각 숫자는 중복이 없어야 한다.
        - [x]  각 숫자는 1부터 45까지의 숫자여야 한다.
        - [x]  번호는 오름차순으로 보여줘야 한다.
- 당첨 번호 입력
    - [x]  당첨 번호 입력 안내 메세지를 출력한다. - Validator#printLottoPurchaseInfoMessage()
    - [x]  당첨 번호를 입력한다. - InputView#getValidLottoInput()
        - [x]  당첨 번호는 6자리를 입력한다. - Validator#validateLottoLength()
        - [x]  당첨 번호에 공백 또는 널값이 들어오면 예외처리한다. - Validator#validateNotNull()
        - [x]  숫자가 아닐 시 예외처리한다. - Validator#validateInteger()
        - [x]  각 번호가 1부터 45까지의 번호가 아닐 시 예외처리한다. - Validator#validateNumberRange()
        - [x]  중복된 숫자가 존재할 시 예외처리 한다. - Validator#validateLottoUnique()
    - [x]  보너스 번호를 입력 안내 메세지를 출력한다. - OutputView#printBonusLottoInfoMessage()
    - [x]  보너스 번호를 입력한다. - UserInput#getUserInput()
        - [x]  숫자가 아닐 시 예외처리한다. - Validator#validateInteger()
        - [x]  당첨 번호와 중복된 숫자를 입력할 시 예외처리한다. - Validator#validateContain()
        - [x]  1부터 45까지의 숫자가 아닐 시 예외처리한다. - Validator#validateNumberRange()
        - [x]  당첨 번호에 공백 또는 널값이 들어오면 예외처리한다. - Validator#validateNotNull()
- 로또 종료
    - [x]  로또 등수를 구한다. - LottoResult#calculateRanking()
    - [x]  당첨 통걔를 출력한다. - OutputView#printLottoRankings()
        - [x]  3개부터 6개까지 내림차순으로 출력한다.
    - [x]  로또 수익률을 구한다. - LottoProfit#calculateRate()
    - [x]  로또 수익률을 출력한다. - OutputView#printLottoProfitRate()
        - [x]  수익률은 소수점 둘째자리에서 반올림한다.(ex 100.0%, 51.5%)

<br>

## 기능 요구사항

- [x]  예외 처리는 IllegalArgumentException을 발생시키고 "[ERROR]”로 시작하는 에러 메세지를 출력한다.
- [x]  에러메세지를 출력하고 그 부분부터 다시 입력받는다.
- [x]  게임 종료 시 `System.exit()` 를 호출하지 않는다.
- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어야한다.
- [ ]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ]  else를 지양한다.
- [x]  Enum 클래스를 적용해 프로그래밍을 구현한다.
- [x]  핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- [ ]  `Lotto` 클래스에 필드를 추가할 수 없다.
- [x]  랜덤값 추출 `camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange` 사용한다.
- [x]  사용자 입력은 `camp.nextstep.edu.missionutils.Console.readLine()` 을 이용한다.

<br>

## 고민인 부분

1. 재 입력을 받을 때에는 입력 안내 메세지도 같이 출력해야할까??
2. 검증은 어디서 하는 것이 적당할까?

   → 현재 inputView와 model에서 나눠서 진행하고 있다.

   → 이렇게 하는 방식이 맞을까? 모델 또는 inputview에서 한번에 처리하는 것이 맞을까

   🌟최종 : InputView에서는 최소한의 검증인 널값, 정수 변환 가능 여부만 수행하며, 유효 범위, 중복등은 모델에서 수행한다.


3. Lotto 클래스에서 number의 private를 제거하지 말라 라는 요구사항이 있다.

   → 내가 한 방식에서는 get을 통해서 number에 접근하는데 이것조차 하지 말라는 뜻인가?

   → 그렇다는 것은 Lotto 내부에서 당첨 확인을 하라는 의도인 것인가?

4. 검증 부분은 Validator 클래스로 관리하고 있다.

   → 하지만 이렇게 하는 방식이 맞을까?

   → 모델 클래스 생성자를 통해 받아온 값을 init 에서 검증하는 부분이 있는데 그럼 테스트케이스를 작성할 때
   Validator 클래스에서 테스트를 진행해야할까 Lotto 클래스에서 테스트를 해야할까

   🌟최종 : ValidatorTest에서도 테스트를 수행하고 모델에서도 검증 테스트를 한다.

5. 보너스번호를 관리하는 좋은 방법이 없을까?

   🌟 최종 : Bonus 클래스를 만들어 보너스 번호를 관리한다. (검증 또한 Bonus 클래스에서)

6. 현재 MainController에 너무 많은 로직이 모였다. 어떤식으로 분리하면 좋을까?


<br>

## 프로젝트 구조

```
.
├── Application.kt
├── controller
│   └── LottoController.kt
├── model
│   ├── Bonus.kt
│   ├── Lotto.kt
│   ├── LottoProfit.kt
│   ├── LottoRankings.kt
│   ├── LottoResult.kt
│   ├── LottoTicket.kt
│   └── PurchaseCount.kt
├── util
│   ├── Exception.kt
│   ├── LottoGenerator.kt
│   └── Validator.kt
└── view
    ├── InputView.kt
    └── OutputView.kt
```

### Lotto

`Application.kt` : LottoController를 생성하여 로또 게임을 실행한다.

### Controller

- `LottoController` : 로또 게임 관련 중요한 로직을 수행한다.

### model

- `Bonus` : 보너스 게임 숫자를 관리한다.
    - `checkUniqueNumber()` : 보너스 번호가 중복된 번호가 아닌지 확인한다.
    - `getNumber()` : 보너스 번호 정수값으로 변환하여 가져온다.
- `Lotto` : 당첨 번호(6개)를 관리한다.
    - `getWinningNumbers()` : 당첨 번호 리스트를 가져온다.
- `LottoProfit` : 수익률을 계산하고 관리한다.
    - `getTotalGain()` : 총 당첨 금액을 구하여 반환한다.
    - `calculateRate()` : 수익률을 계산한다.
- `LottoRankings` : 등수 관련 리스트를 관리한다(순위 리스트)
    - `addRanking()` : 등수에 맞는 인덱스의 값에 1을 추가한다.
- `LottoResult` : 등수를 구한다 (LottoRankings랑 겹쳐서 둘이 합쳐야 할 것 같다.)
    - `calculateRanking()` : 등수를 구하여 반환한다.
- `LottoTicket` : 발행된 번호들을 2차원 배열로 관리한다.
    - `addNumbers()` : 발행 번호 관리 리스트에 발행된 번호를 추가한다.
- `PurchaseCount` : 발행 횟수 값을 관리한다.

### util

- `Exception` : 예외 처리 메세지를 관리한다.
- `LottoGenerator` : 번호를 발행하여 관리한다.
    - `getSortedNumbers()` : 번호를 발행하여 반환한다.
- `Validator` : 검증 부분을 담당한다.

### view

- `InputView` : 사용자 입력을 담당한다.
- `OutputView` : 값의 출력을 담당한다.