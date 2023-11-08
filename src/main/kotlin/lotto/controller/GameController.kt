package lotto.controller

import lotto.domain.GameResult
import lotto.domain.InputManager
import lotto.domain.LottoManager
import lotto.domain.MessageManager
import lotto.model.Lotto
import lotto.model.WinningLotto

object GameController {

    private val inputManager = InputManager()
    private val lottoManager = LottoManager()
    private val messenger = MessageManager()

    private val lottoBundle: MutableList<Lotto> = mutableListOf()
    private val matchResults = mutableMapOf<GameResult, Int>()
    private lateinit var winningLotto: WinningLotto

    init {
        GameResult.entries.forEach { matchResults[it] = 0 }
    }

    fun startGame() {
        messenger.printInputPrice()
        var number: Int = -1
        while (number == -1) number = inputManager.inputPurchaseCost()
        repeat(number) { lottoBundle.add(lottoManager.purchaseLotto()) }
        messenger.apply {
            println()
            printPurchaseAmount(number)
            repeat(number) { printPurchaseLottoNumber(lottoBundle[it].getLottoNumbers()) }
            println()
        }
    }

    fun settingWinningNumbers() {
        messenger.printInputLottoNumber()
        var winningNumber: Set<Int> = setOf()
        var bonusNumber: Int = -1
        while (winningNumber.isEmpty()) winningNumber = inputManager.inputLottoWinningNumber()
        println()
        messenger.printInputBonusNumber()
        while (bonusNumber == -1) bonusNumber = inputManager.inputBonusNumber(winningNumber)
        println()
        winningLotto = WinningLotto(winningNumber, bonusNumber)
    }

    fun matchWinningLotto() {
        for (lotto in lottoBundle) {
            val matchCount = winningLotto.getWinningNumber(lotto.changeLottoNumbersToSet())
            lottoManager.apply {
                var currentGameResult = getMathResult(matchCount)
                currentGameResult?.let { gameResult ->
                    currentGameResult = if (isBonusResult(gameResult)) {
                        getMathBonusResult(
                            winningLotto
                                .checkWinningBonusNumber(
                                    lotto.changeLottoNumbersToSet()
                                )
                        )
                    } else {
                        gameResult
                    }
                    matchResults[currentGameResult]?.plus(1)
                }

            }
        }
    }

    fun endGame(){
        messenger.printLottoResult()
        GameResult.entries.forEach {gameResult ->
            matchResults[gameResult]?.let {
                gameResult.getResultComment(it)
            }
        }
    }

}