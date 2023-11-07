package lotto


fun main() {
    var playingFlag = true
    LottoSystem.informationMessage(LottoSystem.lottoGame)

    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.buyPrice)
        Lotto.inputResult = Lotto.userInput()
        playingFlag = CheckSystem.inputCheck(Lotto.inputResult, LottoSystem.caseBuyPrice)
    }

    Lotto.InvestmentAmount = Lotto.inputResult.toInt()
    Lotto.Times = (Lotto.InvestmentAmount / 1000)

    playingFlag = true
    LottoSystem.buyMessage(Lotto.Times)

    while (Lotto.round < Lotto.Times ) {
        Lotto.SelectBall6 = Lotto.SelectBall()
        if (Lotto.SelectBall6.distinct().size == 6) {
            Lotto.round++
            Lotto(Lotto.SelectBall6.sorted())
        }
    }
    Lotto.allDisplay()
    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.chosenNumber)
        Lotto.inputResult = Lotto.userInput().replace(" ", "")
        playingFlag = CheckSystem.inputCheck(Lotto.inputResult, LottoSystem.caseChoseNumber)
    }

    Lotto.lastBall7 = Lotto.inputResult.split(",").toMutableList()

    playingFlag = true

    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.bonusNumber)
        Lotto.inputResult = Lotto.userInput().trim()
        playingFlag = CheckSystem.inputCheck(Lotto.inputResult, LottoSystem.caseBonusNumber)
    }

    Lotto.lastBall7.add(Lotto.inputResult.trim())

    Lotto.totalInventory = Lotto.contrastNumber(Lotto.numbersVowel)
    LottoSystem.informationMessage(LottoSystem.lottoStatistics)
    Lotto.tatisticsDisplay(Lotto.totalInventory ,Lotto.lastBall7,Lotto.InvestmentAmount)



}


