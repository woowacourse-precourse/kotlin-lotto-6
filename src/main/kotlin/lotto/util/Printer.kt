package lotto.util

import lotto.constants.LottoConstants

object Printer {
    private const val MESSAGE_INPUT_MONEY = "로또를 구입할 금액을 입력해 주세요. 로또는 개당 ${LottoConstants.LOTTO_PRICE}원 입니다."
    private const val MESSAGE_INPUT_NUMBERS = "로또 당첨 번호로 사용할 6개의 숫자를 쉼표(,)로 구분해 입력해 주세요."

    fun printInputMoney() {
        println(MESSAGE_INPUT_MONEY)
    }

    fun printInputNumbers() {
        println(MESSAGE_INPUT_NUMBERS)
    }
}