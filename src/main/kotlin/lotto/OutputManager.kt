package lotto

import java.text.DecimalFormat

class OutputManager {
    fun printLottoNum(lottosNum: Int) {
        println()
        println("$lottosNum 개를 구매했습니다.")
    }

    fun printLottos(lottoNumber: List<Int>) {
        println("${lottoNumber.sorted()}")
    }

    fun printLottoStatistic(
        firstPlace: Int,
        secondPlace: Int,
        thirdPlace: Int,
        fourthPlace: Int,
        fifthPlace: Int
    ) {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${fifthPlace}개")
        println("4개 일치 (50,000원) - ${fourthPlace}개")
        println("5개 일치 (50,000원) - ${thirdPlace}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${secondPlace}개")
        println("6개 일치 (2,000,000,000원) - ${firstPlace}개")
    }

    fun printRate(rate : Double){
        val decimalFormat = DecimalFormat("#,###.#")
        val profitMargin = decimalFormat.format(rate)
        //val profitMargin = Math.round(rate * 100)
        println("총 수익률은 ${profitMargin}%입니다.")
    }
}