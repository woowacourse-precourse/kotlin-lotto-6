package lotto

object PrintText {
    fun printMessage(type: String, count: Int) {
        when(type) {
            Constants.GET_PURCHASE_AMOUNT_MESSAGE -> println("구입금액을 입력해 주세요.")
            Constants.PRINT_COUNT_NUMBER_MESSAGE -> println("${count}개를 구매했습니다.")
            Constants.GET_WINNING_NUMBER_MESSAGE -> println("당첨 번호를 입력해 주세요.")
            Constants.GET_BONUS_NUMBER_MESSAGE -> println("보너스 번호를 입력해 주세요.")
            Constants.PRINT_WINNING_STATISTICS_MESSAGE -> println("당첨 통계\n---")
            else -> throw IllegalArgumentException("올바르지 않은 메세지 타입입니다.")
            // printMessage type 에러 처리를 위한 else 사용
        }
    }
    fun printRate(rate: String) {
        println("총 수익률은 ${rate}%입니다.")
    }
}