package lotto

import camp.nextstep.edu.missionutils.Console

class InputManager {
    // 구입 금액 입력
    private fun inputMoney(): String {
        println("구입금액을 입력해 주세요.")
        return Console.readLine()
    }

    // 당첨 번호 입력
    private fun inputWinningNumbers(): String {
        println()
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine()
    }

    // 보너스 번호 입력
    private fun inputBonusNumber(): String {
        println()
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine()
    }

    // 입력된 구입 금액 처리 및 반환
    fun getMoney(): Int {
        val inputMoney =
                try {
                    inputMoney().toInt()
                } catch (e: IllegalArgumentException) {
                    println("[ERROR] 올바른 숫자를 입력해주세요.")
                    inputMoney().toInt()
                }

        handleMoneyUnitException(inputMoney)

        return inputMoney
    }

    // 입력된 당첨 번호 처리 및 반환
    fun getWinningNumber(): List<Int> {
        val winningNumbers = ArrayList<Int>()

        for (winningNumber in inputWinningNumbers().split(",")) {
            winningNumbers.add(winningNumber.toInt())
        }

        handleNumberOfWinningNumbersException(winningNumbers)

        return winningNumbers
    }

    // 입력된 보너스 번호 처리 및 반환
    fun getBonusNumber(): Int {
        val bonusNumber =
                try {
                    inputBonusNumber().toInt()
                } catch (e: IllegalArgumentException) {
                    println("[ERROR] 올바른 숫자를 입력해주세요.")
                    inputBonusNumber().toInt()
                }

        return bonusNumber
    }

    // 1,000원 단위 입력 예외 처리
    private fun handleMoneyUnitException(inputMoney: Int) {
        if (inputMoney % 1000 != 0) {
            throw IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.")
        }
    }

    // 사용자가 6개가 아닌 당첨 번호를 입력한 경우
    private fun handleNumberOfWinningNumbersException(winningNumbers: ArrayList<Int>) {
        if (winningNumbers.size != 6) {
            throw IllegalArgumentException("[ERROR] 당첨 번호를 올바르게 입력해주세요.")
        }
    }
}