package lotto.view

class OutputView {

    fun printInputMoney() = println(Message.InputMoney)

    fun printQuantityPurchased(quantity: Int) = println(format(Message.QuantityPurchased, quantity))

    fun printInputWinningNumbers() = println(Message.InputWinningNumbers)

    fun printInputBonusNumber() = println(Message.InputBonusNumber)

    fun printResultBoardHeader() = println(Message.ResultBoardHeader)

    fun printRank(number : Int) = println(format(Message.RankForm,number))

    fun printPrizeMoneyAndCount( prize : Int, number : Int) = println(format(Message.PrizeMoneyAndCountForm,prize,number))

    fun printBonusBallMatch() = println(Message.BonusBallMatch)

    fun printRateOfReturn(rate : Int) = println(format(Message.RateOfReturn,rate))

    fun printError() = println(Message.Error)


    private fun format(message: Message, vararg any: Any): String = message.toString().format(any)


    private enum class Message(private val message: String) {
        InputMoney("구입금액을 입력해 주세요."),
        QuantityPurchased("%d개를 구매했습니다."),
        InputWinningNumbers("당첨 번호를 입력해 주세요."),
        InputBonusNumber("보너스 번호를 입력해 주세요."),
        ResultBoardHeader("당첨 통계 \n---"),
        RankForm("%d개 일치"),
        PrizeMoneyAndCountForm(" (%s원) - %d개"),
        BonusBallMatch(", 보너스 볼 일치"),
        RateOfReturn("총 수익률은 %.1f%입니다."),
        Error("[ERROR]");

        override fun toString(): String = message
    }
}