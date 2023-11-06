package lotto

import lotto.model.BallMachine
import lotto.model.User
import lotto.service.LottoService
import lotto.util.Util
import lotto.view.Message

class Controller {

    private val user = User()
    private val ballMachine = BallMachine()
    private val lottoService = LottoService(user, ballMachine)

    fun startLotto() {
        buyLotto()
        openLotto()
        setWinningNumber()
        setBonusNumber()
        showLottoResult()

    }

    private fun buyLotto() {
        lottoService.giveMoney()
    }

    private fun openLotto() {
        lottoService.getLottoTickets()

        user.lottoTickets.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    private fun setWinningNumber() {
        lottoService.setWinningNumbers()
    }

    private fun setBonusNumber() {
        lottoService.setBonusNumber()

    }

    private fun showLottoResult() {
        println(Message.WINNING_STATISTICS.message)
        println(Message.SEPARATION_LINE.message)

        lottoService.compareLottoNumber()

        for ((key, value) in user.lottoResult) {
            println("$key${value}개")
        }

        lottoService.setTotalPrize()

        val roi = Util.getRoi(user.money, user.totalPrize)
        println("${Message.OUTPUT_TOTAL_ROI.message}${roi}%입니다.")
    }

}