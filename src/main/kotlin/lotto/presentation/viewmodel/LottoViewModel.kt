package lotto.presentation.viewmodel

import lotto.domain.model.Customer
import lotto.domain.model.Winning
import lotto.domain.service.LottoCalculator
import lotto.domain.service.LottoService
import lotto.domain.service.WinningCalculator

class LottoViewModel(private val winning: Winning,private val customer: Customer) {
    val lottoCalculator = LottoCalculator(winning)
    val lottoService = LottoService()
    val winningCalculator = WinningCalculator(winning,customer)


}