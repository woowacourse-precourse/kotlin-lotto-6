package lotto

// 우선 해당 import 보류 - 오류 발생할 수 있음, 애초에 readmd 조건상에 제외하라고 되어있기는 함
//import java.lang.NumberFormatException

class CheckError {

    fun checkInputPositiveInt(money: String): Boolean {
        try {
            val moneyInt = money.toUInt()
        } catch (e: IllegalArgumentException) {
            println("[ERROR] : 자연수가 아닌 값을 입력했습니다. 다시 입력해주세요")

            return false
        }
        return true
    }

    fun checkCanDivide1000(money: Int): Boolean {
        try {
            require(money % 1000 == 0) { }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] : 1000으로 나누어 떨어지지 않습니다. 다시 입력해주세요")

            return false
        }
        return true
    }

    fun checkOnlyNumber(numbers: List<String>): Boolean {
        for (number in numbers) {
            try {
                number.toUInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] : 자연수가 아닌 값을 입력했습니다. 다시 입력해주세요")

                return false
            }
        }
        return true
    }

    fun checkNumber1to45(numbers: List<String>): Boolean {
        for (number in numbers) {
            val changedNumber = number.toInt()

            try {
                require(changedNumber in 1..45) { }
            } catch (e: IllegalArgumentException) {
                println("[ERROR] : 1보다 작거나 45보다 큰 수를 입력했습니다. 다시 입력해주세요")

                return false
            }
        }
        return true
    }

    fun checkInputSixNumbers(numbers: List<String>): Boolean {
        try {
            require(numbers.size == 6) { }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] : 6개의 숫자를 입력하지 않았습니다. 다시 입력해주세요")

            return false
        }
        return true
    }

    fun checkInputOneNumbers(bonusNumber: List<String>): Boolean {
        try {
            require(bonusNumber.size == 1) { }
        } catch (e: IllegalArgumentException) {
            println("[ERROR] : 6개의 숫자를 입력하지 않았습니다. 다시 입력해주세요")

            return false
        }
        return true
    }

    fun checkNonOverlapNumber(numbers: List<String>): Boolean {

        try {
            require(numbers.toSet().size == 6) { }
        } catch (e: IllegalArgumentException) {

            println("[ERROR] : 겹치는 숫자가 있습니다. 다시 입력해주세요")

            return false
        }
        return true
    }

    fun checkNonOverlapBonusNumber(winning: List<Int>, bonus: Int): Boolean {
        try {
            require(!winning.contains(bonus)) {}
        } catch (e: IllegalArgumentException) {
            println("[ERROR] : 겹치는 숫자가 있습니다. 다시 입력해주세요")

            return false
        }
        return true
    }

}