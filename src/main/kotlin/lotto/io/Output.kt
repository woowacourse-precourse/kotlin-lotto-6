package lotto.io

import lotto.model.LottoRank

class Output {
    fun printAmountMsg() {
        println("구입금액을 입력해 주세요.")
    }

    fun printQuantityMsg(quantity: Int) {
        printBlankLine()
        println("${quantity}개를 구매했습니다.")
    }

    fun printWinningNumbersMsg() {
        printBlankLine()
        println("당첨 번호를 입력해 주세요.")
    }

    private fun printBlankLine() {
        println()
    }

    fun printBonusNumberMsg() {
        printBlankLine()
        println("보너스 번호를 입력해 주세요.")
    }

    fun printLotto(lottoTickets: List<Int>) {
        println(lottoTickets)
    }

    fun printResult(lottoResult: Map<LottoRank, Int>, profitRate: String) {
        printBlankLine()
        println(
            "당첨 통계\n" +
                    "---"
        )
        println(
            "3개 일치 (5,000원) - ${lottoResult[LottoRank.FIFTH]}개\n" +
                    "4개 일치 (50,000원) - ${lottoResult[LottoRank.FOURTH]}개\n" +
                    "5개 일치 (1,500,000원) - ${lottoResult[LottoRank.THIRD]}개\n" +
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - ${lottoResult[LottoRank.SECOND]}개\n" +
                    "6개 일치 (2,000,000,000원) - ${lottoResult[LottoRank.FIRST]}개\n" +
                    "총 수익률은 ${profitRate}%입니다."
        )
    }

}