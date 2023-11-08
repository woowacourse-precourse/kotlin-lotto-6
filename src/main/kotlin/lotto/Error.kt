package lotto

enum class Error (
    val output: String
) {
    INPUTMONEYDIVIDED1000WON("[ERROR] 구입 금액은 1000원으로 나누어 떨어지는 금액만 입력 가능합니다."),
    ISNUMBER("[ERROR] 숫자만 입력 가능합니다."),
    NUMBERCOUNTISSIX("[ERROR] 당첨 번호 입력은 6글자만 가능합니다."),
    NUMBERISRANDOM("[ERROR] 로또 번호는 각자 다 다른 숫자만 입력 가능합니다."),
    NUMBERRANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUSNUMBERRANGE("[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.")
}