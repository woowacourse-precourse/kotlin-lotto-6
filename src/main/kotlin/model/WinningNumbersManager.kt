package model

class WinningNumbersManager(number: List<String>) {
    init {
        require(number.all { it.matches(Regex("[^0-9]")) }) { Error.INPUT_ONLY_NUMBER.message }
        require(number.toSet().size == number.size) { Error.UNIQUE_LOTTO_NUMBERS.message }
        require(number.all { it.toInt() in 1..45 }) { Error.LOTTO_NUMBER_RANGE.message }
    }

    private enum class Error(val message: String) {
        INPUT_ONLY_NUMBER("[ERROR] 숫자만 입력이 가능합니다."),
        UNIQUE_LOTTO_NUMBERS("[ERROR] 로또 번호는 중복되어선 안됩니다."),
        LOTTO_NUMBER_RANGE("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    }
}
