package lotto.controller

import lotto.domain.User
import lotto.domain.WinResult
import lotto.domain.WinningLotto
import lotto.service.UserService
import lotto.service.WinResultService
import lotto.service.WinningLottoService
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
    private val userService: UserService = UserService(),
    private val winningLottoService: WinningLottoService = WinningLottoService(),
    private val winResultService: WinResultService = WinResultService()
) {

    private lateinit var user: User
    private lateinit var winningLotto: WinningLotto
    private lateinit var winResult: WinResult
    fun run() {
        outputView.printInputPrice()
        buyLotto()
        outputView.printBuyLotto(user.getPrice())
        outputView.printUserLotto(user.getLottoes())
        outputView.printInputLuckyNumber()
        inputWinningNumber()
        outputView.printInputBonusNumber()
        inputBonusNumber()
        outputView.printWinStatisticsMessage()
        calculateWinResult()
    }

    private fun buyLotto() {
        try {
            val price = inputView.inputPrice()
            user = userService.makeUser(price)
        } catch (e:IllegalArgumentException){
            println(e.message)
            buyLotto()
        }
    }
    private fun inputWinningNumber() {
        try {
            val winningNumbers = inputView.inputLuckyNumber()
            winningLottoService.setWinningNumbers(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputWinningNumber()
        }
    }
    private fun inputBonusNumber() {
        try {
            val bonusNumber = inputView.inputBonusNumber()
            winningLottoService.setBonusNumber(bonusNumber)
            winningLotto = winningLottoService.makeWinningLotto()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber()
        }
    }
    private fun calculateWinResult(){
        winResult = winResultService.makeWinResult(user,winningLotto)
        outputView.printWinStatisticsResult(winResult.getPlaceResult())
        outputView.printTotalEarningRate(winResult.getEarningRate())
    }
}