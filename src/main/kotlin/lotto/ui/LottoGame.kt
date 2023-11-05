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
}