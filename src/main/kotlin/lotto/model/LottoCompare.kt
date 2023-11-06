package lotto.model

import lotto.config.GameConfigValue.SIX_NUMBER_CORRECT
import lotto.config.GameConfigValue.FIVE_NUMBER_CORRECT
import lotto.config.GameConfigValue.FOUR_NUMBER_CORRECT
import lotto.config.GameConfigValue.THREE_NUMBER_CORRECT
import lotto.model.LottoNumber.*

class LottoCompare(
    private val bonusNumber: Int,
    private val correctLottoNumber: List<Int>,
    private val lottoNumbers: MutableList<List<Int>>
){

    init {
        calculateCorrect()
    }

    private fun calculateCorrect() {
        val lottoResults = mutableMapOf(
            SIX_NUMBER to 0,
            FIVE_AND_BONUS_NUMBER to 0,
            FIVE_NUMBER to 0,
            FOUR_NUMBER to 0,
            THREE_NUMBER to 0
        )

        lottoNumbers.forEach { lottoNumber ->
            when (lottoNumber.intersect(correctLottoNumber.toSet()).count()) {
                SIX_NUMBER_CORRECT -> sixNumberCorrect(lottoResults)
                FIVE_NUMBER_CORRECT -> fiveNumberCorrect(lottoNumber, lottoResults)
                FOUR_NUMBER_CORRECT -> fourNumberCorrect(lottoResults)
                THREE_NUMBER_CORRECT -> threeNumberCorrect(lottoResults)
            }
        }

        lottoResults.forEach { (result, count) ->
            println("$result: $count 개")
        }
    }

    private fun sixNumberCorrect(lottoResults: MutableMap<LottoNumber, Int>) {
        lottoResults[SIX_NUMBER] = (lottoResults[SIX_NUMBER]!! + 1)
    }

    private fun fiveNumberCorrect(lottoNumber: List<Int>, lottoResults: MutableMap<LottoNumber, Int>) {
        if (lottoNumber.contains(bonusNumber)) {
            lottoResults[FIVE_AND_BONUS_NUMBER] = (lottoResults[FIVE_AND_BONUS_NUMBER]!! + 1)
        } else {
            lottoResults[FIVE_NUMBER] = (lottoResults[FIVE_NUMBER]!! + 1)
        }
    }

    private fun fourNumberCorrect(lottoResults: MutableMap<LottoNumber, Int>) {
        lottoResults[FOUR_NUMBER] = (lottoResults[FOUR_NUMBER]!! + 1)
    }

    private fun threeNumberCorrect(lottoResults: MutableMap<LottoNumber, Int>) {
        lottoResults[THREE_NUMBER] = (lottoResults[THREE_NUMBER]!! + 1)
    }
}
enum class LottoNumber {
    SIX_NUMBER,
    FIVE_NUMBER,
    FIVE_AND_BONUS_NUMBER,
    FOUR_NUMBER,
    THREE_NUMBER
}
