package lotto.util

import lotto.util.Constant.INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_PRICE_UNIT_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_MAX_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_MIN_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_NUMBER_SIZE
import lotto.util.Constant.UNIT_PRICE
import java.lang.IllegalArgumentException

object Exception {

    fun validateInputPrice(price: String) {
        requireNotNull(price.toIntOrNull()) { INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE }
        require(price.toInt() % UNIT_PRICE == 0) { INPUT_PRICE_UNIT_ERROR_MESSAGE }
    }

    fun validateInputLuckyNumber(numbers: String) {
        val luckyNumbers = numbers.split(",")
        require(luckyNumbers.size == LOTTO_NUMBER_SIZE) { INPUT_LUCKY_NUMBER_LENGTH_ERROR_MESSAGE }
        for (luckyNumber in luckyNumbers){
            requireNotNull(luckyNumber.toIntOrNull()) {INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
            require(luckyNumber.toInt() in LOTTO_MIN_RANDOM_NUMBER .. LOTTO_MAX_RANDOM_NUMBER){ INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
        }
        require(luckyNumbers.toSet().size == LOTTO_NUMBER_SIZE) { INPUT_LUCKY_NUMBER_OVERLAP_ERROR_MESSAGE }
    }

    fun validateInputBonusNumber(number: String, luckyNumbers: List<Int>) {
        requireNotNull(number.toIntOrNull()) { INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
        require(number.toInt() in LOTTO_MIN_RANDOM_NUMBER..LOTTO_MAX_RANDOM_NUMBER) { INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
        require(!luckyNumbers.contains(number.toInt())) { INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE }
    }
}