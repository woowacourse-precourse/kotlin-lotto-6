package exception

import constants.NO_DIVIDED_BY_THOUSAND_MESSAGE
import constants.NO_INTEGER_MESSAGE


class Exception {

    fun noDividedThousand() {
        println(NO_DIVIDED_BY_THOUSAND_MESSAGE)
        throw IllegalArgumentException(NO_DIVIDED_BY_THOUSAND_MESSAGE)
    }

    fun noInteger() {
        println(NO_INTEGER_MESSAGE)
        throw IllegalArgumentException(NO_INTEGER_MESSAGE)
    }


}