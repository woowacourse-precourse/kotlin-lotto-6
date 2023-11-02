package lotto.view

import lotto.util.Constant.INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_PRICE_UNIT_ERROR_MESSAGE
import lotto.util.Constant.UNIT_PRICE
import java.lang.IllegalArgumentException

object InputValidator {

    fun validateInputPrice(price : String){
        if(price.toIntOrNull()==null){
            throw IllegalArgumentException(INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE)
        }
        if(price.toInt() % UNIT_PRICE !=0){
            throw IllegalArgumentException(INPUT_PRICE_UNIT_ERROR_MESSAGE)
        }
    }
}