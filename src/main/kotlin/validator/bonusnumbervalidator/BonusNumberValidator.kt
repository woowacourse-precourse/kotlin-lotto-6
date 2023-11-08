package validator.bonusnumbervalidator

import view.OutputView

object BonusNumberValidator {
    private const val LENGTH_ONE_NUMBER = "보너스 번호는 1자리 숫자입니다."
    private const val UNIQUE_BONUS_NUMBER = "보너스 번호는 입력된 당첨 번호와 다른 숫자여야 합니다."
    private const val BONUS_NUMBER_SIZE = 1
    private const val TOTAL_LOTTO_NUMBER_SIZE = 7

    fun isAppropriateBonusNumber(input: String, lottoNumber: List<Int>) {
        require(input.length == BONUS_NUMBER_SIZE) { OutputView.error(LENGTH_ONE_NUMBER) }
        val bonusNumber = input.toIntOrNull()
        requireNotNull(bonusNumber) { OutputView.error(LENGTH_ONE_NUMBER) }
        require((lottoNumber + bonusNumber).distinct().size == TOTAL_LOTTO_NUMBER_SIZE) { OutputView.error(UNIQUE_BONUS_NUMBER) }
    }
}
