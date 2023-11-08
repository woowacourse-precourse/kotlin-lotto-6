package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    var (seller, inputMoney) = getInputMoney() //사용자에게 구입금액 입력받기
    seller.createLotto()

    val getWinningOutput = getWinningNumbers(seller) //사용자에게 당첨 로또 번호 입력받기
    seller = getWinningOutput.first
    val userLotto = getWinningOutput.second

    seller = getBonusNumber(seller) //사용자에게 보너스 번호 입력받기

    // winningCount는 index0부터 순서대로 3,4,5,5+보너스,6개 일치하는 개수 저장
    println("당첨 통계\n---")
    val winningCount = userLotto.winningCount(seller.tickets, seller.bonusNumber)
    for (i in 0..4) {
        println("${WinningMsg.entries[i].msg}${winningCount[i]}개")
    }
    userLotto.getProfitRate(winningCount, inputMoney)
}
fun getInputMoney(): MoneyOutput {
    var flag = 0
    val seller = LottoSeller()
    var inputMoney = 0
    while (flag != 1) {
        println(UserInputMsg.MONEY.msg)
        val userInput = Console.readLine()
        try {
            inputMoney = userInput.toInt()
            seller.buyTickets(inputMoney)
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] " + error.message)
        }
    }
    return MoneyOutput(seller, inputMoney)
}

fun getWinningNumbers(seller: LottoSeller): Pair<LottoSeller, Lotto> {
    var flag = 0
    var userLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
    while (flag != 1) {
        println(UserInputMsg.LOTTO.msg)
        val userInput = Console.readLine()
        seller.winningNumbers = userInput.split(",").map { it.toInt() }.toMutableList()
        try {
            userLotto = Lotto(seller.winningNumbers)
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] " + error.message)
        }
    }
    return Pair(seller, userLotto)
}

fun getBonusNumber(seller: LottoSeller): LottoSeller {
    var flag = 0
    while (flag != 1) {
        println(UserInputMsg.BONUS.msg)
        val userInput = Console.readLine()
        seller.bonusNumber = userInput.toInt()
        try {
            seller.validateBonusNumber()
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] " + error.message)
        }
    }
    return seller
}
