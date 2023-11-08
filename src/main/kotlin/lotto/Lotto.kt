package lotto

import lotto.view.WinningPrice

class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun checkLotto(winningNumber: List<Int>, bonusNumber: Int): WinningPrice {
        var count: Int = 0
        var bonus: Boolean = false
        for (i in numbers) {
            if(i in winningNumber) {
                count++
            }
        }
        if (count == 5) {
            if(bonusNumber in numbers) {
                bonus = true
            }
        }

        when(count) {
            3 -> return WinningPrice.THREE
            4 -> return WinningPrice.FOUR
            5 -> {
                if(bonus) {
                    return WinningPrice.FIVE_AND_BONUS
                }
                return WinningPrice.FIVE
            }
            6 -> return WinningPrice.SIX
            else -> return WinningPrice.NONE
        }
    }
}
