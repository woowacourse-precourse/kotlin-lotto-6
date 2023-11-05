package lotto.ui

import camp.nextstep.edu.missionutils.Console
import lotto.data.repository.LottoRepositoryImpl
import lotto.ui.repository.LottoRepository
import lotto.ui.viewmodel.LottoViewModel
import lotto.utils.CommonConst
import lotto.utils.Exceptions
import lotto.utils.GameUtils

class LottoGame {
    private val repository: LottoRepository = LottoRepositoryImpl()
    private val viewModel = LottoViewModel(repository)

    
    private fun generateRandomLotto(amount: Int) {
        viewModel.generateRandomLotto(amount).also {
            for (lotto in it) {
                println("[${lotto.joinToString(", ")}]")
            }
        }
    }

    private fun inputPurchaseAmount(): Int {
        while (true) {
            try {
                val input = Console.readLine()
                return GameUtils.divideByThousand(Exceptions.validatePurchaseAmount(input) ?: continue)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputWinningNumbers(): List<Int> {
        while (true) {
            try {
                val input = Console.readLine()
                return GameUtils.parseToInt(Exceptions.validateWinningNumbers(input) ?: continue)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun inputBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            val input = Console.readLine()
            return Exceptions.validateBonusNumber(input, winningNumbers) ?: continue
        }
    }

}