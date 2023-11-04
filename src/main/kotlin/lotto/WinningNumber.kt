package lotto

class WinningNumber(
    private val normalNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        validate(normalNumbers, bonusNumber)
    }

    fun check(lotto: Lotto): Winning {
        // TODO: matchCount로 리팩토링하기
        var winningCount = 0
        normalNumbers.forEach { number ->
            if (lotto.contains(number)) {
                ++winningCount
            }
        }
        val bonusCount = if (lotto.contains(bonusNumber)) 1 else 0
        return Winning.create(
            winningCount = winningCount,
            bonusCount = bonusCount
        )
    }

    companion object {
        private const val NORMAL_NUMBERS_SIZE = 6

        fun validate(normalNumbers: List<Int>) {
            require(normalNumbers.isUnique()) { Message.DuplicatedError }
            require(normalNumbers.size == NORMAL_NUMBERS_SIZE) {
                val errorMessage = Message.NormalWinningNumberSizeError
                errorMessage.format(NORMAL_NUMBERS_SIZE)
            }
            require(normalNumbers.isInLottoNumberRange()) {
                val errorMessage = Message.WinningNumberRangeError
                errorMessage.format(lottoNumberRange.first, lottoNumberRange.last)
            }
        }

        fun validate(normalNumbers: List<Int>, bonusNumber: Int) {
            validate(normalNumbers)
            require((normalNumbers + bonusNumber).isUnique()) {
                Message.DuplicatedWithNormalWinningNumber
            }
            require(bonusNumber.isInLottoNumberRange()) {
                val errorMessage = Message.WinningNumberRangeError
                errorMessage.format(lottoNumberRange.first, lottoNumberRange.last)
            }
        }
    }
}
