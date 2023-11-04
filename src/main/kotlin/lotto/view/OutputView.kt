package lotto.view

private const val PURCHASE_AMOUNT_MSG = "구입금액을 입력해 주세요."
private const val LOTTO_COUNT_MSG = "%d개를 구매했습니다."
private const val LOTTO_WINNING_NUMS_MSG = "당첨 번호를 입력해 주세요."
private const val LOTTO_BONUS_NUM_MSG = "보너스 번호를 입력해 주세요."


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
    fun printRequireWinningNums(){
        println("\n$LOTTO_WINNING_NUMS_MSG")
    }
    fun printRequireBonusNums(){
        println("\n$LOTTO_BONUS_NUM_MSG")
    }
}