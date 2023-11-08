package lotto

class Lotto(private val numbers: List<Int>) {
    val _numbers = numbers

    init {
        require(numbers.size == Validator.MAX_LOTTO_LENGTH)
        Validator.validateNumbers(numbers)
    }

}
