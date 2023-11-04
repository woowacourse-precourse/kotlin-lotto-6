package lotto

import lotto.validator.LottoCostInputState

object LottoOutputHandler {
    fun displayLottoCostErrorMessage(error: LottoCostInputState){
        var errorMessage : String = ""
        when(error){
            LottoCostInputState.NOT_DIVISIBLE_BY_1000 -> {
                errorMessage = "[ERROR]로또 구입 금액은 1000원 단위입니다."
            }
            LottoCostInputState.IS_NOT_NATURAL_NUMBER, LottoCostInputState.IS_NULL -> {
                errorMessage = "[ERROR]로또 구입 금액은 1000원 단위의 자연수를 입력해야 합니다."
            }
            else -> {}
        }
        println(errorMessage)
    }
}