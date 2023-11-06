package lotto

import camp.nextstep.edu.missionutils.Console

class LottoBot {
    fun startLotto() {
        receiveBudget()
        receiveWinningNumbers()
        receiveBonusNumbers()
    }

    fun receiveBudget() {
        var flag = true
        while (flag) {
            runCatching {
                println("구입 금액을 입력해주세요")
                val input = Console.readLine()
                val budget = InputValidator.validateBudget(input)
            }
                .onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

    fun receiveWinningNumbers() {
        var flag = true
        while (flag) {
            runCatching {
                println("당첨 번호를 입력해 주세요")
                val input = Console.readLine()
                val winningNumbers = InputValidator.validateWinningNumber(input)
            }
                .onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

    fun receiveBonusNumbers() {
        var flag = true
        while (flag) {
            runCatching {
                println("보너스 번호를 입력해 주세요.")
                val input = Console.readLine()
                val bonusNumber = InputValidator.validateBonusNumber(input)
            }.onSuccess { flag = false }
                .onFailure { exception -> println(exception.message) }
        }
    }

}