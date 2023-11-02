package ui

class OutputManager {
    fun promptPurchaseAmount() = println(PROMPT_PURCHASE_AMOUNT)
    fun invalidPurchaseAmount(): () -> Unit = { println(INVALID_PURCHASE_AMOUNT) }
    fun invalidLottoNumbers(): () -> Unit = { println(INVALID_LOTTO_NUMBERS) }
    fun purchaseLottoCount(lottoCount: Int) = println(PURCHASE_LOTTO_COUNT.format(lottoCount))
    fun promptJackpotNumbers() = println(PROMPT_JACKPOT_NUMBERS)
    fun promptBonusNumber() = println(PROMPT_BONUS_NUMBER)
    fun lottoStats() = println(LOTTO_STATS)
    fun line() = println(LINE)
    fun lottoResult(
        correctLottoNumbers: Int,
        winningAmount: String,
        winningCount: Int
    ) = println(LOTTO_RESULT.format(correctLottoNumbers, winningAmount, winningCount))

    companion object {
        private const val ERROR = "[ERROR]"
        private const val INVALID_PURCHASE_AMOUNT = "$ERROR 유효하지 않은 금액입니다."
        private const val INVALID_LOTTO_NUMBERS = "$ERROR 로또 번호는 1부터 45 사이의 숫자여야 합니다."

        private const val PROMPT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        private const val PROMPT_JACKPOT_NUMBERS = "당첨 번호를 입력해 주세요."
        private const val PROMPT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        private const val PURCHASE_LOTTO_COUNT = "%d개를 구매했습니다."

        private const val LOTTO_STATS = "당첨 통계"
        private const val LINE = "---"
        private const val LOTTO_RESULT = "%d개 일치 (%s원) - %d개"
    }
}