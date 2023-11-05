package lotto.model

import lotto.model.Purchase.Companion.AMOUNT_UNIT_WON

enum class Message(private val content: String) {
    ErrorPrefix(content = "[ERROR] "),
    InvalidInputError(content = "잘못된 입력입니다. 다시 입력해주세요."),

    InputMoneyAmount(content = "구입금액을 입력해 주세요."),
    NotNumberError(content = "숫자가 아니거나 너무 큰 수를 입력했습니다. 다시 입력해주세요."),
    NumberIsZeroOrNegativeError(content = "0이하의 금액을 입력했습니다. 다시 입력해주세요."),
    InvalidPurchaseAmountError(
        content = "${AMOUNT_UNIT_WON}원 단위가 아닙니다. 구매금액은 ${AMOUNT_UNIT_WON}원 단위로 입력해주세요."
    ),

    Purchased(content = "%d개를 구매했습니다."),

    InputNormalWinningNumber(content = "당첨 번호를 입력해 주세요."),
    DuplicatedError(content = "중복된 숫자가 존재합니다. 다시 입력해주세요."),
    NormalWinningNumberSizeError(content = "%d개를 입력해주세요."),
    WinningNumberRangeError(content = "%d에서 %d 사이의 숫자들만 입력해주세요."),

    InputBonusWinningNumber(content = "보너스 번호를 입력해 주세요."),
    DuplicatedWithNormalWinningNumberError(content = "당첨 번호와 중복됩니다."),

    WinningResultHeader(content = "당첨 통계\n---"),
    BonusMatch(content = ", 보너스 볼 일치"),
    WinningItemResult(content = "%d개 일치%s (%s원) - %d개"),
    ProfitPercentage(content = "총 수익률은 %.1f%%입니다.");

    fun format(vararg args: Any): String {
        return content.format(*args)
    }

    override fun toString(): String {
        return content
    }
}
