package lotto.controller

import lotto.model.LottoRepository
import lotto.view.*

class LottoController {
    private val input: Input = Input()
    private val output: Output = Output()
    private val lottoRepository = LottoRepository()

    fun startGame(){
        output.startGameNotice()
        val lottoTicketsNum = input.getlottoTicketsNum()
        val autoLottoTickets = lottoRepository.generateAutoLottoTickets(lottoTicketsNum)
        output.showLottoTickets(autoLottoTickets)

        output.getWinningInfoNotice()
        val winningLottoInfo = input.getwinningLottoInfo()

        output.getBonusInfoNotice()
        val bonusInfo = input.getbonusInfo()

        val lottoResult = lottoRepository.calculateLottoResult(lottoTicketsNum, autoLottoTickets, winningLottoInfo, bonusInfo)
        output.showResult(lottoResult)
    }



}