package client

import exception.Exception

class ClientUtil {
    private val exception = Exception()
    private val isIntRegex = Regex("\\d+\$")

    fun checkIsInteger(money: String) {
        if(!isIntRegex.matches(money)){
            exception.noInteger()
        }
    }

    fun checkNoDividedByThousand(money: Int) {
        if (money % 1000 != 0) {
            exception.noDividedThousand()
        }
    }
}