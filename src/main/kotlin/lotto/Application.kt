package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    val seller = LottoSeller()
    val winningPrint = arrayListOf("3개 일치 (5,000원) - ", "4개 일치 (50,000원) - ", "5개 일치 (1,500,000원) - ", "5개 일치, 보너스 볼 일치 (30,000,000원) - ", "6개 일치 (2,000,000,000원) - ")
    var userInput = ""
    var inputMoney = 0
    var flag = 0

    while (flag != 1) {
        println("구입금액을 입력해 주세요.")
        userInput = Console.readLine()
        inputMoney = userInput.toInt()
        try {
            seller.buyTickets(inputMoney)
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] " + error.message)
        }
    }
    seller.createLotto()

    flag = 0
    while (flag != 1) {
        var bonusNumber = 0
        println("당첨 번호를 입력해 주세요.")
        userInput = Console.readLine()
        seller.winningNumbers = userInput.split(",").map { it.toInt() }.toMutableList()
        try {
            seller.validateWinningNumbers()
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] " + error.message)
        }
    }

    flag = 0
    while (flag != 1) {
        var bonusNumber = 0
        println("보너스 번호를 입력해 주세요.")
        userInput = Console.readLine()
        seller.bonusNumber = userInput.toInt()
        try {
            seller.validateBonusNumber()
            println("woww")
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] " + error.message)
        }
    }

    // winningCount는 index0부터 순서대로 3,4,5,5+보너스,6개 일치하는 개수 저장
    val winningResult = Lotto(seller.winningNumbers)
    println("당첨 통계\n---")
    val winningCount = winningResult.winningCount(seller.tickets, seller.bonusNumber)
    println(winningCount)
    for (i in 0..4){
        println("${winningPrint[i]}${winningCount[i]}개")
    }
    winningResult.getProfitRate(winningCount, inputMoney)

}
