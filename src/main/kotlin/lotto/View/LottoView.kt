package lotto.View
import lotto.Controller.LottoGame
import lotto.Model.Lotto
object LottoView {
    fun printPurchasePrompt(){
        println("구입금액을 입력해 주세요.")
    }
    fun printLottoPurchase(count : Int) {
        println()
        println ("${count}개를 구매했습니다.")
    }

    fun printLottoNumbers(lottoTickets : List<Lotto>) {
        for (ticket in lottoTickets) {
            println(ticket.getNumbers().sorted())
        }
        println()
    }
    fun printWinningStatistics(statistics :Map<Int,Int> , revenueRate:Double){
        println()
        println("당첨 통계")
        println("---")
        statistics[3]?.let { println("3개 일치 (5,000원) - ${it}개") }
        statistics[4]?.let { println("4개 일치 (50,000원) - ${it}개") }
        statistics[5]?.let { println("5개 일치 (1,500,000원) - ${it}개") }
        statistics[7]?.let { println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${it}개") } // 보너스 볼 일치
        statistics[6]?.let { println("6개 일치 (2,000,000,000원) - ${it}개") } // 6개 일치
        println("총 수익률은 ${String.format("%.2f", revenueRate).toDouble()}%입니다.")

    }
    fun printErrorMessage(message: String) {
        println("[ERROR] $message")
    }
}