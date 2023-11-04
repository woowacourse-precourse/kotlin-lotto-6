package lotto

import camp.nextstep.edu.missionutils.Console

fun inputWinningNumbers(): List<Int> {
    var winningLotteryNumbers: List<Int> = emptyList()
    var validWinningNumbers = false

    while (!validWinningNumbers) {
        println("\n당첨 번호를 입력해 주세요.")
        val input = Console.readLine()
        try {
            winningLotteryNumbers = input.split(',').map { it.trim().toInt() }
            val lotto = Lotto(winningLotteryNumbers)
            validWinningNumbers = true
        } catch (e: NumberFormatException) {
            println("[ERROR] 당첨 번호는 모두 숫자여야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    return winningLotteryNumbers
}

fun inputBonusNumber(winningLotteryNumbers: List<Int>): Int {
    var bonusNumber = 0
    var validBonusNumber = false

    while (!validBonusNumber) {
        println("\n보너스 번호를 입력해 주세요.")
        val bonusInput = Console.readLine()
        try {
            bonusNumber = bonusInput.trim().toInt()
            if (bonusNumber < 1 || bonusNumber > 45) {
                throw IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자만 입력하세요.")
            }
            if (winningLotteryNumbers.contains(bonusNumber)) {
                throw IllegalArgumentException("[ERROR] 기존 당첨 번호에 이미 같은 값이 있습니다.")
            }
            validBonusNumber = true
        } catch (e: NumberFormatException) {
            println("[ERROR] 보너스 번호는 숫자여야 합니다.")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    return bonusNumber
}