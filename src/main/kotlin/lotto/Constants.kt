package lotto

class Constants {
    enum class Numbers(val value: Int) {
        RANDOM_NUMBERS_RANGE_START(1),
        RANDOM_NUMBERS_RANGE_END(45),
        RANDOM_NUMBERS_SIZE(6),
    }

    enum class Strings(val message: String) {
        ASK_LOTTO_PURCHASE_PRICE("구입금액을 입력해 주세요."),
        PURCHASE_LOTTO_COUNT_POSTFIX("개를 구매했습니다."),
    }
}