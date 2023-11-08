package lotto

fun main() {
    var inputMoney = 0
    var bonusNumber = 0
    var validInput = false
    var winningNumbers:List<Int> = listOf()

    var user = User()
    var lottoProgram = LottoProgram()

    while (!validInput) {
        try {
            println("구입금액을 입력해 주세요.")
            inputMoney = user.inputMoney()
            validInput = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    println()
    lottoProgram.makeCalculationMoney(inputMoney)
    println("${lottoProgram.count}개를 구매했습니다.")
    lottoProgram.makeLottos()
    lottoProgram.lottos.forEach {
        it.printNumbers()
    }
    println()
    validInput = false
    while (!validInput) {
        try {
            println("당첨 번호를 입력해 주세요.")
            winningNumbers = user.inputWinningNumbers()
            validInput = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    println()
    validInput = false
    while (!validInput) {
        try {
            println("보너스 번호를 입력해 주세요.")
            bonusNumber = user.inputBonusNumber()
            validInput = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
    println()
    lottoProgram.inputWinningNumbers(winningNumbers)
    lottoProgram.inputBonusNumber(bonusNumber)
    lottoProgram.printResult()
}
