package lotto

import lotto.Constants.Companion.ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE

class Validator {
    fun checkForDuplicates(lotto: List<Int>, bonus: Int) {
        require(!lotto.contains(bonus)){ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE}
    }
}