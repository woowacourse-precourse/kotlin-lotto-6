### 예외처리 메시지(ExceptionMessage)
- 상수
  - [x] 중복된 번호 예외처리 메시지(NOT_DUPLICATED_NUMBER)
  - [x] 잘못된 로또 번호 예외처리 메시지(NOT_LOTTO_NUMBER_IN_RANGE)
  - [x] 입력한 값이 숫자가 아닌 경우 예외처리 메시지(NOT_NUMBER)
  - [x] 입력한 가격이 로또 구매를 할 수 없을 경우 예외처리 메시지(NOT_CORRECT_PRICE)
  - [x] 로또 번호의 개수가 6개가 아닐 경우 예외처리 메시지(NOT_CORRECT_SIZE)
  - [x] 당첨 번호와 보너스 번호가 중복될 경우 예외처리 메시지(BONUS_NUMBER_DUPLICATED)
  
### 로또(Lotto)
- 프로퍼티
  - [x] 로또 숫자(numbers)
- 생성자
  - [x] 로또 숫자가 6개가 아닐 경우에 대한 예외처리
  - [x] 로또 숫자가 중복된 숫자가 있을 경우에 대한 예외처리
  - [x] 로또 숫자가 1에서 45사이의 숫자가 아닐 경우에 대한 예외처리
- 메서드
  - [x] 로또 숫자 리턴 함수(getNumbers)
  - [x] 로또 숫자 문자열 생성(lottoNumberToString)

### 통계 계산(LottoCalculator)
- 메서드
  - [x] 구입 금액에 대한 로또 개수 계산(calLottoCount)
  - [x] 당첨 숫자와 로또 숫자의 일치하는 숫자 개수 계산(calWinningNumberMatchCount)
  - [x] 보너스 숫자와 로또 숫자의 일치하는 숫자 개수 계산(calBonusNumberMatchCount)
  - [x] 로또가 가지고 있는 번호에 대한 당첨숫자, 보너스 숫자의 일치하는 숫자를 계산(calMatchCount)
  - [x] 당첨 통계 수치를 계산(calWinningRate)
  - [x] 총 수익률 계산(calProfitRate)

### 로또 생성(LottoFactory)
- 메서드
  - [x] 로또 생성(createLotto)
  - [x] 갯수에 따른 로또 생성(createLottoByCount)

### 로또게임(LottoGame)
- 프로퍼티
  - [x] UserInput 객체(userInput)
  - [x] LottoCalculator 객체(lottoCalculator)
  - [x] LottoFactory 객체(lottoFactory)
  - [x] LottoGamePrinter 객체(lottoGamePrinter)
- 메서드
  - [x] 로또 게임 실행(gamePlay)

### 로또게임 메시지(LottoGameMessage)
- 상수
  - [x] 구입금액 입력 메시지(PURCHASE_AMOUNT_INPUT)
  - [x] 로또 수량 메시지(LOTTO_NUMBER)
  - [x] 당첨 번호 입력 메시지(WINNING_NUMBER_INPUT)
  - [x] 보너스 번호 입력 메시지(BONUS_NUMBER_INPUT)
  - [x] 당첨 통계 메시지(WINNING_RESULT)
  - [x] 3개 일치 메시지(THREE_MATCHED)
  - [x] 4개 일치 메시지(FOUR_MATCHED)
  - [x] 5개 일치 메시지(FIVE_MATCHED)
  - [x] 5개 일치, 보너스 볼 일치 메시지(FIVE_BONUS_MATCHED)
  - [x] 6개 일치 메시지(SIX_MATCHED)
  - [x] 총 수익률 메시지(TOTAL_RATE)

### 로또 출력(LottoGamePrinter)
- 메서드
  - [X] 갯수에 다른 로또 번호 출력(showLottoList)
  - [X] 당첨 통계 출력(showWinningRate)

### 당첨 가격(LottoPrice)
- 상수
  - [X] 3개 일치 가격(THREE_MATCHED)
  - [x] 4개 일치 가격(FOUR_MATCHED)
  - [x] 5개 일치 가격(FIVE_MATCHED)
  - [x] 5개 일치, 보너스 일치 가격(FIVE_BONUS_MATCHED)
  - [x] 6개 일치 가격(SIX_MATCHED)
- 메서드
  - [X] 갯수에 따른 가격 계산(calculatePrice)

### 로또 일치 데이터(MatchedData)
- 프로퍼티
  - [X] 당첨 숫자 일치 갯수(winningNumberMatchedCount)
  - [X] 보너스 숫자 일치 갯수(bonusNumberMatchedCount)

### 사용자 입력(UserInput)
- 프로퍼티
  - [X] UserInputValidator 객체(userInputValidator)
- 메서드
  - [x] 구입 금액 입력(purchasedAmountInput)
  - [x] 당첨 번호 입력(winningPriceInput)
  - [x] 보너스 번호 입력(bonusNumberInput)

### 사용자 입력 판별(UserInputValidator)
- 메서드
  - [X] 숫자 판별(checkNumber)
  - [x] 1000의 배수인지 판별(checkDivideBy1000)
  - [x] 1에서 45사이의 숫자인지 판별(checkNumberInRange)
  - [x] 6개의 숫자가 입력되었는지 판별(checkNumberListSize)
  - [x] 6개의 숫자가 모두 숫자인지 판별(checkNumberInList)
  - [x] 6개의 숫자에 중복된 숫자가 있는지 판별(checkDuplicatedNumberInList)
  - [x] 당첨 숫자와 보너스 숫자가 중복되는지 판별(checkDuplicatedNumber)

### 당첨 갯수 데이터(UserInputValidator)
- 프로퍼티
  - [X] 3개 일치 갯수(threeMatchedCount)
  - [X] 4개 일치 갯수(fourMatchedCount)
  - [X] 5개 일치 갯수(fiveMatchedCount)
  - [X] 5개 일치, 보너스 일치 갯수(fiveAndBonusMatchedCount)
  - [X] 6개 일치 갯수(sixMatchedCount)