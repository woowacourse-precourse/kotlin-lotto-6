package lotto.util

object Printer {
    private const val MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val MESSAGE_LOTTO_COUNT = "개를 구매했습니다."
    private const val MESSAGE_INPUT_NUMBERS = "당첨 번호를 입력해 주세요."
    private const val MESSAGE_INPUT_BONUS = "보너스 번호를 입력해 주세요."

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

    fun printGeneratedLotto(lottoNumbers: List<Int>) {
        println(lottoNumbers)
    }
}