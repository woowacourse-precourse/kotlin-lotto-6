<img src="https://github.com/Sheep1sik/Dicee/assets/88019314/bf567b0d-417a-46b6-b290-6a415a80f602" width="800" height="150"/>

# 미션 - 로또

![GIFMaker_me (2)](https://github.com/woowacourse-precourse/kotlin-racingcar-6/assets/88019314/89531fa0-eb65-4281-a8e6-74ee8ad9165c)

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만들고, 기능 단위로 커밋 하는 방식으로 진행한다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.


## 💡 구현할 기능
---
- [X] 게임 진행 멘트를 출력할 출력문
- [X] 로또 구입 금액을 입력받는다
  - [X] 만약 사용자가 입력을 잘못하면 예외처리와 함께 [ERROR] 메세지 출력 후 재입력  
    - [X] 로또 구입 금액이 1000원으로 나누어 떨어지지 않는 경우 예외처리 **( [ERROR] 입력된 금액이 1000원 단위가 아닙니다. 1000원, 2000원, 3000원과 같이 1000원 단위로 입력해 주세요. )**
    - [X] 로또 구입 금액에 문자가 포함되었다면 예외처리 **( [ERROR] 입력값에 숫자 이외의 문자가 포함되어 있습니다. 숫자만 입력해 주세요. )**
    - [X] 번호가 입력되지 않을시 예외처리 **( [ERROR] 입력되지 않았습니다. 다시 입력해주세요. )**
    - [X] 나누어 떨어진다면 몫을 저장 (구매 갯수)


<br>

![image](https://github.com/woowacourse-precourse/kotlin-racingcar-6/assets/88019314/f9d40765-3e02-4664-b8b2-1281878fbd5e)

---
<br>

- [X] 구매 갯수(구입 금액과 1000원을 나누어 떨어진 몫)만큼 로또의 랜덤 숫자를 생성한다.
  - [X] 로또의 랜덤 숫자(1~45)를 부여한다
  - [X] 로또의 랜덤 숫자를 오름차순으로 정렬한다.
  - [X] 랜덤 로또번호를 저장한다.

<br>

![image](https://github.com/woowacourse-precourse/kotlin-racingcar-6/assets/88019314/e4efa6bc-805c-4a03-9b4b-0a7484e4cd01)


---

<br>

- [X] 당첨 번호를 입력 받는다. 이때 당첨 번호는 쉼표를 기준으로 구분한다.
  - [X] 입력된 당첨 번호를 검증한다.
  - [X] 만약 사용자가 입력을 잘못하면 예외처리와 함께 [ERROR] 메세지 출력 후 재입력
    - [X] 6개 미만이거나 6개 초과일시 예외처리 **( [ERROR] 6개의 숫자만 입력해 주세요. )**
    - [X] 당첨 번호가 1~45까지 포함이 안되면 예외처리 **( [ERROR] 숫자의 범위는 1 ~ 45까지 입니다. 숫자의 범위에 맞게 입력해주세요. )**
    - [X] 중복일시 예외처리 **( [ERROR] 번호에 중복된 숫자가 포함되어 있습니다. 숫자가 중복되지 않게 입력해주세요. )**
    - [X] 번호가 입력되지 않을시 예외처리 **( [ERROR] 입력되지 않았습니다. 다시 입력해주세요. )**

<br>

![image](https://github.com/woowacourse-precourse/kotlin-racingcar-6/assets/88019314/531d6e87-342a-4c3e-9b82-9eedc1ad8754)

---

<br>

- [X] 보너스 번호를 입력 받는다.
- [X] 만약 사용자가 입력을 잘못하면 예외처리와 함께 [ERROR] 메세지 출력 후 재입력
  - [X] 보너스 번호가 당첨 번호랑 중복이 되는지 확인한다.
    - [X] 중복일시 예외처리 **( [ERROR] 당첨 번호랑 보너스 번호는 서로 중복되면 안됩니다. )**
    - [X] 번호가 입력되지 않을시 예외처리 **( [ERROR] 입력되지 않았습니다. 다시 입력해주세요. )**

<br>

![image](https://github.com/woowacourse-precourse/kotlin-racingcar-6/assets/88019314/96fafca8-b947-445d-b8fc-f21955c6612b)

---

<br>

- [X] 1등 - 5등 까지의 조건이 일치하는지 확인한다.
- [X] 각 조건에 맞는 변수에 저장한다.
- [X] 당첨 통계를 출력한다.

<br>

![image](https://github.com/woowacourse-precourse/kotlin-racingcar-6/assets/88019314/f1f8a398-fa92-41cd-ab17-be5e05660b42)

---

<br>

- [X] 수익률을 출력한다.
    - [X] 수익률을 계산한다. ( 수익률은 소수점 둘째 자리에서 반올림한다. )

<br>

![image](https://github.com/woowacourse-precourse/kotlin-racingcar-6/assets/88019314/11d44dbb-100a-4ec5-a076-c8c56cf84d00)

---
<br>

## 📚구현 함수별 역할 설명

### 📕 controller
#### LottoGameController
**getPurchasedAmount():** 구매 금액을 입력받고 유효성을 검사한 후 정수로 반환하는 역할을 합니다.

**calculateTicketCount():** 구매 금액을 통해 구매할 로또 티켓 수를 계산하는 역할을 합니다.

**generateRandomLottoLists():** 무작위 로또 번호 리스트를 생성하는 역할을 합니다.

**getWinningNumbers():** 당첨 번호를 입력받고 유효성을 검사한 후 정수 리스트로 반환하는 역할을 합니다.

**getBonusNumber():** 보너스 번호를 입력받고 유효성을 검사한 후 문자열로 반환하는 역할을 합니다.

**playGame():** 게임을 시작하며 구매 금액, 티켓 수, 랜덤 로또 번호, 당첨 번호, 보너스 번호를 사용하여 게임을 진행하는 역할을 합니다.

<br>
<br>

### 📗 model
**Bonus Class :** 주어진 로또 번호 목록과 보너스 번호를 검증하고 저장하는 클래스  

**Lotto Class :** 주어진 로또 번호 목록을 검증하고 저장하는 클래스  

**Lotto Rank enum Class :** 열거형 클래스는 로또 당첨 순위를 나타내며, 해당 순위에 해당하는 당첨 횟수를 추적하는 역할  

<br>
<br>

### 📒 view

#### InputView
**purchaseAmountMessage():** 구입금액을 입력받는 메시지를 출력하고 사용자 입력을 받습니다.

**enterWinningNumbersMessage():** 당첨 번호를 입력받는 메시지를 출력하고 사용자 입력을 받습니다.

**enterBonusNumbersMessage():** 보너스 번호를 입력받는 메시지를 출력하고 사용자 입력을 받습니다.

#### OutputView
**ticketCountMessage(ticket: Int):** 구매한 로또 티켓 수를 출력합니다.

**winningStatisticsMessage():** 당첨 통계 정보를 출력합니다. 각 당첨 등수별로 당첨 횟수를 출력합니다.

**profitPercentageMessage(profitPercentage: Double):** 총 수익률을 출력합니다.

**randomLottoLists(lottoList: MutableMap<Int, List<Int>>):** 구매한 랜덤 로또 번호 목록을 출력합니다.

<br>
<br>
 
### 📘 Constants
애플리케이션에서 사용되는 상수 값을 정의

<br>
<br>
 
### 📙 LottoGameService
**calculateLottoPurchaseQuantity:** 구매 금액을 받아 구매 가능한 로또 티켓의 수를 계산하는 함수.

**lottoNumberGenerator:** 주어진 티켓 수에 대한 랜덤 로또 번호 리스트를 생성하는 함수.

**calculateWinningStatistics:** 입력한 로또 번호와 보너스 번호를 기반으로 당첨 통계를 계산하고 저장하는 함수.

**calculateProfitPercentage:** 구매 금액과 당첨 통계를 기반으로 수익률을 계산하는 함수.

**convertStringToList:** 입력된 로또 번호 문자열을 파싱하여 리스트로 변환하는 함수.

<br>
<br>
 
### 📓 Validator
**isUserPurchaseAmountCheck:** 구입 금액의 유효성을 검사하는 함수로, 금액이 비어 있거나 숫자가 아니거나 1000원 단위로 나누어지지 않는 경우 예외를 발생시킵니다.

**isUserWinningNumbersCheck:** 입력된 로또 번호의 유효성을 검사하는 함수로, 로또 번호의 개수, 범위, 중복 여부를 확인하고 문제가 있으면 예외를 발생시킵니다.

**isUserBonusNumberCheck:** 보너스 번호의 유효성을 검사하는 함수로, 보너스 번호가 비어 있거나 숫자가 아니거나 중복되거나 음수 또는 범위를 벗어나는 경우 예외를 발생시킵니다.


---
<br>

## 📝 지켜야할 사항
- [X] **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [X] **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
- [X] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [X] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [X] else를 지양한다.
- [X] Enum 클래스를 적용해 프로그래밍을 구현한다.
- [X] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- [X] 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.
- [X] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [X] 주어진 Lotto 클래스 사용
    - 제공된 `Lotto` 클래스를 활용해 구현해야 한다.
    - `numbers`의 접근 제어자인 private을 변경할 수 없다.
    - `Lotto`에 필드를 추가할 수 없다.
    - `Lotto`의 패키지 변경은 가능하다.

    ```kotlin
    class Lotto(private val numbers: List<Int>) {
        init {
            require(numbers.size == 6)
        }

        // TODO: 추가 기능 구현
    }
    ```
- [ ] [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
---

<br>

## 📝 피드백 반영
- [ ] 요구사항을 정확히 준수한다.
- [X] 커밋 메시지를 의미 있게 작성한다
- [X] git을 통해 관리할 자원에 대해서도 고려한다
- [ ] Pull Request를 보내기 전 브랜치를 확인한다
- [ ] PR을 한 번 작성했다면 닫지 말고 추가 커밋을 한다
- [X] 이름을 통해 의도를 드러낸다
- [X] 축약하지 않는다
- [X] 공백도 코딩 컨벤션이다
- [X] 공백 라인을 의미 있게 사용한다
- [X] space와 tab을 혼용하지 않는다
- [X] 의미 없는 주석을 달지 않는다
- [X] IDE의 코드 자동 정렬 기능을 활용한다
- [X] Kotlin에서 제공하는 API를 적극 활용한다
- [X] README.md를 상세히 작성한다
- [X] 기능 목록을 재검토한다
- [X] 기능 목록을 업데이트한다
- [X] 값을 하드 코딩하지 않는다
- [X] 구현 순서도 코딩 컨벤션이다

    ```
    class A {
    프로퍼티

    init 블록

    부 생성자

    메서드

    동반 객체
    }
    ```

- [X] 변수 이름에 자료형은 사용하지 않는다
- [X] 한 함수가 한 가지 기능만 담당하게 한다
- [X] 함수가 한 가지 기능을 하는지 확인하는 기준을 세운다
- [ ] 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다
- [X] 처음부터 큰 단위의 테스트를 만들지 않는다
    - 큰 단위의 테스트
      자동차경주를 시작해서 사용자가 이름, 진행 횟수를 입력하면, 게임을 진행한 후 그 결과를 알려준다.
    - 작은 단위의 테스트
      무작위 값이 4 이상이면 자동차가 전진한다.
      무작위 값이 3 이하이면 자동차가 전진하지 않는다.
