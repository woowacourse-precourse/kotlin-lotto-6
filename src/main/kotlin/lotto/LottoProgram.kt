package lotto

import kotlin.math.*
import camp.nextstep.edu.missionutils.Randoms

class LottoProgram {
    var count: Int = 0
    var bonusNumber = 0
    var totalProfit = 0
    var inputMoney = 0
    var profitRate = 0
    var winningNumbers = listOf<Int>()
    var lottos:MutableList<Lotto> = mutableListOf()
    var totalRanking = mutableMapOf(1 to 0, 2 to 0, 3 to 0, 4 to 0, 5 to 0)
    var rankingInformationPhrase: Map<Int, String> = mapOf(1 to "SIX", 2 to "FIVEBONUS", 3 to "FIVE", 4 to "FOUR", 5 to "THREE")


    fun makeCalculationMoney(money: Int) {
        this.inputMoney = money
        this.count = money / 1000
    }

    fun makeRandomNumbers(): List<Int> {
        var numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }

    fun makeLottos() {
        for(i in 0 until this.count) {
            val numbers = makeRandomNumbers().sorted()
            val lotto = Lotto(numbers)
            this.lottos.add(lotto)
        }
    }

    fun inputWinningNumbers(winningNumbers: List<Int>) {
        this.winningNumbers = winningNumbers
    }

    fun inputBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }
    fun compareNumbers(lotto: Lotto): Int {
        var cnt = 0
        lotto.getNumbers().forEach {
            if (it in this.winningNumbers) {
                cnt += 1
            }
        }
        return cnt
    }

    fun campareBonus(lotto: Lotto): Boolean {
        if (this.bonusNumber in lotto.getNumbers()) { return true }
        return false
    }

    fun compareTotalLottos() {
        lottos.forEach {
            var resultCount = compareNumbers(it)
            if (resultCount == 6) {
                this.totalRanking[1] = this.totalRanking[1]!! + 1
                this.totalProfit += Ranking.SIX.Profit
            }
            if (resultCount == 5 && campareBonus(it)) {
                this.totalRanking[2] = this.totalRanking[2]!! + 1
                this.totalProfit += Ranking.FIVEBONUS.Profit
            }
            if (resultCount == 5 && !campareBonus(it)) {
                this.totalRanking[3] = this.totalRanking[3]!! + 1
                this.totalProfit += Ranking.FIVE.Profit
            }
            if (resultCount == 4) {
                this.totalRanking[4] = this.totalRanking[4]!! + 1
                this.totalProfit += Ranking.FOUR.Profit
            }
            if (resultCount == 3) {
                this.totalRanking[5] = this.totalRanking[5]!! + 1
                this.totalProfit += Ranking.THREE.Profit
            }
        }
    }

    fun calculateProfitRate() {
        profitRate = (this.totalProfit / this.inputMoney) * 100
    }
}