package lotto.model

import lotto.model.validation.LottoNumber
import lotto.util.Converter.toLottoNumbers

class WinningNumbers(_winningNumbers: String) {
    private val lotto: Lotto
    val numbers get() = lotto.numbers

    init {
        val numbers = parseWinningNumbers(_winningNumbers)
        lotto = Lotto(numbers)
    }

    companion object {
        private fun parseWinningNumbers(winningNumbers: String): List<LottoNumber> {
            return winningNumbers.split(",").toLottoNumbers()
        }
    }
}