package lotto.validate

import lotto.utils.Messages

class validateBonus {
    fun validateBonus(bonusNumber: Int, winningNumbers: List<Int>) {
        validateDuplicateBonusNumber(bonusNumber, winningNumbers)
        validateInputIsEmpty(bonusNumber.toString())

    }

    private fun validateDuplicateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonus)) {
            "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}"
        }
    }

    private fun validateInputIsEmpty(myNumbers: String) {
        require(myNumbers.isNotEmpty()) {
            "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}"
        }
    }


}