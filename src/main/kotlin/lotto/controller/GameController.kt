package lotto.controller

import lotto.domain.*
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
        var number = -1
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
                    currentGameResult =
                        if (isBonusResult(gameResult)) {
                            getMathBonusResult(
                                winningLotto
                                    .checkWinningBonusNumber(lotto.changeLottoNumbersToSet())
                            )
                        } else {
                            gameResult
                        }
                    currentGameResult?.let {
                        matchResults[it] = (matchResults[it] ?: 0) + 1
                    }
                }
            }
        }
    }

    fun endGame() {
        messenger.apply {
            printLottoResult()
            GameResult.entries.forEach { gameResult ->
                matchResults[gameResult]?.let {
                    printGameResult(gameResult.getResultComment(it))
                }
            }
            printTotalReturnRate(
                lottoManager.calculateResult(
                    getPurchasePrice(),
                    getTotalProceeds()
                )
            )
        }
    }

    private fun getPurchasePrice() = lottoBundle.size * LottoRule.PRICE.num

    private fun getTotalProceeds(): Int =
        GameResult.entries.sumOf {
            (matchResults[it] ?: 0) * it.price
        }

}