package lotto.model.validation

class WinningValidation(
    private val winningNumbers: List<LottoNumber>,
    private val bonusNumber: LottoNumber,
) {
    init {
        validateDuplicate(winningNumbers, bonusNumber)
    }

    private fun validateDuplicate(winningNumbers: List<LottoNumber>, bonusNumber: LottoNumber) {
        require(winningNumbers.count { it == bonusNumber } == 0) {
            WINNING_BONUS_NUMBER_IS_NOT_DUPLICATE
        }
    }

    companion object {
        const val WINNING_BONUS_NUMBER_IS_NOT_DUPLICATE = "당첨 번호와 보너스 번호는 중복될 수 없습니다."
    }
}