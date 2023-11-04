package lotto.util

import lotto.model.Lotto
import lotto.model.Winner
import java.util.*

object OutputUtil {
    private const val MESSAGE_INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val MESSAGE_PURCHASED_LOTTO = "개를 구매했습니다."
    private const val MESSAGE_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private const val MESSAGE_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    private const val MESSAGE_WINNING_DETAIL = "\n당첨 통계\n---"


    fun printInputMoney() {
        println(MESSAGE_INPUT_MONEY)
    }

    fun printExceptionMessage(message: String) {
        println("\n[ERROR] $message")
    }

    fun printPurchasedLottoList(purchasedLottoList: List<Lotto>) {
        println("\n${purchasedLottoList.size}$MESSAGE_PURCHASED_LOTTO")
        purchasedLottoList.forEach { _lotto ->
            println(_lotto)
        }
        println()
    }

    fun printInputWinningNumber() {
        println(MESSAGE_INPUT_WINNING_NUMBER)
    }

    fun printInputBonusNumber() {
        println(MESSAGE_INPUT_BONUS_NUMBER)
    }

    fun printWinningDetails(winningMap: EnumMap<Winner, Int>, ) {
        println(MESSAGE_WINNING_DETAIL)
        Winner.values().forEach {_winner ->
            println("${_winner.message}${winningMap.getOrDefault(_winner, 0)}개")
        }
    }
}