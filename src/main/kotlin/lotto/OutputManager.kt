package lotto

class OutputManager {

    fun printInputPurchaseAmount() = println(INPUT_PURCHASE_AMOUNT_MSG)

    fun printPurchasedLottoAmount(amount: Int) = println("$amount$PURCHASED_LOTTO_AMOUNT_MSG")

    fun printInputPrizeNum() = println(INPUT_PRIZE_NUM_MSG)

    fun printInputBonusNum() = println(INPUT_BONUS_NUM_MSG)

    companion object {
        private val INPUT_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요."
        private val PURCHASED_LOTTO_AMOUNT_MSG = "개를 구매했습니다."
        private val INPUT_PRIZE_NUM_MSG = "당첨 번호를 입력해 주세요."
        private val INPUT_BONUS_NUM_MSG = "보너스 번호를 입력해 주세요."
    }
}