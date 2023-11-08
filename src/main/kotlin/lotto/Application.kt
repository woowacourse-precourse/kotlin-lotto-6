package lotto

import camp.nextstep.edu.missionutils.Console

data class MoneyOutput(var seller: LottoSeller, var inputMoney: Int)

fun getInputMoney(): MoneyOutput {
    var flag = 0
    val seller = LottoSeller()
    var inputMoney = 0
    while (flag != 1) {
        println("구입금액을 입력해 주세요.")
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
        println("당첨 번호를 입력해 주세요.")
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
        println("보너스 번호를 입력해 주세요.")
        val userInput = Console.readLine()
        seller.bonusNumber = userInput.toInt()
        try {
            seller.validateBonusNumber()
            println("woww")
            flag = 1
        } catch (error: IllegalArgumentException) {
            println("[ERROR] " + error.message)
        }
    }
    return seller
}

fun main() {
    val winningPrint = arrayListOf(
        "3개 일치 (5,000원) - ",
        "4개 일치 (50,000원) - ",
        "5개 일치 (1,500,000원) - ",
        "5개 일치, 보너스 볼 일치 (30,000,000원) - ",
        "6개 일치 (2,000,000,000원) - "
    )
    var (seller, inputMoney) = getInputMoney() //사용자에게 구입금액 입력받기
    seller.createLotto()

    val getWinningOutput = getWinningNumbers(seller) //사용자에게 당첨 로또 번호 입력받기
    seller = getWinningOutput.first
    val userLotto = getWinningOutput.second

    seller = getBonusNumber(seller) //사용자에게 보너스 번호 입력받기

    // winningCount는 index0부터 순서대로 3,4,5,5+보너스,6개 일치하는 개수 저장
    println("당첨 통계\n---")
    val winningCount = userLotto.winningCount(seller.tickets, seller.bonusNumber)
    println(winningCount)
    for (i in 0..4) {
        println("${winningPrint[i]}${winningCount[i]}개")
    }
    userLotto.getProfitRate(winningCount, inputMoney)
}
