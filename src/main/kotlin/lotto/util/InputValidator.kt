package lotto.util

import lotto.util.Constant.INPUT_LUCKY_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_LUCKY_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Constant.INPUT_PRICE_NOT_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.INPUT_PRICE_UNIT_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_SIZE
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
    fun validateInputLuckyNumber(numbers:String){
        val luckyNumbers = numbers.split(",")
        if(luckyNumbers.size!= LOTTO_NUMBER_SIZE){
            throw IllegalArgumentException(INPUT_LUCKY_NUMBER_LENGTH_ERROR_MESSAGE)
        }
        if(luckyNumbers.count{ luckynumber -> luckynumber.toIntOrNull()==null} > 0){
            throw IllegalArgumentException(INPUT_LUCKY_NUMBER_NOT_NUMBER_ERROR_MESSAGE)
        }
        if(luckyNumbers.toSet().size != LOTTO_NUMBER_SIZE){
            throw  IllegalArgumentException(INPUT_LUCKY_NUMBER_OVERLAP_ERROR_MESSAGE)
        }
    }
}