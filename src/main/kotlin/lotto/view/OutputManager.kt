package lotto.view

object OutputManager {
    private const val INPUT_PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요."
    const val PURCHASED_LOTTO_AMOUNT_MSG = "개를 구매했습니다."
    private const val INPUT_WINNING_NUM_MSG = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUM_MSG = "보너스 번호를 입력해 주세요."

    fun printInputPurchaseAmount() = println(INPUT_PURCHASE_AMOUNT_MSG)

    fun printInputWinningNum() = println(INPUT_WINNING_NUM_MSG)

    fun printInputBonusNum() = println(INPUT_BONUS_NUM_MSG)
}