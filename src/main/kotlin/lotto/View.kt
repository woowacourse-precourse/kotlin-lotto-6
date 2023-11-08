package lotto

class View {

    fun printInputMoney() {
        println("구입금액을 입력해주세요.")
    }

    fun printPurchasedLotto(lottoCount: Int, lottoList: MutableList<Lotto>) {
        println("${lottoCount}개를 구매했습니다.")
        for (lottoNumber in lottoList) {
            println(lottoNumber.getNum())
        }
    }

    fun printInputWinningNum() {
        println("당첨 번호를 입력해주세요.")
    }

    fun printInputBonusNum() {
        println("보너스 번호를 입력해 주세요.")
    }

    fun printWinningSummaryTitle() {
        println("당첨 통계")
        println("---")
    }

    fun printWinningSummary(winningCount: MutableList<Int>, profitRate: String) {
        println("3개 일치 (5,000원) - ${winningCount[0]}개")
        println("4개 일치 (50,000원) - ${winningCount[1]}개")
        println("5개 일치 (1,500,000원) - ${winningCount[2]}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningCount[3]}개")
        println("6개 일치 (2,000,000,000원) - ${winningCount[4]}개")
        println("총 수익률은 ${profitRate}%입니다.")
    }
}