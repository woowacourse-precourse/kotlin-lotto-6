package lotto

class UserInputValidator {
    fun checkNumber(userInput: String) = userInput.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 입력하신 값은 숫자가 아닙니다.")
    fun checkDivideBy1000(userInput: String) {
        if (userInput.toInt() % 1000 != 0)
            throw IllegalArgumentException("[ERROR] 입력하신 가격으로 로또를 구매할 수 없습니다.")
    }
    fun checkNumberInList(numberList: List<String>) {
        numberList.map { number -> checkNumber(number) }
    }
    fun checkNumberInRange(numberList: List<String>) {
        val set = (1..45).toSet()
        numberList.map { number ->
            if(!set.contains(number.toInt())) {
                throw IllegalArgumentException("[ERROR] 입력하신 번호가 1 ~ 45사이의 숫자가 아닙니다.")
            }
        }
    }
}