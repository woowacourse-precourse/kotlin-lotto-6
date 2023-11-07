package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoMC
import lotto.utils.RandomUtils
import lotto.view.InputView
import lotto.view.OutputView

class LottoShop {

    private val inputView = InputView()
    private val randomUtils = RandomUtils()
    private val lottoMC = LottoMC(inputView)
    private val outputView = OutputView()

    private val lottos = mutableListOf<Lotto>()

    private var threeMatch = 0
    private var fourMatch = 0
    private var fiveMatch = 0
    private var bonusMatch = 0
    private var sixMatch = 0

    fun buyLotto() {
        inputView.buyMessage()
        while (true) {
            try {
                val price = inputView.inputView()
                validatePrice(price)
                val lottoCount = price.toInt() / 1000
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
        require(price.isNotBlank())
        require(price.all { it.isDigit() })
        require(price.toInt() % 1000 == 0)
    }

    private fun startLottoProgram(price: Int) {
        inputView.lottoMessage()

        var lottoNum: List<Int>
        while (true) {
            try {
                lottoNum = lottoMC.pickLottoNum()
                break
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

        var bonusNum: String
        while (true) {
            try {
                bonusNum = lottoMC.pickBonusNum(lottoNum)
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
            println("lotto.getNumbers() type: ${lotto.getNumbers()::class.simpleName}, lottoNum.toSet() type: ${lottoNum.toSet()::class.simpleName}")  // 로그 추가
            println("lottoNum: $lottoNum, lotto: ${lotto.getNumbers()}, bonusNum: $bonusNum, correctCnt: $correctCnt, bonusCnt: $bonusCnt")
            lottoResult(correctCnt, bonusCnt)
        }
        printResult(threeMatch, fourMatch, fiveMatch, bonusMatch, sixMatch, price)
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

    private fun printResult(
        threeMatch: Int,
        fourMatch: Int,
        fiveMatch: Int,
        bonusMatch: Int,
        sixMatch: Int,
        price: Int,
    ) {
        val totalPrize =
            (threeMatch * THREE_MATCH_PRIZE) + (fourMatch * FOUR_MATCH_PRIZE) + (fiveMatch * FIVE_MATCH_PRIZE) + (bonusMatch * BONUS_MATCH_PRIZE) + (sixMatch * SIX_MATCH_PRIZE)

        val earningRate = ((totalPrize.toDouble() / price.toDouble()) * 100)
        val roundedEarningRate = String.format("%.1f", earningRate).toDouble()
        println(earningRate)
        println(roundedEarningRate)
        outputView.printLottoResult(threeMatch, fourMatch, fiveMatch, bonusMatch, sixMatch, roundedEarningRate)
    }


    companion object {
        const val THREE_MATCH_PRIZE = 5_000
        const val FOUR_MATCH_PRIZE = 50_000
        const val FIVE_MATCH_PRIZE = 1_500_000
        const val BONUS_MATCH_PRIZE = 30_000_000
        const val SIX_MATCH_PRIZE = 2_000_000_000
    }

}
