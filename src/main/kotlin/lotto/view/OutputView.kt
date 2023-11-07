package lotto.view

import lotto.model.LottoProfit
import lotto.model.LottoRankings
import lotto.model.LottoTicket
import lotto.model.Purchase
import lotto.util.Constants.RANKING_1ST_INDEX
import lotto.util.Constants.RANKING_2ST_INDEX
import lotto.util.Constants.RANKING_3ST_INDEX
import lotto.util.Constants.RANKING_4ST_INDEX
import lotto.util.Constants.RANKING_5ST_INDEX

class OutputView {
    fun printGameStartMessage() = println("구입금액을 입력해 주세요.")


    fun printPurchaseCount(purchase: Purchase) {
        println() //예제 출력과 같게 하기 위해 공백 추가
        println("${purchase.count}개를 구매했습니다.")
    }

    fun printLottoTicket(lottoTicket: LottoTicket) {
        lottoTicket.numbers.forEach {
            println(it)
        }
    }

    fun printLottoPurchaseInfoMessage() {
        println() //예제 출력과 같게 하기 위해 공백 추가
        println("당첨 번호를 입력해 주세요.")
    }

    fun printBonusLottoInfoMessage() {
        println() //예제 출력과 같게 하기 위해 공백 추가
        println("보너스 번호를 입력해 주세요.")
    }

    fun printLottoStatistics(lottoRankings: LottoRankings) {
        val rankings = lottoRankings.rank
        println() // 예제 출력과 같게하기 위하여 사용
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${rankings[RANKING_5ST_INDEX]}개")
        println("4개 일치 (50,000원) - ${rankings[RANKING_4ST_INDEX]}개")
        println("5개 일치 (1,500,000원) - ${rankings[RANKING_3ST_INDEX]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${rankings[RANKING_2ST_INDEX]}개")
        println("6개 일치 (2,000,000,000원) - ${rankings[RANKING_1ST_INDEX]}개")
    }

    fun printLottoProfitRate(lottoProfit: LottoProfit) = println("총 수익률은 ${lottoProfit.rate}%입니다.")
}