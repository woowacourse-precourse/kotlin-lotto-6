package lotto


fun main() {
    var playingFlag = true
    LottoSystem.gameStartMessage()
    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.buyPrice)
        LottoSystem.inputResult = LottoSystem.userInput()
        playingFlag =
            LottoSystem.inputCheck(LottoSystem.inputResult, LottoSystem.caseBuyPrice)
    }
    playingFlag = true

    LottoSystem.inputResult.toInt()
    val LottoSystemTimes = (LottoSystem.inputResult.toInt() / 1000)
    LottoSystem.buyMessage((LottoSystemTimes))
    while (LottoSystem.round < LottoSystemTimes) {
        LottoSystem.SelectBall6 = LottoSystem.SelectBall()
        if (LottoSystem.SelectBall6.distinct().size == 6) {
            LottoSystem.round++
            Lotto(LottoSystem.SelectBall6.sorted())
        }
    }
    Lotto.allDisplay()
    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.chosenNumber)
        LottoSystem.inputResult = LottoSystem.userInput().replace(" ", "")
        playingFlag = LottoSystem.inputCheck(LottoSystem.inputResult, LottoSystem.caseChoseNumber)
    }
    playingFlag = true

    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.bonusNumber)
        LottoSystem.inputResult = LottoSystem.userInput().trim()
        playingFlag = LottoSystem.inputCheck(LottoSystem.inputResult, LottoSystem.caseBonusNumber)
    }


}


