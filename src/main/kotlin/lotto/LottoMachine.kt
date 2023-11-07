package lotto

import camp.nextstep.edu.missionutils.Console

private const val CNT_LOTTO_NUMBER = 6
private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45

class LottoMachine {

    fun inputWinningNumbers(): List<Int> {
        val winningNumbers = Console.readLine().split(",").map { it.toInt() }.toList()
        validateWinningNumbers(winningNumbers)
        return winningNumbers
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = Console.readLine().toInt()
        validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber
    }

    private fun validateWinningNumbers(winningNumbers: List<Int>) {
        require(winningNumbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER }) { throw IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.") }
        require(winningNumbers.size == CNT_LOTTO_NUMBER) { throw IllegalArgumentException("[ERROR] 당첨 번호 6개를 입력해야 합니다.") }
        require(winningNumbers.toSet().size == CNT_LOTTO_NUMBER) { throw IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.") }
    }

    private fun validateBonusNumber(bonusNumber: Int, winningNumbers: List<Int>) {
        require(bonusNumber in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.") }
        require(bonusNumber !in winningNumbers) { throw IllegalArgumentException("[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.") }
    }

}