package lotto.domain

class LottoCompare {
    fun winning(winningNumbers: String) {
        val winningNumber = winningNumbers.split(",")
            .map { number -> number.toInt() }
        compare(winningNumber)
    }

    fun bonus(bonusNumbers: String) {
        val bonusNumber = bonusNumbers.split(",")
            .map { number -> number.toInt() }
        compareBonus(bonusNumber)
    }

    private fun compare(winningNumber: List<Int>) {

    }

    private fun compareBonus(bonusNumber: List<Int>) {

    }
}