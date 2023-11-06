package lotto

import camp.nextstep.edu.missionutils.Console

private const val CNT_LOTTO_NUMBER = 6
private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45

class LottoMachine {

    fun inputWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine().split(",").map { it.toInt() }.toList()
        validateWinningNumbers(winningNumbers)
        return winningNumbers
    }

    fun inputBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        return Console.readLine().toInt()
    }

    private fun validateWinningNumbers(winningNumbers: List<Int>) {
        require(winningNumbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { throw IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.") }
        require(winningNumbers.size == CNT_LOTTO_NUMBER) { throw IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.") }
        require(winningNumbers.toSet().size == CNT_LOTTO_NUMBER) { throw IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.") }
    }
}