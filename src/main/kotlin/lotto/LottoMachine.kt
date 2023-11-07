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
        return money / LOTTO_COST
    }

    fun calculatePrizeSum(): Int {
        return firstPlace * FIRST_PLACE_PRIZE +
                secondPlace * SECOND_PLACE_PRIZE +
                thirdPlace * THIRD_PLACE_PRIZE +
                fourthPlace * FOURTH_PLACE_PRIZE +
                fifthPlace * FIFTH_PLACE_PRIZE
    }

    fun calculateRate(): Double {
        val sum = calculatePrizeSum()
        val money = money.toDouble()
        return sum / money
    }

    companion object {

        private const val LOTTO_COST = 1000
        private const val FIFTH_PLACE_PRIZE = 5000
        private const val FOURTH_PLACE_PRIZE = 50000
        private const val THIRD_PLACE_PRIZE = 1500000
        private const val SECOND_PLACE_PRIZE = 30000000
        private const val FIRST_PLACE_PRIZE = 2000000000

    }
}