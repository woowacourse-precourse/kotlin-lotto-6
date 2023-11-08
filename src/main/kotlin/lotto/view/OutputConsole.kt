package lotto.view

import lotto.model.domain.Lotto

object OutputConsole {

    fun promptForMoney() {
        println(INPUT_MONEY)
    }

    fun promptForWinningNumbers() {
        println(INPUT_WINNING_NUMBER)
    }

    fun promptForBonusNumber() {
        println(INPUT_BONUS_NUMBER)
    }

    fun printErrorMessage(exception: IllegalArgumentException) {
        println(ERROR_MESSAGE_START_PAD + "${exception.message}")
    }

    fun printInvalidNumbers() {
        println(ERROR_MESSAGE_START_PAD + INVALID_FORMAT_FOR_NUMBERS)
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
    private const val INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    private const val INVALID_NUMBERS = "숫자만 입력해 주세요"
    private const val INVALID_FORMAT_FOR_NUMBERS = "콤마로 구분된 숫자만 입력해 주세요"
    private const val ERROR_MESSAGE_START_PAD = "[ERROR] "
}
