# 로또 게임

## 게임의 규칙

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다

```
- 로또 번호의 숫자 범위는 1~45까지이다
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다
- 로또 1장의 가격은 1,000원이다
- 당첨 번호와 보너스 번호를 입력받는다
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다
  - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다

## 기능 목록
- [x] 로또 구입 금액을 1000원 단위로 입력받는다
  - [x] 공백을 제거한다
  - [x] `ERROR` : 아무런 값을 입력하지 않았을 시  `IllegalArgumentException` 발생
  - [x] `ERROR` : 1000원으로 나누어 떨어지지 않으면 `IllegalArgumentException` 발생


- [x] 발행한 로또 수량을 출력한다
- [x] 1~45까지의 숫자로 중복 없이 6개의 숫자를 뽑아 로또를 발행한다
- [x] 로또 번호를 오름차순 출력한다


- [x] 당첨 번호를 쉼표 기준으로 6개 입력받는다.
  - [x] 공백을 제거한다
  - [x] `ERROR` : 아무런 값을 입력하지 않았을 시  `IllegalArgumentException` 발생
  - [x] `ERROR` : 1~45 범위의 숫자가 아닐 시 `IllegalArgumentException` 발생
  - [x] `ERROR` : 입력 개수가 6개가 아닐 시 `IllegalArgumentException` 발생
  - [x] `ERROR` : 중복된 값 입력 시 `IllegalArgumentException` 발생


- [x] 보너스 번호를 1개 입력받는다
  - [x] 공백을 제거한다
  - [x] `ERROR` : 아무런 값을 입력하지 않았을 시  `IllegalArgumentException` 발생
  - [x] `ERROR` : 입력 개수가 1개가 아닐 시 `IllegalArgumentException` 발생
  - [x] `ERROR` : 1~45 범위의 숫자가 아닐 시 `IllegalArgumentException` 발생


- [x] 발행한 로또에서 당첨 번호와 몇 개가 일치 하는지 알 수 있다
- [x] 발행한 로또에서 보너스 번호와 같은 값이 있는지 알 수 있다


- [x] 당첨 내역을 출력한다  
  3개 일치 (5,000원) - 1개  
  4개 일치 (50,000원) - 0개  
  5개 일치 (1,500,000원) - 0개  
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개  
  6개 일치 (2,000,000,000원) - 0개


- [x] 총 수익률을 소수점 둘째 자리에서 반올림 해 알 수 있다


## 도메인 로직 단위 테스트 목록
- [x] PurchasePriceValidator 테스트
- [x] WinNumbersValidator 테스트
- [x] BonusNumberValidator 테스트
- [x] InputValidator 테스트
- [x] Lotto 테스트
- [x] LottoRank 테스트
- [x] LottoResult 테스트
- [x] LottoStore 테스트
