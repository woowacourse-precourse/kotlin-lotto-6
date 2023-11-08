package lotto.validator

class Validator {
    fun validatedNumberInRange(num: Int, start: Int, end: Int): Int {
        if (num !in start..end) throw IllegalArgumentException("[ERROR] 로또 번호는 ${start}부터 ${end}사이 숫자여야 합니다.")
        return num
    }

    fun validatedMoneyIsInt(userInput: String): Int {
        return userInput.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] 숫자를 입력해주세요.")
    }

    fun validatedMoneyUnit(money: Int, unit: Int): Int {
        if (money % unit != 0) throw IllegalArgumentException("[ERROR] ${unit} 단위로 금액을 제시해주세요.")
        if (money < 1000) throw IllegalArgumentException("[ERROR] 1000 이상의 금액을 제시해주세요.")
        return money
    }
}