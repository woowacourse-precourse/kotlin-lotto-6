package lotto.controller

import lotto.domain.User
import lotto.domain.WinResult
import lotto.domain.WinningLotto
import lotto.service.UserService
import lotto.service.WinResultService
import lotto.service.WinningLottoService
import lotto.util.Constant.INPUT_PRICE_UNIT_ERROR_MESSAGE
import lotto.util.Constant.UNIT_PRICE
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
        winningLotto = winningLottoService.makeWinningLotto()
        winResult = winResultService.makeWinResult(user, winningLotto)
    }

    private fun buyLotto() {
        try {
            val price = inputView.inputPrice()
            require(price % UNIT_PRICE == 0) { INPUT_PRICE_UNIT_ERROR_MESSAGE }
            user = userService.makeUser(price)
        } catch (e:IllegalArgumentException){
            println(e.message)
            buyLotto()
        }
    }
}