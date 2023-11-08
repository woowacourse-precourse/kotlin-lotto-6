# Machine
    - [] 구입 금액 입력 -> validate
        - 숫자가 아닌 경우
        - 1000원 단위가 아닌 경우
    - [] 갯수 & Lotto 번호 출력
        - LottoPrinter 객체를 통해 출력
    - [] 당첨 번호 & 보너스 번호 입력 -> validate
        - 숫자가 아닌 경우
        - 1 ~ 45 사이의 숫자가 아닌 경우
        - 6자리가 아닌 경우
        - 중복된 숫자가 입력된 경우
    - [] 로또 결과 출력
        - ResultPrinter를 통해 출력

# LottoCreator
    - [] 로또 번호 생성 -> Lotto에 전달
    - [] 로또 번호 검사(validate)

# Lotto
    - [] 등록된 번호를 통해 로또 결과 계산

# LottoPrinter
    - [] 구입한 로또의 갯수 출력
    - [] 구입한 로또의 숫자 출력

# ResultPrinter
    - [] 구입한 로또의 결과 출력
    - [] 수익률 출력

# ErrorMsg, Msg
    - [] 오류가 날때 생성되는 메세지 가지고 있기
    - [] 일반적인 출력 메세지 가지고 있기

# Result
    - [] 로또 당첨 결과