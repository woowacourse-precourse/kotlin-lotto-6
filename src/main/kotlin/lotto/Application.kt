package lotto

import camp.nextstep.edu.missionutils.Console

const val ERROR = "[ERROR]"
const val NOT_MULTIPLE_OF_1000_ERROR = " 구입금액은 1000의 배수여야 합니다. 다시 입력해 주세요."

fun main() {
    println("구입금액을 입력해 주세요.")
    validateInputMoney( getInputMoney() )
}

fun getInputMoney(): Int {

    return Console.readLine().toInt()
}

fun checkException(inputMoney: Int) {
    require(inputMoney % 1000 == 0) { throw IllegalArgumentException(ERROR+NOT_MULTIPLE_OF_1000_ERROR) }

}

fun validateInputMoney(inputMoney: Int) {
    var isValidInput = false

    while (!isValidInput) {
        try {
            checkException(inputMoney)
            isValidInput = true

        } catch (e: IllegalArgumentException) {
            println("${e.message}")
            getInputMoney()

        }

    }
}
