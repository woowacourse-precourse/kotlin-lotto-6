package lotto.utils

object Exceptions {

    // 구입 금액 예외처리
    fun validatePurchaseAmount(input: String?): Int? {
        when {
            input == null ->{
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE)
            }
            input.toIntOrNull() == null || input.any() { !it.isDigit() } -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE_IS_NOT_DIGIT)
            }
             input.toInt() % 1000 != 0 -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE)
            }
        }
        return input?.toInt()
    }

    // 당첨 번호 예외처리
    fun validateWinningNumbers(input: String?): String? {
        when {
            input == null || GameUtils.parseToInt(input).size != 6 -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_WINNING_NUMBERS)
            }
            input.replace(",", "").any() { !it.isDigit() } -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_WINNING_NUMBERS_IS_NOT_DIGIT)
            }
            !input.split(",").all { it.toInt() in 1..45 } -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_WINNING_NUMBERS_OUT_OF_RANGE)
            }
        }
        return input
    }

    // 보너스 번호 예외처리
    fun validateBonusNumber(input: String?, winningNumbers: List<Int>): Int? {
        when {
            input == null || input.length != 1 -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_BONUS_NUMBER)
            }
            !input[0].isDigit() -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_BONUS_NUMBER_IS_NOT_DIGIT)
            }
            winningNumbers.contains(input.toInt()) -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_BONUS_NUMBER_CONTAIN_WINNING_NUMBER)
            }
        }
        return input?.toInt()
    }

    private fun throwIllegalArgumentException(message: String) {
        throw IllegalArgumentException(message)
    }
}

