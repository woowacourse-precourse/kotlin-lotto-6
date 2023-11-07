package lotto

import camp.nextstep.edu.missionutils.Console
fun main() {
    val seller = LottoSeller()
    var userInput = ""
    var inputMoney = 0
    var flag = 0

    while(flag != 1) {
        println("구입금액을 입력해 주세요.")
        userInput = Console.readLine()
        inputMoney = userInput.toInt()
        try{
            seller.buyTickets(inputMoney)
            flag = 1
        } catch(error: IllegalArgumentException) {
            println("[ERROR] "+error.message)
        }
    }
    seller.createLotto()

    flag = 0
    while(flag != 1) {
        var bonusNumber = 0
        println("당첨 번호를 입력해 주세요.")
        userInput = Console.readLine()
        seller.winningNumbers = userInput.split(",").map{it.toInt()}.toMutableList()
        try{
            seller.validateWinningNumbers()
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] "+error.message)
        }
    }

    flag = 0
    while(flag != 1) {
        var bonusNumber = 0
        println("보너스 번호를 입력해 주세요.")
        userInput = Console.readLine()
        seller.bonusNumber = userInput.toInt()
        try{
            seller.validateBonusNumber()
            println("woww")
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] "+error.message)
        }
    }

    val winningResult = Lotto(seller.winningNumbers)

}
