package lotto.utils.validator

object LottoInputState {
    enum class Cost {
        SUCCESSFUL,
        NOT_DIVISIBLE_BY_1000,
        IS_NOT_NATURAL_NUMBER,
        IS_NULL
    }

    enum class WinningNumber {
        SUCCESSFUL,
        IS_NULL,
        OUT_OF_RANGE,
        NUMBERS_SIZE_IS_NOT_SIX,
        HAS_DUPLICATE
    }
}