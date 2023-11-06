package lotto.domain

class MessageManager {

    fun printInputPrice() = println(ENTER_PURCHASE_PRICE)

    fun printPurchaseAmount(amount: String) = println("$amount$COUNT_PURCHASE_AMOUNT")

    fun printInputLottoNumber() = println(ENTER_LOTTO_NUMBER)

    fun printInputBonusNumber() = println(ENTER_BONUS_NUMBER)

    fun printLottoResult() = println("$RECORD_RESULT\n$RECORD_LINE")

    fun printGameResult(
        resultComment: String,
        winningCount: Int
    ) = println("${resultComment}${winningCount}개")

    fun printTotalReturnRate(rate: Double) = println("총 수익률은 ${rate}%입니다.")

    fun printErrorMessage(errorState: ErrorState) = println("$ERROR_START_MESSAGE ${errorState.message}")

    companion object {
        const val ERROR_START_MESSAGE = "[ERROR]"
        private const val ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요."
        private const val COUNT_PURCHASE_AMOUNT = "개를 구매했습니다."
        private const val ENTER_LOTTO_NUMBER = "당첨 번호를 입력해 주세요."
        private const val ENTER_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        private const val RECORD_RESULT = "당첨 통계"
        private const val RECORD_LINE = "---"
    }
}