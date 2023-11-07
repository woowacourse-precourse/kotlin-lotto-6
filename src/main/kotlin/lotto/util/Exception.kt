package lotto.util

import lotto.domain.Lotto
import lotto.util.Constant.INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_WINNING_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.INPUT_WINNING_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_WINNING_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_MAX_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_MIN_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_SIZE

object Exception {

    fun validateInputPrice(price: String) {
        requireNotNull(price.toIntOrNull()) { INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE }
    }

    fun validateUserPrice(price: Int) {
        require(price % Constant.UNIT_PRICE == 0) { Constant.INPUT_PRICE_UNIT_ERROR_MESSAGE }
    }

    fun validateUserLottoes(price: Int, lottoes: List<Lotto>) {
        require(price / Constant.UNIT_PRICE == lottoes.size) { Constant.LOTTO_BUY_ERROR_MESSAGE }
        for (lotto in lottoes) {
            validateLottoNumber(lotto.getLottoNumbers())
        }
    }

    fun validateLottoNumber(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE }
        for (number in numbers) {
            require(number in LOTTO_MIN_RANDOM_NUMBER..LOTTO_MAX_RANDOM_NUMBER) { LOTTO_NUMBER_ERROR_MESSAGE }
        }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE }
    }

    fun validateWinningNumber(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INPUT_WINNING_NUMBER_LENGTH_ERROR_MESSAGE }
        for (winningNumber in numbers) {
            require(winningNumber in LOTTO_MIN_RANDOM_NUMBER..LOTTO_MAX_RANDOM_NUMBER) { INPUT_WINNING_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
        }
        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) { INPUT_WINNING_NUMBER_OVERLAP_ERROR_MESSAGE }
    }

    fun validateBonusNumber(number: Int) {
        require(number in LOTTO_MIN_RANDOM_NUMBER..LOTTO_MAX_RANDOM_NUMBER) { INPUT_BONUS_NUMBER_NOT_NUMBER_ERROR_MESSAGE }
    }

    fun validateWinningLotto(winningNumbers: List<Int>, bonusNumber: Int) {
        require(!winningNumbers.contains(bonusNumber)) { Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE }
    }
}