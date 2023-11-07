# 💰 프리코스 3주차. 로또

📌 written by. `@leejieuns2`

## 🚀 구현 기능 목록

#### 1. [Purchase] 로또 구입 금액 입력 받기.
- 구입 금액은 1,000원 단위로 입력
- `camp.nextstep.edu.missionutils.Console`의 `readLine()` 함수 활용
- 1,000원으로 나누어 떨어지지 않는 경우 예외 처리 필요.

#### 2. [Lotto, Lottos] 구입 금액에 맞는 개수만큼 로또 생성
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 랜덤으로 만들어내야 함.
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()` 함수 활용.
- 발행한 로또 수량 및 번호 출력. 로또 번호는 오름차순으로 정렬해야 함.
- 중복되는 숫자 있을 경우 예외 처리 필요.

#### 3. [WinningLotto - winningNumber] 당첨 번호 입력 받기.
- 로또 번호의 숫자 범위는 1~45까지.
- `camp.nextstep.edu.missionutils.Console`의 `readLine()` 함수 활용
- 번호는 쉼표(,)를 기준으로 구분.

#### 4. [WinningLotto - bonusNumber] 보너스 번호를 입력 받기.
- 번호를 잘못 입력했을 시 예외 처리 필요.
- `camp.nextstep.edu.missionutils.Console`의 `readLine()` 함수 활용
- 당첨 번호와 중복되는 숫자를 입력할 경우 예외 처리 필요.

#### 5. [Rank, LottoResult] 당첨 내역 출력.
- 당첨은 1등부터 5등까지 계산하여 나열.
- Enum Class를 활용하여 등수 계산 및 저장.
```markdown
< 등수 계산 기준 >
 - 1등: 6개 번호 일치 / 2,000,000,000원
 - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
 - 3등: 5개 번호 일치 / 1,500,000원
 - 4등: 4개 번호 일치 / 50,000원
 - 5등: 3개 번호 일치 / 5,000원
 ```

#### 7. [Performance] 수익률 계산
- 당첨 내역 출력 시 같이 출력되도록 구현.
- 수익률은 소수점 둘째 자리에서 반올림. (ex. 100.0%, 51.5%, 1,000,000.0%)

#### 8. 예외 상황 시 에러 문구를 출력.
- 단, 에러 문구는 "[ERROR]"로 시작해야 함.

#### 9. 각 도메인 로직 단위 별로 테스트 코드 구현
- UI (System.out / System.in / Scanner) 로직 제외
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현

<br>

---
### 💡 이번 주차에 개선해보고자 하는 것들

- [ ] MVC 구조에 맞게 더 Class 세분화 해보기
- [ ] 기능 별 테스트 코드 세분화하여 작성하기 (작은 단위의 테스트 만들어보기)
- [ ] 변수 이름에 자료형 사용하지 않기 ex) `val winnerList`
- [ ] README.md 중간중간 수정하기 (기능 목록 재검토하기 & 예외적인 상황 추가하기)
- [ ] Kotlin Scope Function 사용해 보기.
- [ ] if/else문을 지양하는 대신 when을 더 적극적으로 사용해 보기
---
