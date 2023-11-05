package lotto.controller

import lotto.model.User
import lotto.model.WinResult
import lotto.model.WinningLotto
import lotto.service.UserService
import lotto.service.WinningLottoService
import lotto.view.InputView
import lotto.view.OutputView
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal

class LottoController(
    private val inputView: InputView = InputView(),
    private val outPutView: OutputView = OutputView(),
    private val userService: UserService = UserService(),
    private val winningLottoService: WinningLottoService = WinningLottoService()
) {

    private lateinit var user : User
    private lateinit var winningLotto : WinningLotto
    private lateinit var winResult :WinResult
    fun run() {
        user = userService.makeUser()
        winningLotto = winningLottoService.makeWinningLotto()
        winResult = WinResult(user,winningLotto)
        outPutView.printWinStatisticsMessage()
        calculateResult()
        outPutView.printWinStatisticsResult(winResult.placeResult)
        calculateEarningRate()
        outPutView.printTotalEarningRate(winResult.earningRate)
    }


    private fun calculateResult() {
        winResult.calculateResult()
    }

    private fun calculateEarningRate() {
        winResult.calculateEarningRate()
    }
}