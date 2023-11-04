package lotto.util

object OutputUtil {
    private const val MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val MESSAGE_PURCHASED_LOTTO = "개를 구매했습니다."
    private const val MESSAGE_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."

    fun printInputMoney() {
        println(MESSAGE_INPUT_MONEY)
    }

    fun printExceptionMessage(message: String) {
        println("[ERROR] $message")
    }

    fun printPurchasedLottoList(purchasedLottoList: List<List<Int>>) {
        println("\n${purchasedLottoList.size}$MESSAGE_PURCHASED_LOTTO")
        purchasedLottoList.forEach { _lotto ->
            println(_lotto)
        }
        println()
    }

    fun printInputWinningNumber() {
        println(MESSAGE_INPUT_WINNING_NUMBER)
    }
}