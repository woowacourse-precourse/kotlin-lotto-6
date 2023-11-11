# ✅ 구현할 기능 목록

### 1️⃣ 사용자로부터 구입금액을 입력받는 기능

- [x] 구입금액 입력 요청 문구를 출력한다.
- [x] Console.readLine()을 활용하여 문자열을 입력받는다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
    - [x] ❗️ [예외사항] 잘못된 형식을 입력한 경우
    - [x] ❗️ [예외사항] 구입금액이 1000으로 나누어 떨어지지 않는 경우
- [x] 에러 메시지를 출력하고, 예외가 발생한 부분부터 다시 입력받는다.

### 2️⃣ 로또를 발행하는 기능

- [x] pickUniqueNumbersInRange()를 활용하여 로또를 생성한다.
- [x] (구입금액 / 1000) 개의 로또를 생성한다.

### 3️⃣ 발행한 로또 수량 및 번호를 출력하는 기능

- [x] 발행한 로또 수량을 출력한다.
- [x] 로또 번호를 오름차순으로 출력한다.

### 4️⃣ 사용자로부터 당첨 번호를 입력받는 기능

- [x] 당첨 번호 입력 요청 문구를 출력한다.
- [x] Console.readLine()을 활용하여 문자열을 입력받는다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
    - [x] ❗️ [예외사항] 잘못된 형식을 입력한 경우
    - [x] ❗️ [예외사항] 당첨 번호가 6개가 아닌 경우
    - [x] ❗️ [예외사항] 당첨 번호가 범위를 벗어난 경우 (1 ~ 45)
    - [x] ❗️ [예외사항] 당첨 번호가 중복되었을 경우
- [x] 에러 메시지를 출력하고, 예외가 발생한 부분부터 다시 입력받는다.

### 5️⃣ 사용자로부터 보너스 번호를 입력받는 기능

- [x] 보너스 번호 입력 요청 문구를 출력한다.
- [x] Console.readLine()을 활용하여 문자열을 입력받는다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨다.
    - [x] ❗️ [예외사항] 잘못된 형식을 입력한 경우
    - [x] ❗️ [예외사항] 보너스 번호가 범위를 벗어난 경우 (1 ~ 45)
    - [x] ❗️ [예외사항] 보너스 번호가 당첨 번호와 중복되었을 경우
- [x] 에러 메시지를 출력하고, 예외가 발생한 부분부터 다시 입력받는다.

### 6️⃣ 로또 번호와 당첨 번호를 비교하여 당첨 통계를 반환하는 기능

- [x] 모든 로또를 당첨 번호, 보너스 번호와 비교한다.
- [x] 비교한 결과를 통해 등수를 판별한다.

### 7️⃣ 당첨 내역과 수익률을 출력한다.

- [x] 결과에 따라 당첨 통계를 출력한다.
- [x] 당첨 통계의 당첨 금액과 구입 금액을 비교하여 수익률을 계산한다.
- [x] 수익률을 출력한다. (소수점 둘째 자리에서 반올림)

# 🚀 Domain 클래스 목록

## Lotto

로또 번호를 나타내는 클래스

    - init {} : 입력된 숫자를 검증하는 기능
    - hasNumber(number: Int) : 주어진 숫자가 로또 번호에 포함되는지를 확인하는 기능
    - getNumbers() : 로또의 숫자들을 반환하는 기능
    - toString() : 로또 번호를 오름차순으로 정렬하여 문자열 형태로 반환하는 기능

## WinningLotto

당첨 로또를 나타내는 클래스

    - countMatchedNumbers(lotto: Lotto) : 로또와 당첨 로또를 비교하여 일치한 개수를 반환하는 기능
    - hasBonusNumber(lotto: Lotto) : 로또와 보너스 번호를 비교하여 일치 여부를 반환하는 기능

## Rank

당첨 등수와 등수에 따른 상금 및 메시지를 담는 열거형 클래스

    - getMessage(count: Int) : 일치한 숫자의 개수에 따라 해당 등수와 개수를 나타내는 메시지를 반환하는 기능
    - getPrize(rank: Rank) : 주어진 등수에 따라 상금을 반환하는 기능
    - getRank(matchedCount: Int, bonusMatch: Boolean) : 일치한 숫자와 보너스 번호 일치 여부로 등수를 반환하는 기능

## LottoResult

로또 게임 결과를 나타내는 클래스

    - getRankCount(rank: Rank) : 주어진 등수에 따라 당첨 횟수를 반환하는 기능
    - updateCount(rank: Rank) : 주어진 등수에 따라 당첨 횟수를 증가하는 기능
    - toString() : 로또 결과를 문자열로 반환하는 기능

## LottoMachine

로또 기계를 나타내는 클래스

    - generateNumbers() : pickUniqueNumbersInRange()를 활용하여 난수 리스트를 반환하는 기능
    - createLotto() : 중복되지 않는 6개의 숫자로 이루어진 로또 객체를 생성하여 반환하는 기능
    - issueLottos() : 구입금액에 따라 여러 개의 로또를 생성하여 리스트로 반환하는 기능
    - calculateResult(lottos: List<Lotto>, winningLotto: WinningLotto) : 당첨 로또와 로또 리스트를 통해 결과를 계산하여 반환하는 기능
    - getRateOfReturn(result: LottoResult) : 총 상금을 통해 수익률을 계산하여 반환하는 기능
    - calculateTotalPrize(result: LottoResult) : 당첨 결과를 통해 총 상금을 계산하는 기능

## LottoProgram

로또 게임을 진행하는 클래스

    - run() : 로또 게임을 진행하는 기능
    - purchaseLottos() : 여러 개의 로또를 발행하고, 발행한 로또 정보를 출력하는 기능 
    - drawWinningLotto() : 당첨 로또를 생성하는 기능
    - displayOutcome() : 당첨 통계 및 수익률을 계산하고, 출력하는 기능

# 💻 UI 클래스 목록

## InputManager

사용자로부터 값을 입력받고 검증하는 클래스

    - getInputMoney() : 사용자로부터 구입금액을 입력받는 기능
    - getWinningNumbers() : 사용자로부터 당첨 번호를 입력받는 기능
    - getBonusNumber(winningNumber: List<Int>) : 사용자로부터 보너스 번호를 입력받는 기능
    - getValidatedInput(promptMessage: String, validate: (String) -> Unit) : 올바른 입력 값이 입력될 때 까지 반복하는 기능
    - readString() : readLine을 활용하여 사용자로부터 문자열을 입력받는 기능

## OutputManager

화면에 출력하는 역할을 수행하는 클래스

    - printPromptMessage() : 사용자로부터 입력 요청하는 메시지를 출력하는 기능
    - printLottosReceipt(lottos: List<Lotto>) : 로또의 수와 번호들을 출력하는 기능
    - printWinningStatistics(result: LottoResult) : 당첨 통계를 출력하는 기능
    - printRateOfReturn(rateOfReturn: Double) : 총 수익률을 출력하는 기능

# ⛔️ validator 클래스 목록

## InputMoneyValidator

구입 금액의 유효성을 검증하는 클래스

    - validate(inputMoney: String) : 구입 금액을 검증하는 기능
    - parseToInt(inputMoney: String) : 문자열을 정수로 변환하고, 실패할 경우 IllegalArgumentException 을 발생시키는 기능
    - requireAmountDivisibleBy1000(moneyAmount: Int) : 구입 금액이 1000원 단위로 나누어 떨어지는 지 검증하는 기능

## WinningNumbersValidator

당첨 번호의 유효성을 검증하는 클래스

    - validate(inputMoney: String) : 당첨 번호를 검증하는 기능
    - splitAndParseToIntList(input: String) : 문자열을 쉼표로 분리하여 정수 리스트로 변환하고, 실패할 경우 IllegalArgumentException 을 발생시키는 기능
    - requireSixNumbers(numbers: List<Int>) : 당첨 번호의 개수를 검증하는 기능
    - requireValidNumberRange(numbers: List<Int>) : 당첨 번호의 범위를 검증하는 기능
    - requireUniqueNumbers(numbers: List<Int>) : 당첨 번호가 중복되지 않는지 검증하는 기능

## BonusNumberValidator

보너스 번호의 유효성을 검증하는 클래스

    - validate(inputBonusNumber: String, winningNumbers: List<Int>) : 보너스 번호를 검증하는 기능
    - parseToInt(inputBonusNumber: String) : 문자열을 정수로 변환하고, 실패할 경우 IllegalArgumentException 을 발생시키는 기능
    - requireValidNumberRange(bonusNumber: Int) : 보너스 번호의 범위를 검증하는 기능
    - requireUniqueNumber(bonusNumber: Int, winningNumbers: List<Int>) : 당첨 번호와 중복되지 않는지 검증하는 기능

<br/>

## 📚 3주차 구현 목표

    1. README에 기능 목록 뿐만 아니라 프로젝트에 대한 설명 등을 포함하여 상세히 작성하고, 꾸준히 업데이트 하기 위해 노력한다.
    2. 함수가 한 가지 기능을 하도록 구현하기 위해 노력한다. (함수를 분리하는 기준을 세우자)
    3. 객체의 역할과 책임에 따라 클래스를 분리하고, 작은 단위의 기능부터 테스트 코드를 작성하기 위해 노력한다.
    4. 변수와 메소드, 클래스 등의 의도를 쉽게 파악할 수 있도록 좋은 이름을 짓기 위해 노력한다.