package lotto.utils

class UserInputException {
    companion object {

        fun isNumber(userInput: String): Boolean {
            for (numberIndex in 0 until userInput.length) {
                if (userInput[numberIndex].code < '0'.code || userInput[numberIndex].code > '9'.code) {
                    return false
                }
            }
            return true
        }

        fun purchaseAmountException(userInput: String):Int {
            require(isNumber(userInput)) { "[ERROR] 입력 값은 숫자여야 합니다." }
            require(userInput.toInt() % 1000 == 0) { "[ERROR] 구입 금액은 1,000원 단위여야 합니다." }
            return userInput.toInt()
        }
    }
}