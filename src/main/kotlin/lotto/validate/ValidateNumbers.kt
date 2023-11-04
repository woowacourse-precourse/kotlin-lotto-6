package lotto.validate

import lotto.utils.Constants
import lotto.utils.Messages

class ValidateNumbers {
    fun validateInputMyNumbers(myNumbers: String): String {
        validateInputIsEmpty(myNumbers)
        validateMyNumberDelimiter(myNumbers)
        return myNumbers
    }

    private fun validateMyNumberDelimiter(x: String){
        require(x.contains(Constants.DELIMITER)) {"${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DELIMITER_MESSAGE}" }
    }

    private fun validateInputIsEmpty(myNumbers: String) {
        require(myNumbers.isNotEmpty()) {
            "${Messages.ERROR_MESSAGE} ${Messages.VALIDATE_INPUT_EMPTY}"
        }
    }


}