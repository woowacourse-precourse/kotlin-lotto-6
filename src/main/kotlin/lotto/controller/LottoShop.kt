package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMC
import lotto.domain.Validator
import lotto.utils.RandomUtils
import lotto.view.InputView

class LottoShop {

    private val inputView = InputView()
    private val validator = Validator()
    private val randomUtils = RandomUtils()
    private val lottoMC = LottoMC(inputView)

    private val lottos = mutableListOf<Lotto>()

    private var threeMatch = 0
    private var fourMatch = 0
    private var fiveMatch = 0
    private var bonusMatch = 0
    private var sixMatch = 0

    fun buyLotto() {
        inputView.buyMessage()
        val price = inputView.inputView()
        validator.validatePrice(price)
        val lottoCount = price.toInt() / 1000
        repeat(lottoCount) {
            val numbers = randomUtils.pickLottoNum()
            val lotto: Lotto = Lotto(numbers.sorted())
            lottos.add(lotto)
            println(lotto)
        }
        startLottoProgram()
        printResult()
    }

    private fun startLottoProgram() {
        val lottoNum = lottoMC.pickLottoNum()
        validator.validateLottoNum(lottoNum)
        val bonusNum = lottoMC.pickBonusNum()
        validator.validateBonusNum(bonusNum, lottoNum)
        checkLottoCorrect(lottoNum, bonusNum)
    }

    private fun checkLottoCorrect(lottoNum: List<String>, bonusNum: String) {
        for (lotto in lottos) {
            val correctCnt = lotto.getNumbers().intersect(lottoNum.toSet()).size
            val bonusCnt = lotto.getNumbers().contains(bonusNum.toInt())
            lottoResult(correctCnt, bonusCnt)
        }
    }

    private fun lottoResult(correctCnt: Int, bonusCnt: Boolean) {
        when (correctCnt) {
            3 -> threeMatch++
            4 -> fourMatch++
            5 -> if (bonusCnt) {
                bonusMatch++
            } else {
                fiveMatch++
            }

            6 -> sixMatch++
        }
    }

    private fun printResult() {
        println(threeMatch)
        println(fourMatch)
        println(fiveMatch)
        println(bonusMatch)
        println(sixMatch)
    }
}