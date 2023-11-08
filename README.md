# 미션 - 로또

- ## domain
  - 로또에 관한 로직을 모은 패키지.
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