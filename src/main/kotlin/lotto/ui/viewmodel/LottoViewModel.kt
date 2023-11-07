package lotto.ui.viewmodel

import lotto.data.model.LottoWinningNumber
import lotto.data.model.UserLottoState
import lotto.ui.repository.LottoRepository

class LottoViewModel(private val repository: LottoRepository) {

    fun generateRandomLotto(purchaseAmount: Int): List<List<Int>> {
        repository.generateRandomLotto(purchaseAmount).also {
            return it.lottoTickets
        }
    }

    fun checkLottoStatistics(numbers: List<Int>, bonusNumber: Int): UserLottoState {
        repository.checkStatistics(LottoWinningNumber(lottoNumbers = numbers, bonusNumber = bonusNumber)).also {
            return it
        }
    }

}