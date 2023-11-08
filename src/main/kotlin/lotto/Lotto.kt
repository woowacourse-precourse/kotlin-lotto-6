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
        println(numbers)
        return numbers.toString()
    }
}

