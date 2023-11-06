## 기능 목록

- 게임 시작 전
    - [x]  구입 안내 메세지 출력한다. -`OutputView#printGameStartMessage()`
    - [x]  로또 구매 가격을 입력한다. - `InputView#getValidIntegerInput()`
        - [x]  숫자가 아니면 예외처리한다. - `Validator#validateInteger()`
        - [x]  입력이 널값이면 예외처리한다. - `Validator#validateNotNull()`
        - [x]  로또 가격의 범위가 유효하지 않다면 예외처리한다. - `Validator#validateRange()`
        - [x]  로또 가격이 1000원 단위가 아니면 예외처리한다. - `Validator#validate1000Unit()`
- 로또 시작
    - [x]  로또 발행 안내 메세지를 출력한다. - `OutputView#printPurchaseCount()`
    - [x]  구매 가격만큼 로또를 발행한다. - `LottoTicket#lottoTicketPublish()`
    - [x]  로또를 구매한 개수만큼 출력한다. - `OutputView#printLottoTicket()`
        - [x]  각 숫자는 중복이 없어야 한다.
        - [x]  각 숫자는 1부터 45까지의 숫자여야 한다.
        - [x]  번호는 오름차순으로 보여줘야 한다.
- 당첨 번호 입력
    - [x]  당첨 번호 입력 안내 메세지를 출력한다. - `OutputView#printLottoPurchaseInfoMessage()`
    - [x]  당첨 번호를 입력한다. - `InputView#getValidLottoInput()`
        - [x]  당첨 번호는 6자리를 입력한다. - `Validator#validateLottoLength()`
        - [x]  당첨 번호에 공백 또는 널값이 들어오면 예외처리한다. - `Validator#validateNotNull()`
        - [x]  숫자가 아닐 시 예외처리한다. - `Validator#validateInteger()`
        - [x]  각 번호가 1부터 45까지의 번호가 아닐 시 예외처리한다. - `Validator#validateLottoRange()`
        - [x]  중복된 숫자가 존재할 시 예외처리 한다. - `Validator#validateLottoUnique()`
    - [x]  보너스 번호를 입력 안내 메세지를 출력한다. - `OutputView#printBonusLottoInfoMessage()`
    - [x]  보너스 번호를 입력한다. - `UserInput#getValidIntegerInput()`
        - [x]  숫자가 아닐 시 예외처리한다. - `Validator#validateInteger()`
        - [x]  당첨 번호와 중복된 숫자를 입력할 시 예외처리한다. - `Validator#validateContain()`
        - [x]  1부터 45까지의 숫자가 아닐 시 예외처리한다. - `Validator#validateNumberRange()`
        - [x]  당첨 번호에 공백 또는 널값이 들어오면 예외처리한다. - `Validator#validateNotNull()`
- 로또 종료
    - [x]  로또 등수를 구한다. - `LottoResult#calculateRanking()`
    - [x]  당첨 통걔를 출력한다. - `OutputView#printLottoStatistics()`
        - [x]  3개부터 6개까지 내림차순으로 출력한다.
    - [x]  로또 수익률을 구한다. - `LottoProfit#calculateRate()`
    - [x]  로또 수익률을 출력한다. - `OutputView#printLottoProfitRate()`
        - [x]  수익률은 소수점 둘째자리에서 반올림한다.(ex 100.0%, 51.5%)

<br>

## 기능 요구사항

- [x]  예외 처리는 IllegalArgumentException을 발생시키고 "[ERROR]”로 시작하는 에러 메세지를 출력한다.
- [x]  에러메세지를 출력하고 그 부분부터 다시 입력받는다.
- [x]  게임 종료 시 `System.exit()` 를 호출하지 않는다.
- [x]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [x]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어야한다.
- [x]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [x]  else를 지양한다.
- [x]  Enum 클래스를 적용해 프로그래밍을 구현한다.
- [x]  핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- [x]  `Lotto` 클래스에 필드를 추가할 수 없다.
- [x]  랜덤값 추출 `camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange` 사용한다.
- [x]  사용자 입력은 `camp.nextstep.edu.missionutils.Console.readLine()` 을 이용한다.

<br>

## 고민인 부분

1. 재 입력을 받을 때에는 입력 안내 메세지도 같이 출력해야할까??

   🌟최종 : 입력 안내 메세지를 같이 출력할 필요는 없어보인다. 요구사항이 에러 메세지를 출력 후 그 부분이라 했기에 입력 부분으로 판단.

2. 검증은 어디서 하는 것이 적당할까?

   → 현재 inputView와 model에서 나눠서 진행하고 있다.

   → 이렇게 하는 방식이 맞을까? 모델 또는 inputview에서 한번에 처리하는 것이 맞을까

   🌟최종 : InputView에서는 최소한의 검증인 널값, 정수 변환 가능 여부만 수행하며, 유효 범위, 중복등은 모델에서 수행한다.


3. Lotto 클래스에서 number의 private를 제거하지 말라 라는 요구사항이 있다.

   → 내가 한 방식에서는 get을 통해서 number에 접근하는데 이것조차 하지 말라는 뜻인가?

   → 그렇다는 것은 Lotto 내부에서 당첨 확인을 하라는 의도인 것인가?

   🌟최종 : `getWinningNumbers()` 를 통하여 받아온다. 아직 정확한 의도를 판단하지는 못하였으나 모델 init 부분에서 검증하는 것으로 검증을 모델에서 하라는 의미로 생각.

4. 검증 부분은 Validator 클래스로 관리하고 있다.

   → 하지만 이렇게 하는 방식이 맞을까?

   → 모델에서 검증하는 부분은 되도록 모델 내부에서 함수를 사용하는 것이 맞지 않을까? 굳이 Validator 클래스로 또 관리해야할까?

   🌟최종 : 모든 검증 코드는 일단 Validator가 관리하며 Model과, View에서 역할에 맞는 검증을 호출하여 사용한다.

5. 보너스번호를 관리하는 좋은 방법이 없을까?

   🌟 최종 : Bonus 클래스를 만들어 보너스 번호를 관리한다. 당첨번호와 보너스번호를 동시에 관리하는 모델 생성을 고려하였으나 모델끼리 의존을 피하고 싶었기에 패스.

6. 현재 MainController 에 너무 많은 로직이 모였다. 어떤식으로 분리하면 좋을까?

   🌟 최종 : Controller 에서 충분히 모델에 있어도 될 로직은 모델로 이동시킴.

7. 2등을 판단할 때 효과적인 방법이 있을까?

   🌟 최종 : `when`문을 통하여 맞힌 개수가 5일때만 if문을 수행. if문에서 보너스번호가 맞으면 1을, 틀리면 2를 반환하도록 구현.

8. 굳이 `print()` 문 안에 있는 문자열도 Constants 로 관리해야하나? (코드리뷰 피드백을 받은 적이 있기도 하고 그렇게 하는 분들이 꽤 많다.)

   🌟 최종 : 상수화 하여 관리하는 것이 오히려 가독성을 해칠 것 같다 판단하였고 `print()` 자체에 변수랑 같이 사용되는 부분이 많아 따로 상수화하지 않음.

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
│   └── Purchase.kt
├── util
│   ├── Constants.kt
│   ├── LottoException.kt
│   ├── Validator.kt
│   └── Winnings.kt
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
    - `number: Int` : 보너스 번호를 가지고 있는 변수이다.
    - `checkUniqueNumber()` : 보너스 번호가 중복된 번호가 아닌지 확인한다.
- `Lotto` : 당첨 번호(6개)를 관리한다.
    - `numbers: List<Int>` : 당첨 번호를 가지고 있는 리스트이다.
    - `getWinningNumbers()` : 당첨 번호 리스트를 가져온다.
- `LottoProfit` : 수익률을 계산하고 관리한다.
    - `rate: String` : 소수점 2번째 자리에서 반올림하여 소수점 첫째 자리까지 구한 수익률을 가지고 있는 변수이다.
    - `getTotalGain()` : 총 당첨 금액을 구하여 반환한다.
    - `calculateRate()` : 수익률을 계산한다.
- `LottoRankings` : 등수 관련 리스트를 관리한다
    - `rank: List<Int>` : 랭크를 가지고 있는 리스트이다. (인덱스 0이 1등, 인덱스4가 5등)
    - `addRanking()` : 등수에 맞는 인덱스의 값에 1을 추가한다.
- `LottoResult` : 등수를 구한다.
    - `calculateRanking()` : 등수에 맞는 인덱스 번호를 반환한다.
    - `containBonusNumber()` : 맞힌 갯수가 5일 시 보너스 번호를 확인하여 등수에 맞는 인덱스를 반환한다.
- `LottoTicket` : 발행된 번호들을 2차원 배열로 관리한다.
    - `numbers: List<List<Int>>` : 발행된 번호들을 가지고 있는 2차원 리스트이다.
    - `addNumbers()` : 발행 번호 관리 리스트에 발행된 번호를 추가한다.
    - `publicOneTicket()` : 로또 한장을 발행한다.
    - `lottoTicketPublish()` : 로또를 구매 가격만큼 발행한다.
- `Purchase` : 로또 구매 가격과 로또 발행 횟수를 관리한다.
    - `price: Int` : 로또 구매 가격을 가지고 있는 변수이다.
    - `count: Int` : 로또 발행 횟수를 가지고 있는 변수이다.

### util

- `Exception` : 예외 처리 메세지를 관리한다.
- `Constants` : 불변값을 관리한다.
- `Validator` : 검증 부분을 담당한다.
- `Winnings` : 로또 당첨금을 관리한다.

### view

- `InputView` : 사용자 입력을 담당한다.
- `OutputView` : 값의 출력을 담당한다.
