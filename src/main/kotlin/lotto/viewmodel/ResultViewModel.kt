package lotto.viewmodel

import lotto.model.Lotto
import lotto.model.RESULT
import lotto.model.RESULT.*
import lotto.observer.GenerateLottoListener
import lotto.observer.InputNumberListener
import java.util.*

class ResultViewModel: InputNumberListener, GenerateLottoListener {
    lateinit var inputLottoNumber: List<Int>
    lateinit var lotto: List<Lotto>
    private val resultCounts = EnumMap<RESULT, Int>(RESULT::class.java)
    var bonusNumber = 0
    private var prize = 0

    fun updateResult(): String = RESULT.entries.joinToString(separator = "\n") { "${it.message} - ${resultCounts[it] ?: 0}개" }
    fun initRateOfReturn(): String = roundOnePlaces(value = ( prize.toFloat() / (lotto.size*1000) )*100)
    private fun initResult() = lotto.forEach { calculateResult(it) }
    private fun roundOnePlaces(value: Float): String = String.format("%.1f", value)

    private fun calculateResult(lotto: Lotto) {
        val matchCount = inputLottoNumber.intersect(lotto.toSet()).size
        val hasBonus = bonusNumber in lotto.toSet()

        getResultType(matchCount, hasBonus)?.let {
            resultCounts[it] = resultCounts.getOrDefault(it, 0) + 1
            prize += it.prize
        }
    }

    private fun getResultType(matchCount: Int, hasBonus: Boolean): RESULT? = when (matchCount) {
        3 -> THREE
        4 -> FOUR
        5 -> if (hasBonus) FIVE_WITH_BONUS else FIVE
        6 -> SIX
        else -> null
    }

    override fun inputNumberListener(number: List<Int>) {
        this.inputLottoNumber = number
    }

    override fun inputBonusNumberListener(number: Int) {
        this.bonusNumber = number
        initResult()
    }

    override fun generateLotto(lotto: List<Lotto>) {
        this.lotto = lotto
    }
}