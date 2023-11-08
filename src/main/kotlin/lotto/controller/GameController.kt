package lotto.controller

import lotto.domain.GameResult
import lotto.domain.InputManager
import lotto.domain.LottoManager
import lotto.domain.MessageManager
import lotto.model.Lotto
import lotto.model.WinningLotto

object GameController {
    private val lottos: MutableList<Lotto> = mutableListOf()
    private var winningLotto: WinningLotto? = null
    private val inputManager = InputManager()
    private val lottoManager = LottoManager()
    private val messenger = MessageManager()


    fun gameStart() {
        messenger.printInputPrice()
        var number: Int? = null
        while (number == null) number = inputManager.inputPurchaseCost()
        repeat(number) { lottos.add(lottoManager.purchaseLotto()) }
        messenger.apply {
            println()
            printPurchaseAmount(number)
            repeat(number) { printPurchaseLottoNumber(lottos[it].getLottoNumbers()) }
            println()
        }
    }

    fun settingWinningNumbers() {
        messenger.printInputLottoNumber()
        var winningNumber: Set<Int>? = null
        var bonusNumber: Int? = null
        while (winningNumber == null) winningNumber = inputManager.inputLottoWinningNumber()
        println()
        messenger.printInputBonusNumber()
        while (bonusNumber == null) bonusNumber = inputManager.inputBonusNumber(winningNumber)
        println()
        winningLotto = WinningLotto(winningNumber, bonusNumber)
    }

    fun gameResult(){
        messenger.printLottoResult()

    }
}