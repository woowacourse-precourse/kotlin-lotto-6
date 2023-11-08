package lotto

import lotto.model.LottoType

class CompareLotto {
    private val resultPrice = listOf(
        "3개 일치 (5,000원) - ",
        "4개 일치 (50,000원) - ",
        "5개 일치 (1,500,000원) - ",
        "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
        "6개 일치 (2,000,000,000원) - "
    )

    fun compareLotto(
        lottos: List<Lotto>,
        lottoNumber: List<Int>,
        bonusNumber: Int
    ): MutableList<Int> {
        val winningLottosNumber = MutableList(LottoType.entries.size) { 0 }

        lottos.forEach { lotto ->
            val index = when (lotto.compareLottoNumber(lottoNumber)) {
                in 0..2 -> null
                3 -> LottoType.THREE
                4 -> LottoType.FOUR
                5 -> if (lotto.containBonusNumber(bonusNumber)) LottoType.FIVE_BONUS else LottoType.FIVE
                6 -> LottoType.SIX
                else -> throw IllegalArgumentException("유효하지 않은 비교 개수입니다.")
            }
            index?.also {
                winningLottosNumber[it.ordinal]++
            }
        }

        return winningLottosNumber
    }

    fun calculateRateOfReturn(winningLottosNumber: MutableList<Int>, price: Int): Double {
        var profit = 0.0
        val priceList = listOf(5000, 50000, 1500000, 30000000, 2000000000)
        winningLottosNumber.forEachIndexed { index, count ->
            profit += priceList[index] * count
        }
        return profit / price * 100
    }

    fun printResult(winningLottosNumber: MutableList<Int>) {
        winningLottosNumber.forEachIndexed { index, count ->
            println("${resultPrice[index]}${count}개")
        }
    }

    fun printRateOfReturnResult(rateOfReturn: Double) {
        val num = String.format("%.1f", rateOfReturn)
        println("총 수익률은 ${num}%입니다.")
    }
}