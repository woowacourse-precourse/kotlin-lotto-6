package lotto

import lotto.constants.WinningResult
import lotto.io.input.Input
import lotto.io.output.Output
import lotto.model.Lotto
import lotto.model.Lottos
import lotto.model.WinningLotto

class LottoController(
    private val input: Input,
    private val output: Output,
    private val lottoSupplier: LottoSupplier
) {
    private val winningCounts = mutableMapOf<WinningResult, Int>()
    private var totalWinningAmount = 0

    fun getWinningResult(lotto: Lotto, winningLotto: WinningLotto): WinningResult {
        val count = lotto.countMatchingNumber(winningLotto.lotto)

        return when (count) {
            3 -> WinningResult.THREE
            4 -> WinningResult.FOUR
            5 -> {
                if (lotto.isMatchingBonus(winningLotto.bonus)) {
                    WinningResult.FIVE_BONUS
                } else {
                    WinningResult.FIVE
                }
            }

            6 -> WinningResult.SIX
            else -> WinningResult.NOT_WINNING
        }
    }

}