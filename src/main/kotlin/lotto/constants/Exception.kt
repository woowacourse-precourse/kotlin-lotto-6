package lotto.constants

private const val error = "[ERROR]"

enum class Exception(private val msg: String) {
    EMPTY("유효한 입력을 해주세요."),
    DIGIT("숫자만 입력할 수 있습니다."),
    DIVISIBLE("${Constants.PURCHASE_AMOUNT_UNIT.value}원 단위로만 입력할 수 있습니다."),
    COMMA(""),
    SIZE(""),
    DUPLICATION(""),
    SORT(""),
    RANGE("");

    override fun toString() = "$error $msg"
}