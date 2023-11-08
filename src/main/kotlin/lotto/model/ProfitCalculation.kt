package lotto.model

import lotto.config.GameConfigValue.SIX_NUMBER_NUMBER_PRICE
import lotto.config.GameConfigValue.FIVE_NUMBER_AND_BONUS_NUMBER_PRICE
import lotto.config.GameConfigValue.FIVE_NUMBER_NUMBER_PRICE
import lotto.config.GameConfigValue.FOUR_NUMBER_NUMBER_PRICE
import lotto.config.GameConfigValue.THREE_NUMBER_NUMBER_PRICE
import lotto.config.GameConfigValue.PURCHASE_AMOUNT_UNIT
import lotto.config.OutputMessages.SIX_NUMBER_CORRECT
import lotto.config.OutputMessages.FIVE_NUMBER_CORRECT
import lotto.config.OutputMessages.FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT
import lotto.config.OutputMessages.FOUR_NUMBER_CORRECT
import lotto.config.OutputMessages.THREE_NUMBER_CORRECT

class ProfitCalculation {

    fun profit(compareResult: LottoCompare,money:Int): Double {
        var sum=0
        val result = compareResult.calculateCorrect()

        sum+= result[SIX_NUMBER_CORRECT]!!.times((SIX_NUMBER_NUMBER_PRICE))
        sum+= result[FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT]!!.times((FIVE_NUMBER_AND_BONUS_NUMBER_PRICE))
        sum+= result[FIVE_NUMBER_CORRECT]!!.times((FIVE_NUMBER_NUMBER_PRICE))
        sum+= result[FOUR_NUMBER_CORRECT]!!.times((FOUR_NUMBER_NUMBER_PRICE))
        sum+= result[THREE_NUMBER_CORRECT]!!.times((THREE_NUMBER_NUMBER_PRICE))

        return ((sum.toDouble()/((money*PURCHASE_AMOUNT_UNIT)))*100)
    }
}