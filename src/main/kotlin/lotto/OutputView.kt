package lotto

class OutputView {

    fun printRequestInputPurchaseAmount() {
        println(REQUEST_INPUT_PURCHASE_AMOUNT)
    }

    fun printLottoQuantity(quantity: Int) {
        println("\n$quantity$NUMBER_OF_PURCHASES")
    }

    fun printRequestInputWinningNumber() {
        println("\n$REQUEST_INPUT_WINNING_NUMBER")
    }

    fun printRequestInputBonusNumber() {
        println("\n$REQUEST_INPUT_BONUS_NUMBER")
    }

    fun printLottoNumbers(numbers: List<Int>) {
        println(numbers)
    }

    fun printWinningStatistics() {
        println(WINNING_STATISTICS)
    }

    fun printWinningResults(winningDetail: String) {
        println(winningDetail)
    }

    companion object {
        const val REQUEST_INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        const val NUMBER_OF_PURCHASES = "개를 구매했습니다."
        const val REQUEST_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
        const val REQUEST_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
        const val WINNING_STATISTICS = "\n당첨 통계\n---"
    }

}