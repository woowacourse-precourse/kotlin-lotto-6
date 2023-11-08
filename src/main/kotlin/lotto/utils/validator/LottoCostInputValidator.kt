package lotto.utils.validator

class LottoCostInputValidator {
    private val errorMessages : HashMap<LottoInputState.Cost, String> = hashMapOf()

    init {
        errorMessages[LottoInputState.Cost.NOT_DIVISIBLE_BY_1000] = "[ERROR]로또 구입 금액은 1000원 단위입니다."
        errorMessages[LottoInputState.Cost.IS_NULL] = "[ERROR]유효한 값이 아닙니다. 로또 구입 금액은 1000원 단위의 자연수를 입력해야 합니다."
        errorMessages[LottoInputState.Cost.IS_NOT_NATURAL_NUMBER] = "[ERROR]로또 구입 금액은 1000원 단위의 자연수를 입력해야 합니다."
    }
    fun validate(cost: String): LottoInputState.Cost {
        val costState = getState(cost.toIntOrNull())
        if (costState != LottoInputState.Cost.SUCCESSFUL) {
            displayErrorMessage(costState)
            throw IllegalArgumentException()
        }
        return costState
    }

    private fun getState(cost: Int?): LottoInputState.Cost {
        return when {
            cost == null -> LottoInputState.Cost.IS_NULL
            cost % 1000 != 0 -> LottoInputState.Cost.NOT_DIVISIBLE_BY_1000
            cost <= 0 -> LottoInputState.Cost.IS_NOT_NATURAL_NUMBER
            else -> LottoInputState.Cost.SUCCESSFUL
        }
    }

    private fun displayErrorMessage(error: LottoInputState.Cost) {
        println(errorMessages[error])
    }


}
