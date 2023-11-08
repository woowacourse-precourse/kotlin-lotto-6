package lotto.domain.enum.error

enum class Error(val message: String) {
    NUMBER_FORMAT_ERROR("[ERROR] 숫자를 입력 하세요"),
    NUMBER_RANGE_ERROR("[ERROR] 당첨 번호는 1에서 45의 숫자만 입력 가능 합니다"),
    PRICE_UNIT("[ERROR] 1000 단위로 입력 하세요"),
    INPUT_FORM("[ERROR] 띄어 쓰기 없이 ,로 구분 하여 1에서 45의 숫자를 6개만 입력 하세요")
}
