package lotto.domain.enum.error

enum class NumberError(val message: String) {
    NOT_NUMBER("[ERROR] 숫자를 입력 하세요"),
}

enum class PriceNumberError(val message: String){
    UNIT("[ERROR] 1000 단위로 입력 하세요"),
}

enum class WinningNumberError(val message: String){
    INPUT_FORM("[ERROR] 띄어 쓰기 없이 ,로 구분 하여 입력 하세요"),
    RANGE("[ERROR] 당첨 번호는 1에서 45의 숫자만 입력 가능 합니다"),
    DUPLICATION("[ERROR] 중복된 번호가 포함 되어 있습니다."),
    COUNT("[ERROR] 입력된 숫자가 6개가 아닙니다.")
}
