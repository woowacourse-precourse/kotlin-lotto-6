package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Error.REQUIRED_LOTTO_NUMBER_COUNT.message }
    }

    // TODO: 추가 기능 구현
    private enum class Error(val message: String) {
        REQUIRED_LOTTO_NUMBER_COUNT("로또 번호는 6개여야 합니다."),
    }
}
