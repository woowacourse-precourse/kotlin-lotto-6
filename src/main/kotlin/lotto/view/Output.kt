package lotto.view

import java.math.BigDecimal

class Output {

    fun outputLottos(lottoList: List<List<Int>>) {
        println()
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach { println(it) }
    }

    fun outputMatchCount(matchCountList: MutableList<Int>) {
        println()
        println("3개 일치 (5,000원) - ${matchCountList[0]}개")
        println("4개 일치 (50,000원) - ${matchCountList[1]}개")
        println("5개 일치 (1,500,000원) - ${matchCountList[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${matchCountList[3]}개")
        println("6개 일치 (2,000,000,000원) - ${matchCountList[4]}개")
    }

    fun outputProfitability(profitability : BigDecimal){
        println("총 수익률은 $profitability%입니다.")
    }
}

