package lotto.presentation.viewmodel

import lotto.domain.model.Customer
import lotto.domain.model.Winning
import lotto.domain.service.LottoCalculator
import lotto.domain.service.LottoService
import lotto.domain.service.WinningCalculator

class LottoViewModel {
    lateinit var winning: Winning
    lateinit var customer: Customer
    val lottoCalculator = LottoCalculator(winning)
    val lottoService = LottoService()
    val winningCalculator = WinningCalculator(winning,customer)

    fun initialWinning(winningNumbers:List<Int>,bonusNumber:Int){
        winning = Winning(winningNumbers,bonusNumber)
    }

    fun initialCustomer(){
        customer = Customer()
    }

}