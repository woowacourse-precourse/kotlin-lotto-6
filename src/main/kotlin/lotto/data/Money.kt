package lotto.data

import lotto.Constants

data class Money(val number: Int) {

    init {
        require(number > Constants.ZERO) { Constants.ERROR_MONEY_NUMBER_MINIMUM_MESSAGE }
        require(number % Constants.THOUSAND == Constants.ZERO) { Constants.ERROR_MONEY_NUMBER_DIVIDE_MESSAGE }
    }
}
