## 이번 과제에서 실습할 내용

1. MVVM 모델 작성
2. 에러 메세지 enum class 활용
3. 다양한 에러 영역 데이터 검사 영역 추가
4. tdd를 통한 개발

## 역할 구분
1. domain
- enum
    - error
        - ErrorMessage(입력 오류시에 출력되는 메세지를 저장한 파일)
    - notice
      - Guide(게임의 진행을 안내하는 메세지를 저장한 파일)
    - number
      - UnitNumber(게임의 숫자 단위를 저장한 파일)
    - winning
      - MatchCountPrize(맞춘 숫자와 상금 가격을 저장한 파일)
      - RankCount(맞춘 숫자와 랭킹을 저장한 파일)
      - RankPrize(랭킹과 상금 가격을 저장한 파일)
- model
  - Customer(고객의 정보와 행위를 가지는 객체)
  - Winning(당첨 정보를 가지는 객체)
- service
  - LottoService(로또의 생성과 같은 행위를 가지는 객체)
  - LottoCalculator(로또의 계산을 행하는 객체)
  - WinningCalculator(당첨 정보를 계산하는 객체)
2. presentation
- view
  - LottoInputView(사용자에게 입력 받아 값을 반환하는 하는 객체)
  - LottoOutputView(사용자에게 보여줄 정보를 출력하는 객체)
  - LottoView(게임 진행 사항을 보여주는 객체 )
- viewModel
  - LottoViewModel(출력할 정보를 받거나 저장하여서 가공하여 화면에 전달하는 객체)
	