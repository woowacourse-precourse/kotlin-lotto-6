package lotto

class WinningNumber(
    private val numbers: List<Int>,
    private val bonus: Int
) {
    init {
        validate(numbers, bonus)
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

        fun validate(winningNumber: List<Int>) {
            require(winningNumber.isUnique()) { Message.DuplicatedError }
            require(winningNumber.size == NUMBERS_SIZE) {
                val errorMessage = Message.WinningNumberSizeError
                errorMessage.format(NUMBERS_SIZE)
            }
            require(winningNumber.isInLottoNumberRange()) {
                val errorMessage = Message.WinningNumberRangeError
                errorMessage.format(lottoNumberRange.first, lottoNumberRange.last)
            }
        }

        fun validate(winningNumber: List<Int>, bonusNumber: Int) {
            validate(winningNumber)
            require((winningNumber + bonusNumber).isUnique()) {
                Message.DuplicatedWithWinningNumber
            }
            require(bonusNumber.isInLottoNumberRange()) {
                val errorMessage = Message.WinningNumberRangeError
                errorMessage.format(lottoNumberRange.first, lottoNumberRange.last)
            }
        }
    }
}
