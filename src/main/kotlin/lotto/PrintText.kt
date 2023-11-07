package lotto

object PrintText {
    fun printMessage(type: String, count: Int) {
        when(type) {
            "GetPurchaseAmount" -> println("구입 금액을 입력해 주세요.")
            "PrintCountNumber" -> println("${count}개를 구매했습니다.")
            "GetWinningNumber" -> println("당첨 번호를 입력해 주세요.")
            "GetBonusNumber" -> println("보너스 번호를 입력해 주세요.")
            "PrintWinningStatistics" -> println("당첨 통계\n---")
            else -> println("ERROR")
        }
    }
}