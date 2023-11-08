package lotto

class UserInputValidator {
    fun checkNumber(userInput: String) = userInput.toIntOrNull() ?: throw IllegalArgumentException(ExceptionMessage.NOT_NUMBER)
    fun checkDivideBy1000(userInput: String) {
        if (userInput.toInt() % 1000 != 0 || userInput.toInt() == 0)
            throw IllegalArgumentException(ExceptionMessage.NOT_CORRECT_PRICE)
    }

    fun checkNumberInRange(userInput: String) {
        val set = (1..45).toSet()
        if(!set.contains(userInput.toInt())) {
            throw IllegalArgumentException(ExceptionMessage.NOT_LOTTO_NUMBER_IN_RANGE)
        }
    }

    fun checkNumberListSize(numberList: List<String>) {
        if(numberList.size != 6) {
            throw IllegalArgumentException(ExceptionMessage.NOT_CORRECT_SIZE)
        }
    }
    fun checkNumberInList(numberList: List<String>) {
        numberList.map { number ->
            checkNumber(number)
            checkNumberInRange(number)
        }
    }

    fun checkDuplicatedNumberInList(numberList: List<String>) {
        val set = numberList.toSet()
        if(set.size != 6) {
            throw IllegalArgumentException(ExceptionMessage.NOT_DUPLICATED_NUMBER)
        }
    }

    fun checkDuplicatedNumber(numberList: List<Int>, userInput: String) {
        if(numberList.contains(userInput.toInt())){
            throw IllegalArgumentException(ExceptionMessage.BONUS_NUMBER_DUPLICATED)
        }
    }
}