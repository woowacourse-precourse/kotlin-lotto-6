package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMC
import lotto.domain.LottoPrice
import lotto.utils.RandomUtils
import lotto.view.InputView
import lotto.view.OutputView

class LottoShop {

    private val inputView = InputView()
    private val randomUtils = RandomUtils()
    private val lottoMC = LottoMC()
    private val outputView = OutputView()

    private val lottos = mutableListOf<Lotto>()
    private val matchCounts = mutableMapOf<LottoPrice, Int>()

    fun buyLotto() {
        inputView.buyMessage()
        val price = getPrice()
        generateAndPrintAutoLottos(price)
        checkAndPrintLottoWinningNum(price)
    }

    private fun getPrice(): Int {
        while (true) {
            try {
                val price = inputView.inputValue()
                validatePrice(price)
                return price.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validatePrice(price: String) {
        require(price.isNotBlank()) { ERROR_PRICE_BLANK }
        require(price.all { it.isDigit() }) { ERROR_PRICE_NOT_NUM }
        require(price.toInt() % PRICE_DIVIDING_UNIT == DEFAULT_VALUE) { ERROR_PRICE_NOT_1000_UNIT }
        require(price.toInt() <= PRICE_LIMIT) { ERROR_PRICE_LIMIT }
    }

    private fun generateAndPrintAutoLottos(price: Int) {
        val lottoCount = price / PRICE_DIVIDING_UNIT
        outputView.printLottoCount(lottoCount)
        repeat(lottoCount) {
            val numbers = randomUtils.pickLottoNum()
            val lotto = Lotto(numbers.sorted())
            lottos.add(lotto)
            println(lotto)
        }
    }

    private fun checkAndPrintLottoWinningNum(price: Int) {
        val lottoNum = getLottoNum()
        val bonusNum = getBonusNum(lottoNum)
        checkLottoCorrect(lottoNum, bonusNum, price)
    }

    private fun getLottoNum(): List<Int> {
        inputView.lottoMessage()
        while (true) {
            try {
                val inputLottoNum = inputView.inputValue()
                return lottoMC.pickLottoNum(inputLottoNum)
            } catch (e: IllegalArgumentException) {
                e.message?.let { outputView.printErrorMessage(it) }
            }
        }
    }

    private fun getBonusNum(lottoNum: List<Int>): String {
        inputView.bonusMessage()
        while (true) {
            try {
                val inputBonusNum = inputView.inputValue()
                return lottoMC.pickBonusNum(inputBonusNum, lottoNum)
            } catch (e: IllegalArgumentException) {
                e.message?.let { outputView.printErrorMessage(it) }
            }
        }
    }

    private fun checkLottoCorrect(lottoNum: List<Int>, bonusNum: String, price: Int) {
        for (lotto in lottos) {
            val correctCnt = lotto.getNumbers().intersect(lottoNum.toSet()).size
            val bonusCnt = lotto.getNumbers().contains(bonusNum.toInt())
            updateMatchCount(correctCnt, bonusCnt)
        }
        printResult(price)
    }

    private fun updateMatchCount(correctCnt: Int, bonusCnt: Boolean) {
        val lottoPrice = LottoPrice.values()
            .firstOrNull { it.matchCount == correctCnt && !(it == LottoPrice.BONUS_MATCH && !bonusCnt) }
        if (lottoPrice != null) {
            matchCounts[lottoPrice] = (matchCounts[lottoPrice] ?: 0) + ONE_MATCH_INCREMENT
        }
    }

    private fun printResult(price: Int) {
        val totalPrize = LottoPrice.values().sumOf { (matchCounts[it] ?: 0) * it.price }
        val earningRate = ((totalPrize.toDouble() / price.toDouble()) * PERCENTAGE)
        val roundedEarningRate = String.format("%.1f", earningRate).toDouble()
        outputView.printLottoResult(matchCounts, roundedEarningRate)
    }

    companion object {
        const val PRICE_DIVIDING_UNIT = 1000
        const val DEFAULT_VALUE = 0
        const val PRICE_LIMIT = 100_000
        const val ONE_MATCH_INCREMENT = 1
        const val PERCENTAGE = 100
        const val ERROR_PRICE_ENTER = "[ERROR] 로또 구입 금액을 입력하세요"
        const val ERROR_PRICE_BLANK = "[ERROR] 로또 구입 금액은 천원 이상으로 입력 가능합니다."
        const val ERROR_PRICE_NOT_NUM = "[ERROR] 로또 구입 금액은 숫자로만 입력 가능합니다."
        const val ERROR_PRICE_NOT_1000_UNIT = "[ERROR] 로또 구입 금액은 천원 단위로만 입력 가능합니다."
        const val ERROR_PRICE_LIMIT = "[ERROR] 로또 구입은 10만원까지만 가능합니다."
    }
}