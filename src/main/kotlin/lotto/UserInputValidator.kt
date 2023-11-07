package lotto

class UserInputValidator {
    fun checkNumber(userInput: String) = userInput.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 입력하신 값은 숫자가 아닙니다.")
    fun checkDivideBy1000(userInput: String) {
        if (userInput.toInt() % 1000 != 0)
            throw IllegalArgumentException("[ERROR] 입력하신 가격으로 로또를 구매할 수 없습니다.")
    }

    fun checkNumberInRange(userInput: String) {
        val set = (1..45).toSet()
        if(!set.contains(userInput.toInt())) {
            throw IllegalArgumentException("[ERROR] 입력하신 번호가 1 ~ 45사이의 숫자가 아닙니다.")
        }
    }

    fun checkNumberListSize(numberList: List<String>) {
        if(numberList.size != 6) {
            throw IllegalArgumentException("[ERROR] 입력하신 번호의 개수가 6개가 아닙니다.")
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
            throw IllegalArgumentException("[ERROR] 중복된 번호를 입력하실 수 없습니다.")
        }
    }

    fun checkDuplicatedNumber(numberList: List<String>, userInput: String) {
        if(numberList.contains(userInput)){
            throw IllegalArgumentException("[ERROR] 입력하신 번호는 당첨 번호와 중복됩니다. 다시 입력해주세요.")
        }
    }
}