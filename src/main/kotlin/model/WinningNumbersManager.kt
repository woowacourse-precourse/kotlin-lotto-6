package model

class WinningNumbersManager(number: List<String>) {
    init {
        require(number.toSet().size == number.size) { Error.UNIQUE_LOTTO_NUMBERS.message }
    }

    private enum class Error(val message: String) {
        UNIQUE_LOTTO_NUMBERS("로또 번호는 중복되어선 안됩니다."),
    }
}
