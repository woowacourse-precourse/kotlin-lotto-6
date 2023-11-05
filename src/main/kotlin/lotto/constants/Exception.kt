package lotto.constants

enum class Exception(private val msg: String) {
    EMPTY("유효한 입력을 해주세요."),
    DIGIT("숫자만 입력할 수 있습니다."),
    INT_MAX("입력한 수가 너무 큽니다."),
    PURCHASE_DIVISIBLE("${Constants.PURCHASE_AMOUNT_UNIT}원 단위로만 입력할 수 있습니다."),
    PURCHASE_MAX_COUNT("한번에 구매할 수 있는 로또의 최대 개수는 ${Constants.LOTTO_MAX_COUNT}개 입니다."),
    LOTTO_COMMA("쉼표는 숫자 사이에 하나만 올 수 있습니다."),
    LOTTO_SIZE("${Constants.LOTTO_SIZE}개의 숫자를 입력해 주세요."),
    LOTTO_DUPLICATION("중복되지 않는 로또 번호를 입력해 주세요."),
    LOTTO_SORT("당첨 번호는 오름차순으로 입력해 주세요."),
    LOTTO_RANGE("${Constants.LOTTO_START}~${Constants.LOTTO_END} 범위의 숫자만 입력해 주세요.");

    override fun toString() = "$ERROR $msg"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}