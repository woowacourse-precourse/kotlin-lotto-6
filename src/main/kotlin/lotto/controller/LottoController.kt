package lotto.controller

import lotto.model.Lotto
import lotto.model.LottoRepository
import lotto.view.*

class LottoController {
    private val input: Input = Input()
    private val output: Output = Output()
    private val lottoRepository = LottoRepository()

    fun startGame(){
        output.startGameNotice()
        val lottoTicketsNum = input.getlottoTicketsNum()
        val generatedAutoLottoTickets = lottoRepository.generateAutoLottoTickets(lottoTicketsNum)
        output.showLottoTickets(generatedAutoLottoTickets)

        output.getWinningInfoNotice()
        val winningLottoInfo = input.getwinningLottoInfo()

        output.getBonusInfoNotice()
        val bonusInfo = input.getbonusInfo()

        output.showResult(generatedAutoLottoTickets, winningLottoInfo, bonusInfo)
    }



}