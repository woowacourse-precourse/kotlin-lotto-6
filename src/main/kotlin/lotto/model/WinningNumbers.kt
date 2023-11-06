package lotto.model

import lotto.Constants

class WinningNumbers(
    _winningNumbers: String,
) {
    val numbers: List<LottoNumber>

    init {
        validateSize(_winningNumbers)

        val _winningNumbersSplit = _winningNumbers.split(",")
        validateDuplicate(_winningNumbersSplit)

        numbers = List(Constants.LOTTO_NUMBER_SIZE) {
            LottoNumber(_winningNumbersSplit[it])
        }
    }

    private fun validateSize(_winningNumbers: String) {
        val commaCount = _winningNumbers.count { it == ',' }
        require(commaCount == Constants.LOTTO_NUMBER_SIZE - 1) {
            "당첨 번호는 6개여야 합니다."
        }
    }

    private fun validateDuplicate(temp: List<String>) {
        require(temp.toSet().size == Constants.LOTTO_NUMBER_SIZE) {
            "당첨 번호는 중복될 수 없습니다."
        }
    }
}

data class BonusNumber(
    private val _bonus: String
) {
    val number get() = LottoNumber(_bonus)
}
