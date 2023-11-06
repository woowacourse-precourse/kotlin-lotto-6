package lotto

import java.lang.NumberFormatException

// 우선 해당 import 보류 - 오류 발생할 수 있음, 애초에 readmd 조건상에 제외하라고 되어있기는 함
//import java.lang.NumberFormatException

class CheckError {

    fun checkInputInt(money: String): Boolean {

        try {

            val moneyInt = money.toInt()

        } catch (e: IllegalArgumentException) {

            println("[ERROR] : 정수가 아닌 수 혹은 문자를 입력했습니다. 다시 입력해주세요")

            return false
        }

        return true
    }

    fun checkInputPositiveInt(money: Int): Boolean {


        return true
    }

    fun checkCanDivide1000(money: Int): Boolean {


        return true
    }

    fun checkNonOverlapNumber(winningSixNumbers: List<Int>): Boolean {

        return true
    }

    fun checkOnlyNumber1to45(winningSixNumbers: List<Int>): Boolean {

        return true
    }

    fun checkInputSixNumbers(winningSixNumbers: List<Int>): Boolean {

        return true
    }

    fun checkInputOneNumbers(bonusNumber: Int): Boolean {

        return true
    }

}