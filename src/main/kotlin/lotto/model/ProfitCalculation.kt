package lotto.model

import lotto.config.GameConfigValue.SIX_NUMBER_NUMBER_PRICE
import lotto.config.GameConfigValue.FIVE_NUMBER_AND_BONUS_NUMBER_PRICE
import lotto.config.GameConfigValue.FIVE_NUMBER_NUMBER_PRICE
import lotto.config.GameConfigValue.FOUR_NUMBER_NUMBER_PRICE
import lotto.config.GameConfigValue.THREE_NUMBER_NUMBER_PRICE
import lotto.view.OutputMessages

class ProfitCalculation {

    fun profit(compareResult: LottoCompare,money:Int):Double{
        var sum=0
        val result = compareResult.calculateCorrect()

        sum+= result[OutputMessages.SIX_NUMBER_CORRECT]!!.times((SIX_NUMBER_NUMBER_PRICE))
        sum+= result[OutputMessages.FIVE_NUMBER_AND_BONUS_NUMBER_CORRECT]!!.times((FIVE_NUMBER_AND_BONUS_NUMBER_PRICE))
        sum+= result[OutputMessages.FIVE_NUMBER_CORRECT]!!.times((FIVE_NUMBER_NUMBER_PRICE))
        sum+= result[OutputMessages.FOUR_NUMBER_CORRECT]!!.times((FOUR_NUMBER_NUMBER_PRICE))
        sum+= result[OutputMessages.THREE_NUMBER_CORRECT]!!.times((THREE_NUMBER_NUMBER_PRICE))

        return ((sum.toDouble()/money)*100)
    }
}