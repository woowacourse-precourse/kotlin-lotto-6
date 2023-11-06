package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.Lottos
import lotto.LottoResult

class LottoController(private val view: ScreenView) {
    fun pickRandomNums(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).toMutableList()
        val lotto = Lotto(toAscending(numbers))
        return lotto
    }

    fun pickRandomNum(): Int {
        val number = Randoms.pickNumberInRange(1, 45)
        return number
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

    fun countEqualNums(answer: MutableList<Int>, input: MutableList<Int>): Int {
        var count = 0
        input.forEach {
            if (answer.contains(it)) {
                count++
            }
        }
        return count
    }
}