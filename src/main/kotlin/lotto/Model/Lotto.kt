package lotto.Model

import LottoGameView.printGameResult
import camp.nextstep.edu.missionutils.Randoms
import lotto.Utils.InputLottoNumsException
import lotto.Utils.LottoException

enum class WinningRank(val prize: Long, val description: String) {
    FIRST(2000000000, "6개 일치"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(1500000, "5개 일치"),
    FOURTH(50000, "4개 일치"),
    FIFTH(5000, "3개 일치")
}
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_6NUMBERS)
        }
        require(numbers.distinct().size == 6){
            throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_ISDUPLICATED)
        }
        require(numbers.all { it in 1..45 }){
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_1TO45)
        }
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

    fun printLottoNumbers() {
        for (lotto in lottoList) {
            println(lotto.getLottoNumbers())
        }
    }

    fun checkWinnings() {
        val winningCounts = mutableMapOf<WinningRank, Int>().withDefault { 0 }

        for (lotto in lottoList) {
            val result = lotto.checkWinnings(winningNumbers ?: emptyList(), bonusNumber)
            val winningRank = getWinningRank(result)

            if (winningRank != null) {
                winningCounts[winningRank] = winningCounts.getValue(winningRank) + 1
            }
        }

        printGameResult(winningCounts, lottoList.size)
    }

    fun getWinningRank(result: Int): WinningRank? {
        return when (result) {
            3 -> WinningRank.FIFTH
            4 -> WinningRank.FOURTH
            5 -> if (bonusNumber != null) WinningRank.SECOND else WinningRank.THIRD
            6 -> WinningRank.FIRST
            else -> null
        }
    }



}