## 기능 요구 사항
로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
      로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
      로또 1장의 가격은 1,000원이다.
      당첨 번호와 보너스 번호를 입력받는다.
      사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
      사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
      Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

## 기능 목록
- [O] 로또 구매 금액을 입력 : InputValue#inputLottoMoney()
  - [O] 양의 정수를 입력하지 않으면 오류 : CheckError#checkInputPositiveInt()
  - [O] 1000원으로 나누어 떨어지지 않으면 오류 : CheckError#checkCanDivide1000()

- [] 당첨 번호를 입력 : InputValue#inputWinningNumber()
  - [O] 당첨 번호 숫자 모두가 양의 정수를 입력하지 않으면 오류 : CheckError#checkOnlyNumber()
  - [O] 당첨 번호 숫자 모두 1~45 사이를 입력하지 않으면 오류 : CheckError#checkNumber1to45()
  - [O] 6개의 숫자를 입력하지 않을 경우 오류 : CheckError#checkInputSixNumbers()
  - [O] 당첨 번호가 중복될 경우 오류 : CheckError#checkNonOverlapNumber()
  
- [] 보너스 번호를 입력 : InputValue#inputBonusNumber()
  - [] 보너스 번호와 당첨 번호가 중복될 경우 오류 : CheckError#checkNotOverlapNumber() 중복 사용
  - [] 1~45 이외의 숫자 혹은 문자가 입력될 경우 오류 : CheckError#checkOnlyNumber1to45() 중복 사용
  - [] 1개의 숫자를 입력하지 않을 경우 오류 : CheckError#checkInputOneNumbers()
  
- [] 구매 금액에 맞는 복권의 개수 계산 : MakeLotto#calculateCountingLotto()
- [] 각 복권마다 중복되지 않는 번호 6개 생성 : MakeLotto#createNonOverlapSixNumbers()
- [] 생성된 복권 번호 오름차순으로 변경 : MakeLotto#changeAscendingLottoNumbers()

- [] 각 로또마다 당첨 번호 일치 개수 확인 : Calculator#compareCountingMatchedWinningNumber()
- [] 각 로또마다 보너스 번호 일치 확인 : Calculator#compareCountingMatchedBonusNumber()
- [] 총 당첨 금액 대비 수익률 계산 : Calculator#calculateRateReturn()
- 
- [] 당첨 1등 ~ 6등 까지 계산하는 기능을 Enum으로 구현한다. DivideStandard1to6 클래스 활용
- [] 일치 개수 만큼 당첨 금액 계산 : DivideStandard1to6#calculateWinningAmount()

- [] 로또 클래스 생성 : main 함수에서 MakeLotto클래스를 통해 생성
- [] 복권 클래스 package lotto#Lotto# 이미 존재

- [] 당첨 숫자 클래스 WinningAndBonusNumber#