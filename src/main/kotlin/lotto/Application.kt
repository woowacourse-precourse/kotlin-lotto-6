package lotto

fun main() {
    var user = User()
    var lottoMachine = LottoMachine()


    println(MessageManager.COMMENTS_HOW_MUCH_BUY.mes)
    var buy = user.buyLotto()
    var buyLottoMount = user.buyLottoCount(buy)

    user.saveTicket(buyLottoMount)
    var ticket = user.printTicket()

    println(MessageManager.COMMENTS_MAIN_NUMBER.mes)
    var winNumber = lottoMachine.inputWinNum()

    println(MessageManager.COMMENTS_SUB_NUMBER.mes)
    var bonusNumber = lottoMachine.inputSubNum()

    println(MessageManager.COMMENTS_LOTTO_RESULT.mes)

    var lotto = Lotto(winNumber)
    lotto.compare(ticket, bonusNumber)
    val prize = Prize(lotto.count3, lotto.count4, lotto.count5, lotto.count5_2, lotto.count6, buy)
    prize.printResult()
    prize.yieldRateOfReturn()
}
