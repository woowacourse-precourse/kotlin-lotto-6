package lotto.utils.validator

object LottoWinningNumberInputValidator {

    fun validate(numbers: String): LottoWinningNumbersInputState {
        var state : LottoWinningNumbersInputState = LottoWinningNumbersInputState.SUCCESSFUL
        state = getState(numbers.toIntOrNull())
        if (state != LottoWinningNumbersInputState.SUCCESSFUL) {
            throw IllegalArgumentException()
        }
        return state
    }

    private fun getState(number : Int?): LottoWinningNumbersInputState {
        return when{
            number == null -> LottoWinningNumbersInputState.IS_NULL
            number <= 0 || number > 45 -> LottoWinningNumbersInputState.OUT_OF_RANGE
            else -> LottoWinningNumbersInputState.SUCCESSFUL
        }
    }
}