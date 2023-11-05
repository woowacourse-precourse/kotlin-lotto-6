package lotto.view

private const val PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요."
private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
private const val LOTTO_WINNING_NUMS_MSG = "당첨 번호를 입력해 주세요."
private const val LOTTO_BONUS_NUM_MSG = "보너스 번호를 입력해 주세요."
private const val THREE_MATCH_MSG = "3개 일치 (5,000원) - %d개"
private const val FOUR_MATCH_MSG = "4개 일치 (50,000원) - %d개"
private const val FIVE_MATCH_MSG = "5개 일치 (1,500,000원) - %d개"
private const val FIVE_BONUS_MATCH_MSG = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
private const val SIX_MATCH_MSG = "6개 일치 (2,000,000,000원) - %d개"

private const val WINNING_STATS_MSG = "당첨 통계\n" + "---"

class OutputView {
    fun printPurchaseAmount() {
        println(PURCHASE_AMOUNT_MSG)
    }

    fun printLottoCount(lottoCount: Int) {
        println("\n${LOTTO_COUNT_MSG.format(lottoCount)}")
    }

    fun printLottoList(lottoList: List<List<Int>>) {
        repeat(lottoList.size) { println(lottoList[it]) }
    }

    fun printRequireWinningNums() {
        println("\n$LOTTO_WINNING_NUMS_MSG")
    }

    fun printRequireBonusNums() {
        println("\n$LOTTO_BONUS_NUM_MSG")
    }

    fun printLottoResult(result: List<Int>) {
        val formats = listOf(
            THREE_MATCH_MSG,
            FOUR_MATCH_MSG,
            FIVE_MATCH_MSG,
            FIVE_BONUS_MATCH_MSG,
            SIX_MATCH_MSG
        )

        formats.forEachIndexed { index, format ->
            println(String.format(format,result[index]))
        }
    }
    fun printWinningStats(){
        println(WINNING_STATS_MSG)
    }
}