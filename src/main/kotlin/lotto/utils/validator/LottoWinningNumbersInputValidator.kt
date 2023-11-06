package lotto.utils.validator

object LottoWinningNumbersInputValidator {

    fun validate(numbers: List<String>): LottoWinningNumbersInputState {
        var state : LottoWinningNumbersInputState = LottoWinningNumbersInputState.SUCCESSFUL
        for (i in numbers.indices){
            state = getState(numbers[i].toIntOrNull())
            if (state != LottoWinningNumbersInputState.SUCCESSFUL) {
                break
            }
        }
        return state
    }

    private fun getState(number : Int?): LottoWinningNumbersInputState {
        return when{
            number == null -> LottoWinningNumbersInputState.IS_NULL
            number <= 0 && number > 45 -> LottoWinningNumbersInputState.OUT_OF_RANGE
            else -> LottoWinningNumbersInputState.SUCCESSFUL
        }
    }
}