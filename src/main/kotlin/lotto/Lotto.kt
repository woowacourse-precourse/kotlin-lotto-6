package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LottoResource.LOTTO_SIZE) {
            Error.printErrorMessage(Error.LOTTO_NUMBER_SIZE_IS_NOT_SIX)
        }
        require(numbers.distinct().size == LottoResource.LOTTO_SIZE) {
            Error.printErrorMessage(Error.LOTTO_NUMBER_CANT_DUPLICATE)
        }
    }
    fun getLottoFormat(): String {
        return numbers.toString()
    }

    fun compareNumbers(target: List<Int>): Int {
        val correctNumbers = numbers.filter { it in target }
        return correctNumbers.size
    }

    fun compareBonusNumber(target: Int): Boolean {
        if (target in numbers)
            return true
        return false
    }
}

