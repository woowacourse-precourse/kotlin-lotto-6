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

    private var threeMatch = 0
    private var fourMatch = 0
    private var fiveMatch = 0
    private var bonusMatch = 0
    private var sixMatch = 0
    private var noMatch = 0

    fun buyLotto() {
        inputView.buyMessage()
        while (true) {
            try {
                val price = inputView.inputView()
                validatePrice(price)
                val lottoCount = price.toInt() / 1000
                outputView.printLottoCount(lottoCount)
                repeat(lottoCount) {
                    val numbers = randomUtils.pickLottoNum()
                    val lotto: Lotto = Lotto(numbers.sorted())
                    lottos.add(lotto)
                    println(lotto)
                }
                startLottoProgram(price.toInt())
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun validatePrice(price: String) {
        require(price.isNotBlank()) { "[ERROR] 로또 구입 금액은 천원 이상으로 입력 가능합니다." }
        require(price.all { it.isDigit() }) { "[ERROR] 로또 구입 금액은 숫자로만 입력 가능합니다." }
        require(price.toInt() % 1000 == 0) { "[ERROR] 로또 구입 금액은 천원 단위로만 입력 가능합니다." }
    }

    private fun startLottoProgram(price: Int) {
        inputView.lottoMessage()
        var lottoNum: List<Int>
        while (true) {
            try {
                val inputLottoNum = inputView.inputView()
                lottoNum = lottoMC.pickLottoNum(inputLottoNum)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        var bonusNum: String
        inputView.bonusMessage()
        while (true) {
            try {
                val inputBonusNumm = inputView.inputView()
                bonusNum = lottoMC.pickBonusNum(inputBonusNumm, lottoNum)
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        checkLottoCorrect(lottoNum, bonusNum, price)
    }

    private fun checkLottoCorrect(lottoNum: List<Int>, bonusNum: String, price: Int) {
        for (lotto in lottos) {
            val correctCnt = lotto.getNumbers().intersect(lottoNum.toSet()).size
            val bonusCnt = lotto.getNumbers().contains(bonusNum.toInt())
            lottoResult(correctCnt, bonusCnt)
        }
        printResult(threeMatch, fourMatch, fiveMatch, bonusMatch, sixMatch, price)
    }

    private fun lottoResult(correctCnt: Int, bonusCnt: Boolean) {
        when (LottoPrice.values()
            .firstOrNull { it.matchCount == correctCnt && !(it == LottoPrice.BONUS_MATCH && !bonusCnt) }) {
            LottoPrice.THREE_MATCH -> threeMatch++
            LottoPrice.FOUR_MATCH -> fourMatch++
            LottoPrice.FIVE_MATCH -> fiveMatch++
            LottoPrice.BONUS_MATCH -> bonusMatch++
            LottoPrice.SIX_MATCH -> sixMatch++
            else -> noMatch++
        }
    }

    private fun printResult(
        threeMatch: Int,
        fourMatch: Int,
        fiveMatch: Int,
        bonusMatch: Int,
        sixMatch: Int,
        price: Int,
    ) {
        val totalPrize =
            (threeMatch * LottoPrice.THREE_MATCH.price) + (fourMatch * LottoPrice.FOUR_MATCH.price + fiveMatch * LottoPrice.FIVE_MATCH.price + bonusMatch * LottoPrice.BONUS_MATCH.price + sixMatch * LottoPrice.SIX_MATCH.price)

        val earningRate = ((totalPrize.toDouble() / price.toDouble()) * 100)
        val roundedEarningRate = String.format("%.1f", earningRate).toDouble()
        outputView.printLottoResult(threeMatch, fourMatch, fiveMatch, bonusMatch, sixMatch, roundedEarningRate)
    }
}