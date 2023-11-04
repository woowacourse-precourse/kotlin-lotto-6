package lotto

class WinningNumber(
    private val numbers: List<Int>,
    private val bonus: Int
) {
    init {
        validate(numbers)
        require((numbers + bonus).isUnique())
        require(bonus.isInLottoNumberRange())
    }

    fun check(lotto: Lotto): WinningResult {
        var winningCount = 0
        numbers.forEach { number ->
            if (lotto.contains(number)) {
                ++winningCount
            }
        }
        val bonusCount = if (lotto.contains(bonus)) 1 else 0
        return WinningResult.create(
            winningCount = winningCount,
            bonusCount = bonusCount
        )
    }

    companion object {
        private const val NUMBERS_SIZE = 6

        fun validate(numbers: List<Int>) {
            require(numbers.isUnique()) { Message.DuplicatedError }
            require(numbers.size == NUMBERS_SIZE) {
                val errorMessage = Message.WinningNumberSizeError.toString()
                errorMessage.format(NUMBERS_SIZE)
            }
            require(numbers.isInLottoNumberRange()) {
                val errorMessage = Message.WinningNumberRangeError.toString()
                errorMessage.format(lottoNumberRange.first, lottoNumberRange.last)
            }
        }
    }
}
