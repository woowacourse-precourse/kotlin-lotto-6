package lotto

import lotto.Purchase.Companion.AMOUNT_UNIT_WON

enum class Message(private val content: String) {
    ErrorPrefix(content = "[ERROR] "),
    InvalidInputError(content = "잘못된 입력입니다. 다시 입력해주세요."),

    InputMoneyAmount(content = "구입금액을 입력해 주세요."),
    NotNumberOrOverflow(content = "숫자가 아니거나 너무 큰 수를 입력했습니다. 다시 입력해주세요."),
    NumberIsZeroOrNegative(content = "0이하의 금액을 입력했습니다. 다시 입력해주세요."),
    InvalidPurchaseAmount(
        content = "${AMOUNT_UNIT_WON}원 단위가 아닙니다. 구매금액은 ${AMOUNT_UNIT_WON}원 단위로 입력해주세요."
    );

    override fun toString(): String {
        return content
    }
}
