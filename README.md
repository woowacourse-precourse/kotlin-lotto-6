# 미션 - 로또

- ## 도메인 로직 정리.
  - ### Lotto
    - `List<Int>`를 받아 초기화
    - `intersect`
      - 로또간에 겹치는 번호를 `Set<Int>`로 얻을 수 있음.
       ```
      // 함수 사용법.
      val lottoA = Lotto(listA)
      val lottoB = Lotto(listB)
      val intersectedNumberSet = lottoA intersect lottoB 
       ```
    - `contains(number)`
      - 로또 번호에 number가 포함되어 있는지 확인할 수 있음.
    - `toString()`
      - 로또 번호의 String 표현형.
      - `[1, 2, 3, 4, 5, 6]`의 형태.
  - ### LottoBuilder
    - `buildLotto()`
      - `Randoms.pickUniquieNumbersInRange`로 만든 랜덤 숫자 Set으로`Lotto`를 만들어 반환.
  - ### LottoBuyer
    - `budget`을 받아 `amountOfLotto`를 계산.
    - `amountOfLotto`만큼의 `Lotto`를 만들어 `lottoList`에 저장
  - ### LottoChecker
    - 정답 번호와 비교해 로또가 몇 등인지 체크하는 클래스.
    - 정답 번호 `winNumber`와 `bonusNumber`를 멤버 변수로 가진다.
    - `howMuchNumbersAreCorrect(userNumber: Lotto)`
      - `userNumber`가 정답 번호와 몇 개 일치하는지 구한다.
    - `checkLotto(userNumber: Lotto): Position`
      - userNumber를 받아 개수에 따른 등수를 분류한다.
  - ### PrizeCalculator
    - 로또 리스트를 받아 등수를 각각 분류하고, 그에 따른 보상을 계산하는 클래스.
    - `getWinningCountMap()`
      - 로또 리스트의 등수를 세어 `Map<Position, Int>` 형식으로 정리한다.
    - `getSumOfWinningPrize()`
      - 로또 리스트의 당첨금을 합산한다.
  - ### Position
    - 등수, 당첨금, 등수에 따른 메시지 표현형을 enum으로 정리해둔 클래스.
