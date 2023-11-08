package lotto

class Lotto(private val numbers: List<Int>) {
    var bonusNumber = 0
    init {
        require(numbers.size == 6) {
            Error.printErrorMessage(Error.LOTTO_NUMBER_SIZE_IS_NOT_SIX)
        }
        require(numbers.distinct().size == 6) {
            Error.printErrorMessage(Error.LOTTO_NUMBER_CANT_DUPLICATE)
        }
    }
}

