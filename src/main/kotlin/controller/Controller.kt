package controller

import lottonumbercomparator.LottoNumberComparator
import lottonumbergenerator.LottoNumberGenerator
import lottopurchaseamount.LottoPurchaseAmount
import lottoranking.LottoRanking
import lottoreturns.LottoReturns
import lottoreturns.LottoReturnsImpl
import view.InputView
import view.OutputView
import winningnumber.WinningNumber

class Controller(
    private val lottoNumberGenerator: LottoNumberGenerator,
    private val lottoNumberComparator: LottoNumberComparator,
) {
    private lateinit var lottoPurchaseAmount: LottoPurchaseAmount

    fun startLotto() {
        purchaseLotto()
        val winningNumber = enterWinningNumber()
        winningResult(winningNumber)
    }

    private fun purchaseLotto() {
        OutputView.pleaseEnterPurchaseAmount()
        lottoPurchaseAmount = LottoPurchaseAmount(InputView.lottoPurchaseAmount())
        OutputView.purchasedIssuedLottoTickets(lottoPurchaseAmount.money)
        lottoNumberGenerator.generateLotto(lottoPurchaseAmount.money / 1000)
        lottoNumberGenerator.lottoes.forEach {
            OutputView.purchasedIssuedLottery(it)
        }
    }

    private fun enterWinningNumber(): WinningNumber {
        OutputView.pleaseEnterWinningNumber()
        val lottoNumber = InputView.lottoNumber()

        OutputView.pleaseEnterBonusNumber()
        val bonusNumber = InputView.bonusNumber(lottoNumber)

        return WinningNumber(lottoNumber, bonusNumber)
    }

    private fun winningResult(winningNumber: WinningNumber) {
        OutputView.winningStatistics()
        OutputView.threeDotLine()
        lottoNumberGenerator.lottoes.forEach {
            lottoNumberComparator.compare(winningNumber, it)
        }
        LottoRanking.entries.forEach {
            OutputView.winningMatchResult(it)
        }

        val lottoReturns: LottoReturns = LottoReturnsImpl()
        OutputView.totalReturn(lottoReturns.calculate(lottoPurchaseAmount))
    }
}