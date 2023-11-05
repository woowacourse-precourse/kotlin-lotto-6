package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoConstants.LOTTO_PRICE
import lotto.constants.LottoConstants.LOTTO_SIZE
import lotto.constants.LottoConstants.MAXIMUM_NUMBER
import lotto.constants.LottoConstants.MINIMUM_NUMBER
import lotto.model.Winner.*
import java.util.*

object LottoService {
    private lateinit var winningMap: EnumMap<Winner, Int>
    fun buyLotto(money: Int): List<Lotto> =
        List(money / LOTTO_PRICE) { generateLotto() }

    fun getWinningMap(purchasedLottoList: List<Lotto>, winningNumber: Lotto, bonusNumber: Int): EnumMap<Winner, Int> {
        winningMap = EnumMap(Winner::class.java)
        purchasedLottoList.forEach { _lottoNumber ->
            val (count, isBonusNumber) = checkLotto(_lottoNumber, winningNumber, bonusNumber)
            setWinningDetails(count, isBonusNumber)
        }
        return winningMap
    }

    fun getEarningRate(winningMap: EnumMap<Winner, Int>, money: Int): Double =
        "%.2f".format(winningMap.entries.sumOf { (_winner, _numbers) ->
            _winner.prize * _numbers
        } / money.toDouble() * 100).toDouble()

    private fun checkLotto(lottoNumber: Lotto, winningNumber: Lotto, bonusNumber: Int): Pair<Int, Boolean> {
        var count = 0
        var isBonusNumberExist = false
        lottoNumber.getNumbers().forEach { _number ->
            when {
                winningNumber.getNumbers().contains(_number) -> count += 1
                _number == bonusNumber -> isBonusNumberExist = true
            }
        }
        return Pair(count, isBonusNumberExist)
    }

    private fun generateLotto(): Lotto {
        val lottoNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_SIZE)
        return Lotto(lottoNumbers.toList())
    }

    private fun setWinningDetails(count: Int, isBonusNumber: Boolean) {
        when (count) {
            FIRST_GRADE.correspondNumber -> winningMap[FIRST_GRADE] = winningMap.getOrDefault(FIRST_GRADE, 0) + 1
            SECOND_GRADE.correspondNumber -> {
                val grade = if (isBonusNumber) SECOND_GRADE else THIRD_GRADE
                winningMap[grade] = winningMap.getOrDefault(grade, 0) + 1
            }
            FOURTH_GRADE.correspondNumber -> winningMap[FOURTH_GRADE] = winningMap.getOrDefault(FOURTH_GRADE, 0) + 1
            FIFTH_GRADE.correspondNumber -> winningMap[FIFTH_GRADE] = winningMap.getOrDefault(FIFTH_GRADE, 0) + 1
        }
    }
}
