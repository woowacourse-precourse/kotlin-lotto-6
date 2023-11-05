package lotto.util

import lotto.util.Constant.INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_MAX_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_MIN_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_SIZE
import lotto.util.Constant.LOTTO_NUMBER_SORT_ERROR_MESSAGE

object Exception {

    fun validateInputPrice(price: String) {
        requireNotNull(price.toIntOrNull()) { INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE }
    }

    fun validateLottoNumber(numbers : List<Int>){
        require(numbers.size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE }
        for(number in numbers) {
            require(number in LOTTO_MIN_RANDOM_NUMBER .. LOTTO_MAX_RANDOM_NUMBER) { LOTTO_NUMBER_ERROR_MESSAGE }
        }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE}
        require(numbers == numbers.sorted()){ LOTTO_NUMBER_SORT_ERROR_MESSAGE}
    }
    fun validateInputLuckyNumber(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INPUT_LUCKY_NUMBER_LENGTH_ERROR_MESSAGE }
        for (luckyNumber in numbers){
            require(luckyNumber in LOTTO_MIN_RANDOM_NUMBER .. LOTTO_MAX_RANDOM_NUMBER){ INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
        }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { INPUT_LUCKY_NUMBER_OVERLAP_ERROR_MESSAGE }
    }

    fun validateInputBonusNumber(number: Int) {
        require(number in LOTTO_MIN_RANDOM_NUMBER..LOTTO_MAX_RANDOM_NUMBER) { INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
    }
}