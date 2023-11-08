package lotto.model

import lotto.config.GameConfigValue.SIX_NUMBER
import lotto.config.GameConfigValue.FIVE_NUMBER
import lotto.config.GameConfigValue.FOUR_NUMBER
import lotto.config.GameConfigValue.THREE_NUMBER
import lotto.config.OutputMessages.SIX_NUMBER_CORRECT
import lotto.config.OutputMessages.FIVE_NUMBER_CORRECT
import lotto.config.OutputMessages.FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT
import lotto.config.OutputMessages.FOUR_NUMBER_CORRECT
import lotto.config.OutputMessages.THREE_NUMBER_CORRECT
import lotto.config.OutputMessages

class LottoCompare(
    private val bonusNumber: Int,
    private val correctLottoNumber: List<Int>,
    private val lottoNumbers: MutableList<List<Int>>
){
    fun calculateCorrect(): MutableMap<OutputMessages, Int> {
        val lottoResults=initializeLottoResults()

        lottoNumbers.forEach { lottoNumber ->
            when (lottoNumber.intersect(correctLottoNumber.toSet()).count()) {
                THREE_NUMBER -> lottoResults[THREE_NUMBER_CORRECT] = (lottoResults[THREE_NUMBER_CORRECT]!! + 1)
                FOUR_NUMBER -> lottoResults[FOUR_NUMBER_CORRECT] = (lottoResults[FOUR_NUMBER_CORRECT]!! + 1)
                FIVE_NUMBER -> fiveNumberCorrect(lottoNumber,lottoResults)
                SIX_NUMBER -> lottoResults[SIX_NUMBER_CORRECT] = (lottoResults[SIX_NUMBER_CORRECT]!! + 1)
            }
        }
        return lottoResults
    }
    private fun initializeLottoResults(): MutableMap<OutputMessages, Int> {
        return mutableMapOf(
            THREE_NUMBER_CORRECT to 0,
            FOUR_NUMBER_CORRECT to 0,
            FIVE_NUMBER_CORRECT to 0,
            FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT to 0,
            SIX_NUMBER_CORRECT to 0,
        )
    }
    private fun fiveNumberCorrect(lottoNumber: List<Int>,lottoResults: MutableMap<OutputMessages, Int>) {
        if (lottoNumber.contains(bonusNumber)) {
            lottoResults[FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT] = (lottoResults[FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT]!! + 1)
        } else {
            lottoResults[FIVE_NUMBER_CORRECT] = (lottoResults[FIVE_NUMBER_CORRECT]!! + 1)
        }
    }
}

