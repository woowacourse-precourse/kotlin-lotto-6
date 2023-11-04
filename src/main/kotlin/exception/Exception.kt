package exception

import constants.*


class Exception {

    fun noDividedThousand() {
        println(ERROR_NO_DIVIDED_BY_THOUSAND_MESSAGE)
        throw IllegalArgumentException(ERROR_NO_DIVIDED_BY_THOUSAND_MESSAGE)
    }

    fun noInteger() {
        println(ERROR_NO_INTEGER_MESSAGE)
        throw IllegalArgumentException(ERROR_NO_INTEGER_MESSAGE)
    }

    fun noCorrectWinNumber() {
        throw IllegalArgumentException(ERROR_WIN_NUMBER_MESSAGE)
    }

    fun noCorrectLottoNumber() {
        throw IllegalArgumentException(ERROR_LOTTO_NUMBER_MESSAGE)
    }


}