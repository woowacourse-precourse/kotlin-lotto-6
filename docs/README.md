# 구현 기능 목록

## 필요한 기능 목록

- [ ] 중복되지 않는 6개 숫자 생성
- [ ] 로또 구입 금액을 입력
- [ ] 구입 금액에 해당하는 로또 발행
- [ ] 당첨 번호와 보너스 번호 입력
- [ ] 구매 번호와 당첨번호 비교
- [ ] 당첨 내역 및 수익률 정리
- [ ] 잘못된 입력 예외 처리

## 구현할 클래스

- InputView
  - 사용자 입력을 처리할 클래스
  - 단순 공백 문자 포함으로는 예외를 발생시키지 않음
  - 구입 금액을 입력받을 함수 `inputAmount(): Int`
    - 정수가 아닌 입력이 있을경우 예외
    - 입력받은 정수가 1000으로 나눠지지 않는경우 예외
    - 입력 값을 1000으로 나눈 몫 반환
  - 당첨 번호를 입력받을 함수 `inputWinningNum(): List<Int>`
      - 쉼표(,)로 구분되는 6개의 정수를 입력
      - 쉼표(,)와 공백문자를 제외한 숫자가 아닌 입력이 있을경우 예외 발생
      - 입력한 정수가 6개가 아닌경우 예외
      - 입력한 정수들에 중복이 있는 경우 예외
      - 입력한 정수들중 1~45범위를 벗어난 정수가 있는 경우 예외
      - 정수들의 리스트를 오름차순으로 정렬하여 반환
  - 보너스 번호 하나를 입력받을 함수 `inputBonusNum(): Int`
    - 정수가 아닌 입력이 있을경우 예외
    - 1~45범위를 벗어난 정수인 경우 예외
    - 입력한 정수 반환
- OutputView
  - 출력을 처리할 클래스
  - 단순 출력
    - "구입 금액을 입력해 주세요." `amountMessage()`
    - "당첨 번호를 입력해 주세요." `winningMessage()`
    - "보너스 번호를 입력해 주세요." `bonusMessage()`
    - "당첨 통계" `printrEnd()`
    - "---" `printHorizon()`
  - 구매 결과 출력 `printPurchase(game: Int, numbers: List<List<int>>)`
    - 구매 횟수 출력 `printNumberOfGame(game: Int)`
    - 게임 구매 결과 출력 `printPurchaseAGame(number: List<int>)`
  - 게임 결과 출력 `printGameResult()`
    - 등수별 갯수 출력 `printRank(ranks: List<int>)`
    - 수익률 출력 `printBenefit(rate: Float)`
- Lotto
  - 객체 생성시 중복 없는 6개의 번호 입력 `numers: List<int>`
  - 구매한 6개의 번호를 출력할 함수 `printLotto()`
  - 당첨 숫자 갯수를 반활할 함수 `getCorrect(winnings: List<int>): Int`
  - 보너스 번호 당첨 유무를 확인할 함수 `checkBouns(bonus: Int): Boolean`
- LottoController
  - Lotto 객체들을 컨트롤할 클래스
  - 객체 생성시 구매할 게임의 갯수를 입력
  - 게임 갯수만큼의 Lotto객체 생성 `lottos: List<Lotto>`
  - 당첨번호 입력 `setWinnigs()`
  - 당첨 통계 계산 `calcRank(): List<Int>`
  - 수익률 계산 `calcBenefit(): Float`