package lotto

import camp.nextstep.edu.missionutils.Console

class InputManager {
    // 구입 금액 입력
    private fun inputMoney(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }

    // 구입 금액 처리 및 반환
    fun getMoney(): Int {
        val inputMoney = inputMoney().toInt()

        handleMoneyUnitException(inputMoney)

        return inputMoney
    }

    // 1,000원 단위 입력 예외 처리
    private fun handleMoneyUnitException(inputMoney: Int) {
        if (inputMoney % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.")
        }
    }
}