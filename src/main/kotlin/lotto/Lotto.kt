package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE)
        require(numbers.isUnique())
        require(numbers.isInLottoNumberRange())
    }

    companion object {
        private const val SIZE = 6
    }
}
