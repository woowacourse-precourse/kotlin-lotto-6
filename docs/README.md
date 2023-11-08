## 📝 기능 목록
### Application
- [x] `GameManager`를 통해 게임을 시작합니다.

### View
#### 1. InputMoneyView
- [x] `Console.ReadLine()`을 이용해 구입 금액을 입력 받고 `InputMoneyViewModel`에서 구입 금액 업데이트 요청합니다.
- [x] 입력받은 값이 유효하지 않은 경우 `InputMoneyErrorListener`로부터 event를 전달받아  에러 메세지 출력 후 다시 입력 받습니다.
- [x]

#### 2. LottoView
- [x] `LottoViewModel`로부터 구입 금액을 바탕으로 생성된 로또의 개수와 발행된 로또 번호를 출력합니다.

#### 3. InputNumberView
- [x] `Console.ReadLine()`을 이용해 당첨 번호와 보너스 번호를 입력 받고 `InputNumberViewModel`에서 해당 번호들에 대해 업데이트를 요청합니다.
- [x] 입력받은 값이 유효하지 않은 경우 `InputNumberErrorListener`로부터 event를 전달받아 에러 메세지 출력 후 다시 입력 받습니다.
구입 금액을 바탕으로 로또의 개수를 계산하고 로또를 발행합니다. 이떄 로또 번호가 유효한 값이 나올때까지 로또 번호 생성을 반복합니다.

#### 4. ResultView
- [x] `ResultViewModel`로부터 결과와 수익률을 불러와 출력합니다.

#### 5.GameManager
- [x] 게임에 필요한 View, ViewModel, Listener를 초기화하고 게임 로직을 시작합니다.

<br>

### ViewModel
#### 1. InputMoneyViewModel
- [x] `InputMoneyView`에서 입력받은 금액에 대해 유효성을 검증하고 유효한 값이 아닌 경우 `InputMoneyErrorListener`에게 event를 전달합니다.
- [x] 유효한 값이 입력되었다면 `InputMoneyListener`에게 event를 전달합니다.

#### 2. LottoViewModel
- [x] `InputMoneyListener`로 부터 유효한 금액이 입력되었다는 이벤트를 전달받으면 발행할 로또의 개수를 초기화하고 이 개수만큼 로또를 발행합니다.
- [x] 로또를 발행하면서 만약 유효하지 않은 로또 번호가 발행되었다면 유효한 번호가 나올때까지 로또 발행을 반복합니다.
- [x] 구입 금액만큼의 유효한 로또가 발행되었다면 `GenerateLottoListener`에 event를 전달합니다.

#### 3. InputNumberViewModel
- [x] 로또 번호와 보너스 번호를 입력받고 유효성을 검증합니다.
- [x] 유효한 번호가 입력되면 `InputNumberListener`에 event를 전달합니다.

#### 4. ResultViewModel
- [x] `InputNumberListener`와 `GenerateLottoListener`로부터 이벤트를 전달받아 발행된 로또 번호와 사용자가 입력한 로또 번호, 보너스 번호를 필드 값으로 초기화합니다.
- [x] 초기화된 필드값으로 결과를 계산합니다.

#### 5. InputValidator
- [x] `isNumber` : 입력된 문자열이 숫자인지 확인합니다.
- [x] `isValidateRange` : 입력된 숫자나 숫자 목록이 주어진 범위(1부터 45) 안에 있는지 검사합니다.
- [x] `isValidatePrice` : 금액이 1000원 단위인지 확인합니다.
- [x] `isDuplicated` : 주어진 숫자 목록에 보너스 숫자가 포함되어 있는지, 또는 숫자 목록 자체에 중복이 있는지 확인합니다.
- [x] `canSplitByComma` : 입력된 문자열이 콤마(,)로 구분되어 있는지 확인합니다.
- [x] `isValidateSize` : 숫자 목록의 크기가 6인지 확인합니다.
- [x] `isZero` : 입력된 숫자가 0인지 확인합니다.
- [x] `isMinus` : 입력된 숫자가 음수인지 확인합니다.
- [x] `lottoNumberValidator`: 로또 번호 문자열을 받아 유효성 검사를 수행합니다. 콤마로 구분되어 있어야 하며, 각 번호는 숫자이고 1부터 45 사이의 범위에 있어야 합니다. 또한, 중복된 번호가 없고, 정확히 6개의 번호가 있어야 합니다.
- [x] `moneyValidator` : 구매 금액 문자열을 받아 유효성 검사를 수행합니다. 금액은 숫자여야 하고, 1000원 단위여야 하며, 0이거나 음수가 아니어야 합니다.
- [x] `bonusNumberValidator` : 선택된 로또 번호 목록과 보너스 번호 문자열을 받아 유효성 검사를 수행합니다. 보너스 번호는 숫자여야 하고, 1부터 45 사이의 범위에 있으며, 이미 선택된 로또 번호 목록에는 없어야 합니다.

<br>

### Observer
#### 1. GenerateLottoListener
- [x] 로또 번호의 생성 여부를 감지 

#### 2. InputMoneyErrorListener
- [x] 구입 금액의 에러를 감지

#### 3. InputMoneyListener
- [x] 구입 금액의 입력을 감지

#### 4. InputNumberErrorListener
- [x] 입력된 로또 번호, 보너스 번호의 에러를 감지 

#### 5. InputNumberListener
- [x] 로또 번호, 보너스 번호의 입력을 감지

<br>

### Model
#### 1. Constants
- [x] 에러메세지 정의
- [x] 결과 출력에 필요한 메세지 정의

#### 2. Lotto
- [x] 초기화 블록에서 생성된 번호의 유효성 검증
- [x] 형식에 맞추어 로또 번호를 출력할 수 있도록 `toString`을 재정의 
- [x] list를 set로 변환하여 반환