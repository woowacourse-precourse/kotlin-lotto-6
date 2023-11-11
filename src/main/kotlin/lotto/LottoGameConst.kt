package lotto

const val PAYMENT_UNIT = 1000
const val PERCENT = 100
object ErrorMsg{
    private const val HEADER_MSG = "[ERROR]"
    const val NOT_INT = "$HEADER_MSG 숫자가 아닙니다."
    const val DUPLICATED = "$HEADER_MSG 번호가 중복됩니다."
    const val OUT_OF_RANGE = "$HEADER_MSG 1이상 45이하여야 합니다."
    const val NOT_FIXED_SIZE = "$HEADER_MSG 6개의 숫자가 필요합니다."
}

object GuideMsg{
    const val AMOUNT_MSG = "구입 금액을 입력해 주세요."
    const val WINNING_MSG = "당첨 번호를 입력해 주세요."
    const val BONUS_MSG = "보너스 번호를 입력해 주세요."

}