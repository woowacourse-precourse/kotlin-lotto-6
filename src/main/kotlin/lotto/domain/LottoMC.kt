package lotto.domain

import lotto.view.InputView

class LottoMC(private val inputView: InputView) {
    fun pickLottoNum(): List<Int> {
        val lottoNum = inputView.inputView().replace(" ", "")
        val numbers = lottoNum.split(",").map { it.trim().toInt() }

        validateLottoNumbers(numbers)

        return numbers
    }

    fun pickBonusNum(): String {
        val bonusNum = inputView.inputView().trim()

        validateBonusNumber(bonusNum)

        return bonusNum
    }

    private fun validateLottoNumbers(numbers: List<Int>) {
        if (numbers.size != 6) {
            throw IllegalArgumentException("로또 번호는 6개여야 합니다.")
        }

        if (numbers.any { it.toInt() !in 1..45 }) {
            throw IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    private fun validateBonusNumber(number: String) {
        if (number.toInt() !in 1..45) {
            throw IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }
}