package lotto

class LottoMachine {
    private val inputManager = InputManager()
    private val outputManager = OutputManager()
    val money = inputManager.inputMoney()
    var firstPlace = 0
    var secondPlace = 0
    var thirdPlace = 0
    var fourthPlace = 0
    var fifthPlace = 0
    fun checkRank() {
        val lotto = Lottos().makeLotto(lottoNum())
        val lottos = inputManager.inputWinningNumber()
        val bonusNum = inputManager.inputBonusNumber()

        for (l in lotto) {
            val correctNum = l.compareNumber(lottos)
            val correctBonusNum = l.compareBonusNumber(bonusNum)
            when {
                correctNum == 3 -> fifthPlace++
                correctNum == 4 -> fourthPlace++
                correctNum == 5 && !correctBonusNum -> thirdPlace++
                correctNum == 5 && correctBonusNum -> secondPlace++
                correctNum == 6 -> firstPlace++
            }
        }
        outputManager.printLottoStatistic(firstPlace, secondPlace, thirdPlace, fourthPlace, fifthPlace)
        outputManager.printRate(calculateRate())

    }

    fun lottoNum(): Int {
        return money / 1000
    }

    fun calculatePrizeSum(): Int {
        return firstPlace * 2000000000 + secondPlace * 30000000 + thirdPlace * 1500000 + fourthPlace * 50000 + fifthPlace * 5000
    }

    fun calculateRate(): Double {
        val sum = calculatePrizeSum()
        val money = money.toDouble()
        return sum / money
    }
}