package lotto.util

import lotto.constants.LottoConstants.LOTTO_PRICE
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER

object Printer {
    private const val MESSAGE_INPUT_MONEY = "로또를 구입할 금액을 숫자만 입력해 주세요. 로또는 개당 ${LOTTO_PRICE}원 입니다."
    private const val MESSAGE_INPUT_NUMBERS =
        "로또 당첨 번호로 사용할 $MIN_LOTTO_NUMBER ~ $MAX_LOTTO_NUMBER 사이의 숫자 6개를 쉼표(,)로 구분해 입력해 주세요."
    private const val MESSAGE_INPUT_BONUS = "보너스 당첨 번호를 $MIN_LOTTO_NUMBER ~ $MAX_LOTTO_NUMBER 사이에서 입력해 주세요."
    private const val MESSAGE_LOTTO_COUNT = "개를 구매했습니다."

    fun printInputMoney() {
        println(MESSAGE_INPUT_MONEY)
    }

    fun printInputNumbers() {
        println(MESSAGE_INPUT_NUMBERS)
    }

    fun printInputBonus() {
        println(MESSAGE_INPUT_BONUS)
    }

    fun printLottoCount(count: Long) {
        println("$count$MESSAGE_LOTTO_COUNT")
    }
}