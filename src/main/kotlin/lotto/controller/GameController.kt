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
        GameResult.entries.forEach { matchResults[it] = LottoRule.INIT_NUM.num }
    }

    fun startGame() {
        messenger.printInputPrice()
        var number = LottoRule.NULL_NUM.num
        while (number == LottoRule.NULL_NUM.num) number = inputManager.inputPurchaseCost()
        repeat(number) { lottoBundle.add(lottoManager.purchaseLotto()) }

        messenger.apply {
            println()
            printPurchaseAmount(number)
            repeat(number) { printPurchaseLottoNumber(lottoBundle[it].getLottoNumbers()) }
            println()
        }
    }

    fun settingWinningNumbers() {
        val winningNumber = getWinningNumbers()
        val bonusNumber = getBonusNumber(winningNumber)
        winningLotto = WinningLotto(winningNumber, bonusNumber)
    }

    fun matchWinningLotto() {
        lottoBundle.forEach { lotto ->
            lottoManager.apply {
                val matchCount = winningLotto.getWinningNumber(lotto.changeLottoNumbersToSet())
                var currentGameResult = getMathResult(matchCount)
                currentGameResult = checkBonusResult(currentGameResult, winningLotto, lotto)
                currentGameResult?.let { saveGameResult(it) }
            }
        }
    }

    fun endGame() {
        messenger.printLottoResult()
        GameResult.entries.forEach { gameResult ->
            matchResults[gameResult]?.let {
                messenger.printGameResult(gameResult.getResultComment(it))
            }
        }
        messenger.printTotalReturnRate(
            lottoManager.calculateResult(
                getPurchasePrice(),
                getTotalProceeds()
            )
        )
    }

    private fun getWinningNumbers(): Set<Int> {
        messenger.printInputLottoNumber()
        var winningNumber: Set<Int> = setOf()
        while (winningNumber.isEmpty()) winningNumber = inputManager.inputLottoWinningNumber()
        println()
        return winningNumber
    }

    private fun getBonusNumber(winningNumber: Set<Int>): Int {
        messenger.printInputBonusNumber()
        var bonusNumber: Int = LottoRule.NULL_NUM.num
        while (bonusNumber == LottoRule.NULL_NUM.num)
            bonusNumber = inputManager.inputBonusNumber(winningNumber)
        println()
        return bonusNumber
    }

    private fun saveGameResult(gameResult: GameResult) {
        matchResults[gameResult] =
            (matchResults[gameResult] ?: LottoRule.INIT_NUM.num) + LottoRule.ADD_NUM.num
    }

    private fun getPurchasePrice() = lottoBundle.size * LottoRule.PRICE.num

    private fun getTotalProceeds(): Int =
        GameResult.entries.sumOf {
            (matchResults[it] ?: LottoRule.INIT_NUM.num) * it.price
        }
}