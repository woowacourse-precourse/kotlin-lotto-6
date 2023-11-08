package lotto.model

const val error = "[ERROR]"
enum class ERROR(val message: String) {
    COMMA_REQUIRED("$error 쉼표를 포함해주세요"),
    NOT_NUMBER("$error 숫자를 입력해주세요"),
    OUT_OF_RANGE("$error 1부터 45까지의 숫자만 입력이 가능합니다"),
    DUPLICATED_NUMBER("$error 중복된 숫자는 입력할 수 없습니다."),
    INVALID_SIZE("$error 6개의 숫자만 입력이 가능합니다."),
    INVALID_PURCHASE_AMOUNT("$error 구입 금액은 1000원 단위로 가능합니다."),
    MINUS("$error 음수는 입력할 수 없습니다."),
    ZERO("$error 0은 입력할 수 없습니다.")
}

enum class PRIZE(val prize: Int) {
    THREE_PRIZE(5000) { override fun apply() = "3개 일치 (${ formatNumberWithComma(this.prize) }원)" },
    FOUR_PRIZE(50000) { override fun apply() = "4개 일치 (${ formatNumberWithComma(this.prize) }원)" },
    FIVE_PRIZE(1500000) { override fun apply() = "5개 일치 (${ formatNumberWithComma(this.prize) }원)" },
    FIVE_WITH_BONUS_PRIZE(30000000) { override fun apply() = "5개 일치, 보너스 볼 일치 (${ formatNumberWithComma(this.prize) }원)" },
    SIX_PRIZE(2000000000) { override fun apply() = "6개 일치 (${ formatNumberWithComma(this.prize) }원)" };

    abstract fun apply(): String
    fun formatNumberWithComma(value: Int): String = String.format("%,d", value)
}

enum class RESULT(val prize: Int, val message: String) {
    THREE(PRIZE.THREE_PRIZE.prize, PRIZE.THREE_PRIZE.apply()),
    FOUR(PRIZE.FOUR_PRIZE.prize, PRIZE.FOUR_PRIZE.apply()),
    FIVE(PRIZE.FIVE_PRIZE.prize, PRIZE.FIVE_PRIZE.apply()),
    FIVE_WITH_BONUS(PRIZE.FIVE_WITH_BONUS_PRIZE.prize, PRIZE.FIVE_WITH_BONUS_PRIZE.apply()),
    SIX(PRIZE.SIX_PRIZE.prize, PRIZE.SIX_PRIZE.apply());
}