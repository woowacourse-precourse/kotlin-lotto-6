기능 목록
---
---
### 로또 게임 컨트롤러 - LottoGameController
- [x] 로또 게임 시작 기능 - startLottoGame() O
- [x] 당첨 번호 및 보너스 번호를 생성하는 기능() O
- [x] 구매한 로또를 출력하는 기능 - printLotto() O

### 로또: Lotto
- [x] 로또 번호 출력 - printNumbers() O
- [x] 로또 번호 비교 - compareLottoNumber() O
- [x] 보너스 번호와 자신의 로또 번호를 비교하는 기능 - compareBonusNumber() O
- [x] 로또의 숫자 리스트를 반환하는 기능 - getNumbers() O

### 판매자: Seller - O
- [x] 로또 판매 기능 - sellLotto() O

### 당첨 번호: WinningNumber - O
- [x] 당첨 번호 getter - getWinningNumbers() O
- [x] 보너스 번호 getter - getBonusNumber() O

### 자신의 로또 번호 생성: NumberGenerator - O
- [x] 랜덤한 숫자 생성 - generateNumbers() O

### 입력: Input - O
- [x] 로또 구입 금액 입력 - inputMoney() O
- [x] 당첨 로또 번호 입력 - inputWinningNumber() O
- [x] 보너스 번호 입력 - inputBonusNumber() O

### 등수: Grade
- [x] grade map 반환 - getLottoGradeResult() O
- [x] 로또의 등수를 결정하는 기능 - decideGrade() O
- [x] 등급 당 당첨된 로또의 개수를 세는 기능 - countGrad() O

### 로또 결과 화면 - LottoResultView - O
- [x] 당첨 통계를 구하는 기능 -getLottoStatistics() O
- [x] 당첨 통계를 출력하는 기능 - printLottoStatistics() O
- [x] 구매한 로또의 총 당첨 금액을 반환하는 기능 - getTotalPrize() O
- [x] 수익률을 반환하는 기능 - getRateReturn()
---
## 예외 처리
- [x] 입력 예외 상황 O
- 구입 금액 입력 시 
  - 아무것도 입력하지 않았을 때 O
  - 공백을 포함하여 입력했을 때 O
  - 음수를 입력하였을 때 O
  - 1000원 미만으로 입력하였을 때 O
  - 천원 단위로 입력하지 않았을 때 O
  - 숫자에 문자가 포함되어 있을 때 O
- 로또 번호 입력 시
  - 아무 것도 입력하지 않았을 때가 O
  - 공백을 포함하여 입력하였을 때 O
  - 범위 밖의 숫자를 입력하였을 때 O
  - 문자를 입력하였을 때 O
  - 숫자가 중복되었을 때 O
  - 문자를 입력했을 때 O
- 보너스 번호 입력 시
  - 아무 것도 입력하지 않았을 때 O
  - 공백을 포함하여 입력하였을 때 O
  - 숫자를 2개 이상 입력했을 때 O
  - 숫자를 입력하지 않았을 때 O
  - 1~45 사이의 숫자를 입력하지 않았을 때 O
  - 입력한 당첨 번호와 중복되었을 때 O