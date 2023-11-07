package lotto

import camp.nextstep.edu.missionutils.Console
fun main() {
    val seller = LottoSeller()
    var inputMoney = 0
    var flag = 0

    while(flag != 1) {
        println("구입금액을 입력해 주세요.")
        inputMoney = Console.readLine().toInt()
        try{
            seller.buyTickets(inputMoney)
            flag = 1
        } catch(error: IllegalArgumentException) {
            println("[ERROR]"+error)
        }
    }
    seller.createLotto()
}
