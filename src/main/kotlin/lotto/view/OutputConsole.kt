package lotto.view

import lotto.model.domain.Lotto
import lotto.model.domain.Rank
import java.text.NumberFormat
import java.util.*

object OutputConsole {

    fun promptForMoney() {
        println(INPUT_MONEY)
    }

    fun printErrorMessage(exception: IllegalArgumentException) {
        println(ERROR_MESSAGE_START_PAD + "${exception.message}")
    }

    fun printNonNumericMessage() {
        println(ERROR_MESSAGE_START_PAD + INVALID_NUMBERS)
    }

    fun printLottoTickets(lottoTickets: List<Lotto>) {
        with(lottoTickets) {
            println("${size}개를 구매했습니다.")
            forEach { println(it.toString()) }
        }
    }

    private const val INPUT_MONEY = "구입금액을 입력해 주세요."
    private const val INVALID_NUMBERS = "숫자만 입력해 주세요"
    private const val ERROR_MESSAGE_START_PAD = "[ERROR] "
}