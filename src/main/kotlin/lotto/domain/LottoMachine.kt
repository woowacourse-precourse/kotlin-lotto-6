package lotto.domain

import lotto.validator.BonusNumberValidator
import lotto.validator.WinNumbersValidator
import lotto.view.InputView

class LottoMachine {
    fun drawWinNumbers(): List<String> {
        var attempts = 0
        while (attempts <= 5) {
            try {
                val winNumbers = InputView.promptForWinNumbers().also { println() }
                WinNumbersValidator(winNumbers)
                return winNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

    fun drawBonusNumber(): String {
        var attempts = 0
        while (attempts <= 5) {
            try {
                val bonusNumber = InputView.promptForBonusNumber().also { println() }
                BonusNumberValidator(bonusNumber)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

}
