package lotto

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        require(numbers.all { it in 1..45 })
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }

    fun checkWinnings(winningNumbers: List<Int>, bonusNumber: Int?) : Int {
        val matchedNumbers = numbers.intersect(winningNumbers)
        val matchedCount = matchedNumbers.size

        when (matchedCount) {
            3 -> return 3
            4 -> return 4
            5 -> {
                if (numbers.contains(bonusNumber))
                    return 50
                return 5
            }
            6 -> return 6
        }
        return 0
    }
}

class LottoGameModel(howManyBuyLotto: Int) {
    val lottoList: List<Lotto>
    private var winningNumbers: List<Int>? = null
    private var bonusNumber: Int? = null
    var winning3 = 0
    var winning4 = 0
    var winning5 = 0
    var winning5WithBonus = 0
    var winning6 = 0

    companion object {
        var instance: LottoGameModel? = null
    }

    init {
        require(howManyBuyLotto >= 0)

        lottoList = (1..howManyBuyLotto).map {
            val lottoNumbers = createLottoNumbers()
            Lotto(lottoNumbers)
        }
    }

    fun setWinningNumbers(winningNumbers: List<Int>) {
        this.winningNumbers = winningNumbers
    }

    fun setBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }

    fun createLottoNumbers(): List<Int> {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers.sorted()
    }

    // lottoList에 저장된 Lotto 객체의 numbers를 출력하는 메서드
    fun printLottoNumbers() {
        for (lotto in lottoList) {
            println(lotto.getLottoNumbers())
        }
    }

    fun checkWinnings() {
        for (lotto in lottoList) {
            val result = lotto.checkWinnings(winningNumbers ?: emptyList(), bonusNumber)
            when (result) {
                3 -> winning3++
                4 -> winning4++
                5 -> winning5++
                50 -> winning5WithBonus++
                6 -> winning6++
            }
        }
        printResult()
    }

    fun printResult(){
        println("\n당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - ${winning3}개")
        println("4개 일치 (50,000원) - ${winning4}개")
        println("5개 일치 (1,500,000원) - ${winning5}개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - ${winning5WithBonus}개")
        println("6개 일치 (2,000,000,000원) - ${winning6}개")
        printProfitRate()
    }

    fun printProfitRate(){
        val totalWinningCount = winning3 + winning4 + winning5 + winning5WithBonus + winning6
        val profitRate = (totalWinningCount.toDouble()/lottoList.size) * 100
        println("총 수익률은 ${profitRate}%입니다.")
    }
}