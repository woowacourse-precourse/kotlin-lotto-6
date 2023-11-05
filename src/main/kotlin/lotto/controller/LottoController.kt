package lotto.controller

import lotto.domain.User
import lotto.domain.WinResult
import lotto.domain.WinningLotto
import lotto.service.UserService
import lotto.service.WinResultService
import lotto.service.WinningLottoService

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