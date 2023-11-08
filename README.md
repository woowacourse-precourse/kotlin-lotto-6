# 로또 게임

## 기능 목록

- [x] 로또 게임 진행 과정에 따라 state 를 정의한다. - LottoGameState
- [x] 로또를 구매한다.
  - [x] 구매 금액을 입력한다. - LottoGameManager#getMoneyFromUser()
  - [x] 값이 올바르지 않은 형태인 경우, 예외가 발생하여 재입력받는다. Money, LottoGameManager#validatedAsNumber()
  - [x] 금액만큼의 로또를 발행한다. - LottoGenerator#get()
  - [x] 로또 발행 결과를 출력한다. - LottoGameViewer#printResultOfBuyingLotto()
- [x] 추첨을 진행한다.
  - [x] 당첨 번호를 입력한다. - LottoGameManager#pickWinningNumbers()
  - [x] 값이 올바르지 않은 형태인 경우, 예외가 발생하여 재입력받는다. - Lotto, LottoGameManager#validatedAsNumbers()
  - [x] 보너스 번호를 입력한다. - LottoGameManager#pickBonusNumber()
  - [x] 값이 올바르지 않은 형태인 경우, 예외가 발생하여 재입력받는다. - Winning, LottoGameManager#validatedAsNumber()
- [x] 당첨 결과가 나온다.
  - [x] 당첨 기준에 따른 결과를 산출한다. - WinningResultGenerator#get()
  - [x] 당첨 기준별로 내역을 구분해 출력한다. - LottoGameViewer#printWinningsByCountInGroup()
  - [x] 총 수익률을 출력한다. - LottoGameViewer#printWinningMargin()

## 기능 요구 사항

로또를 구매하고 당첨 번호를 입력받은 뒤, 당첨 기준에 따라 결과를 출력하는 프로그램입니다.

- 로또의 숫자 범위는 1 ~ 45 이다.
- 로또 숫자(당첨 번호 포함)는 서로 중복되지 않는다.
- 로또 1장의 가격은 1,000 원 이다.
- 로또 구매 시, 발행된 로또 목록을 오름차순으로 정렬하여 출력한다.
- 당첨 기준은 다음과 같다. (금액 단위: 원)
  - 1등: 6개 번호 일치 / 20 억
  - 2등: 5개 번호 + 보너스 번호 일치 / 3000 만
  - 3등: 5개 번호 일치 / 150 만
  - 4등: 4개 번호 일치 / 5 만
  - 5등: 3개 번호 일치: 5 천
- 당첨 결과는 당첨 기준별 해당 내역을 출력하며, 총 수익률을 포함한다.

## 예외 상황

기본적으로 해당 프로그램은 모든 예외 처리가 진행되어, <u>__최종 결과가 출력되기 전까지 프로그램이 종료되지 않아야 합니다.__</u>

### 예외 상황 목록

해당 프로그램에서는 사용자가 값을 잘못 입력한 경우에만 예외가 발생한다.

- 공통
  - 입력값이 공백인 경우
  - 입력값이 숫자의 형태가 아닌 경우(구분자 쉼표(',') 제외)
  - 여러 값을 입력할 때 구분자 쉼표(',') 가 없는 경우

- 구매 금액
  - 금액이 0 인 경우
  - 금액이 1000 으로 나누어 떨어지지 않는 경우
- 로또 번호
  - 번호의 개수가 6 개가 아닌 경우
  - 1 부터 45 이외의 숫자인 경우
  - 중복되는 번호가 존재할 경우
- 당첨 번호
  - 로또 번호 예외 사항에 해당하는 경우
- 보너스 번호
  - 1 부터 45 이외의 숫자인 경우
  - 당첨 번호와 중복되는 숫자인 경우