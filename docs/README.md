## 이번 과제에서 실습할 내용

1. MVVM 모델 작성
2. 에러 메세지 enum class 활용
3. 다양한 에러 영역 데이터 검사 영역 추가
4. tdd를 통한 개발

## 역할 구분
1. domain
- enum
    - error
        - ErrorMessage
    - notice
      - Guide
    - number
      - UnitNumber
    - winning
      - MatchCountPrize
      - RankCount
      - RankPrize
- model
  - Customer
  - Winning
- service
  - LottoService
  - LottoCalculator
  - WinningCalculator
2. presentation
- view
  - LottoInputView
  - LottoOutputView
  - LottoView
- viewModel
  - LottoViewModel
	