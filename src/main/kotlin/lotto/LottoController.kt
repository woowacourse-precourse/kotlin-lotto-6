package lotto

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.*
import lotto.Lotto
import lotto.Lottos
import lotto.LottoResult

class LottoController(private val view: ScreenView) {
    fun pickRandomNums(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).toMutableList()
        val lotto = Lotto(toAscending(numbers))
        return lotto
    }

    fun toAscending(unsorted: MutableList<Int>): MutableList<Int> {
        unsorted.sort()
        return unsorted
    }

    fun buyLottos(quantity: Int): Lottos{
        val lottos = Lottos()
        for (i in 1..quantity){
            lottos.add(pickRandomNums())
        }
        return lottos
    }

    fun countEqualNums(answer: List<Int>, input: List<Int>): Int {
        var count = 0
        input.forEach {
            if (answer.contains(it)) {
                count++
            }
        }
        return count
    }

    fun isNumRepeated(numbers: List<Int>): Boolean {
        return numbers.size != numbers.distinct().count();
    }

    fun countWinningNums(lottos: Lottos, answer: List<Int>, bonusNum: Int, result: LottoResult){
        lottos.lottos.forEach{
            var count = countEqualNums(answer, it.getNumbers())
            if (count == 5 && it.getNumbers().contains(bonusNum)){
                count = 51
            }
            checkWinningNums(count, result)
        }
    }

    fun checkWinningNums(count: Int, result: LottoResult) {
        when(count){
            3 -> result.win[0]++
            4 -> result.win[1]++
            5 -> result.win[2]++
            51 -> result.win[3]++
            6 -> result.win[4]++
        }
    }

    fun calculateRateOfReturn(result: LottoResult, inputMoney: Int){
        var rateOfReturn = 0.0
        rateOfReturn += result.win[0] * 5000
        rateOfReturn += result.win[1] * 50000
        rateOfReturn += result.win[2] * 1500000
        rateOfReturn += result.win[3] * 30000000
        rateOfReturn += result.win[4] * 2000000000
        rateOfReturn /= inputMoney
        result.rateOfReturn = round(rateOfReturn*10)/10
    }
    enum class Winning {
        THREE, FOUR, FIVE, FIVEPLUSBONUS, SIX
    }
}