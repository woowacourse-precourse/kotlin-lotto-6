package lotto.model

import lotto.config.GameConfigValue.SIX_NUMBER
import lotto.config.GameConfigValue.FIVE_NUMBER
import lotto.config.GameConfigValue.FOUR_NUMBER
import lotto.config.GameConfigValue.THREE_NUMBER
import lotto.view.OutputMessages

class LottoCompare(
    private val bonusNumber: Int,
    private val correctLottoNumber: List<Int>,
    private val lottoNumbers: MutableList<List<Int>>
){

    fun calculateCorrect():MutableMap<OutputMessages, Int>{
        val lottoResults = mutableMapOf(
            OutputMessages.THREE_NUMBER_CORRECT to 0,
            OutputMessages.FOUR_NUMBER_CORRECT to 0,
            OutputMessages.FIVE_NUMBER_CORRECT to 0,
            OutputMessages.FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT to 0,
            OutputMessages.SIX_NUMBER_CORRECT to 0,
        )

        lottoNumbers.forEach { lottoNumber ->
            when (lottoNumber.intersect(correctLottoNumber.toSet()).count()) {
                THREE_NUMBER -> threeNumberCorrect(lottoResults)
                FOUR_NUMBER -> fourNumberCorrect(lottoResults)
                FIVE_NUMBER -> fiveNumberCorrect(lottoNumber, lottoResults)
                SIX_NUMBER -> sixNumberCorrect(lottoResults)
            }
        }
        return lottoResults
    }

    private fun sixNumberCorrect(lottoResults: MutableMap<OutputMessages, Int>) {
        lottoResults[OutputMessages.SIX_NUMBER_CORRECT] = (lottoResults[OutputMessages.SIX_NUMBER_CORRECT]!! + 1)
    }

    private fun fiveNumberCorrect(lottoNumber: List<Int>, lottoResults: MutableMap<OutputMessages, Int>) {
        if (lottoNumber.contains(bonusNumber)) {
            lottoResults[OutputMessages.FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT] = (lottoResults[OutputMessages.FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT]!! + 1)
        } else {
            lottoResults[OutputMessages.FIVE_NUMBER_CORRECT] = (lottoResults[OutputMessages.FIVE_NUMBER_CORRECT]!! + 1)
        }
    }

    private fun fourNumberCorrect(lottoResults: MutableMap<OutputMessages, Int>) {
        lottoResults[OutputMessages.FOUR_NUMBER_CORRECT] = (lottoResults[OutputMessages.FOUR_NUMBER_CORRECT]!! + 1)
    }

    private fun threeNumberCorrect(lottoResults: MutableMap<OutputMessages, Int>) {
        lottoResults[OutputMessages.THREE_NUMBER_CORRECT] = (lottoResults[OutputMessages.THREE_NUMBER_CORRECT]!! + 1)
    }
}

