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

    fun checkOnlyNumber(winningSixNumbers: List<String>): Boolean {

        for (number in winningSixNumbers) {
            try {
                number.toUInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] : 자연수가 아닌 값을 입력했습니다. 다시 입력해주세요")

                return false
            }
        }

        return true
    }

    fun checkNumber1to45(winningSixNumbers: List<String>): Boolean {

        for (number in winningSixNumbers) {
            try {
                number.toUInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] : 자연수가 아닌 값을 입력했습니다. 다시 입력해주세요")

                return false
            }
        }

        return true
    }

    fun checkInputSixNumbers(winningSixNumbers: List<Int>): Boolean {

        return true
    }

    fun checkNonOverlapNumber(winningSixNumbers: List<Int>): Boolean {

        return true
    }

    fun checkInputOneNumbers(bonusNumber: Int): Boolean {

        return true
    }

}