package lotto

import java.lang.NumberFormatException


fun main() {
    var playingFlag = true
    LottoSystem.informationMessage(LottoSystem.lottoGame)

    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.buyPrice)
        Lotto.inputResult = Lotto.userInput()
        playingFlag = CheckSystem.inputCheck(Lotto.inputResult, LottoSystem.caseBuyPrice)
    }


    try {
        Lotto.investmentAmount = Lotto.inputResult.toInt()
    } catch (e: NumberFormatException) {
        println(CheckSystem.errorMessageOnlyNumber)
    }
    Lotto.Times = (Lotto.investmentAmount / 1000)

    playingFlag = true
    LottoSystem.buyMessage(Lotto.Times)

    while (Lotto.presentRound < Lotto.Times) {
        Lotto.randomBall6 = Lotto.getRandomBall()
        if (Lotto.randomBall6.distinct().size == 6) {
            Lotto.presentRound++
            Lotto(Lotto.randomBall6.sorted())
        }
    }
    Lotto.allDisplay()
    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.chosenNumber)
        Lotto.inputResult = Lotto.userInput().replace(" ", "")
        playingFlag = CheckSystem.inputCheck(Lotto.inputResult, LottoSystem.caseChoseNumber)
    }

    Lotto.selectBall6 = Lotto.inputResult.split(",").map { it.toInt() }

    playingFlag = true

    while (playingFlag) {
        LottoSystem.requestMessage(LottoSystem.bonusNumber)
        Lotto.inputResult = Lotto.userInput().trim()
        playingFlag = CheckSystem.inputCheck(Lotto.inputResult, LottoSystem.caseBonusNumber)
    }

    Lotto.selectBonusBall = Lotto.inputResult.toInt()

    Lotto.totalInventoryFillInit()
    //통계용 변수 초기값 0개로 채우기
    Lotto.placeTemporaryConversion()
    // 해당 등수의 갯수를 가져오기위한 변수 임시변환

    Lotto.totalInventory =
        Lotto.numberContrast(Lotto.randomBallVowel, Lotto.selectBall6, Lotto.selectBonusBall)
    LottoSystem.informationMessage(LottoSystem.lottoStatistics)
    Lotto.tatisticsDisplay()


}


