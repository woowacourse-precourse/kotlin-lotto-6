package lotto.utils.validator

object LottoWinningNumberInputValidator {

    fun validate(number: String): LottoInputState.WinningNumber {
        var numberState = getState(number.toIntOrNull())
        if (numberState != LottoInputState.WinningNumber.SUCCESSFUL) {
            throw IllegalArgumentException()
        }
        return numberState
    }
    private fun getState(number : Int?): LottoInputState.WinningNumber {
        return when{
            number == null -> LottoInputState.WinningNumber.IS_NULL
            number <= 0 || number > 45 -> LottoInputState.WinningNumber.OUT_OF_RANGE
            else -> LottoInputState.WinningNumber.SUCCESSFUL
        }
    }

}