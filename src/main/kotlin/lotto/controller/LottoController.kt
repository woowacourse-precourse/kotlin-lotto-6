package lotto.controller

import lotto.model.User
import lotto.model.WinResult
import lotto.model.WinningLotto
import lotto.service.UserService
import lotto.service.WinResultService
import lotto.service.WinningLottoService
import lotto.view.InputView
import lotto.view.OutputView
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal

class LottoController(
    private val userService: UserService = UserService(),
    private val winningLottoService: WinningLottoService = WinningLottoService(),
    private val winResultService: WinResultService = WinResultService()
) {

    private lateinit var user : User
    private lateinit var winningLotto : WinningLotto
    private lateinit var winResult :WinResult
    fun run() {
        user = userService.makeUser()
        winningLotto = winningLottoService.makeWinningLotto()
        winResult = winResultService.makeWinResult(user,winningLotto)
    }
}