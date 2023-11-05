package lotto

fun main() {
    var user = User()
    var lottoMachine = LottoMachine()


    println(MessageManager.COMMENTS_HOW_MUCH_BUY.mes)
    var buy = user.buyLotto()
    var buyLottoMount = user.buyLottoCount(buy)

    user.saveTicket(buyLottoMount)
    user.printTicket()

    println(MessageManager.COMMENTS_MAIN_NUMBER.mes)
    var winNumber = lottoMachine.inputWinNum()

    println(MessageManager.COMMENTS_SUB_NUMBER.mes)
    var sunNumber = lottoMachine.inputSubNum()

    println(MessageManager.COMMENTS_LOTTO_RESULT.mes)

}
