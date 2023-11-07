package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto
import lotto.utils.ErrorMessage

class Input {

    private fun getUserInput(): String {
        return Console.readLine()
    }

    private fun isLottoAndValidated(nums: String) {
        islength6(nums)
        isNotEmpty(nums)
    }
    private fun isIntAndValidated(num: String){
        isNotEmpty(num)
        isLengthOkay(num)
        isPosivite(num)
    }

    private fun isNotEmpty(nums: String) = require(nums.isNotEmpty()){ErrorMessage.INPUT_IS_NULL}

    private fun islength6(nums: String) = require(nums.split(",").size == 6){ErrorMessage.NOT_LOTTO_SIZE}

    private fun isPosivite(num: String) = require(num.toInt() >= 1){ErrorMessage.NOT_NATURAL_NUM}

    private fun isLengthOkay(num: String) = require(num.length <= 10){ErrorMessage.NOT_NUM_SIZE}

    private fun isDevidableBy1000(userInput: String) = require(userInput.toInt() % 1000 == 0)


    fun getlottoTicketsNum(): Int {
        return try{
            val userInput = getUserInput()
            isIntAndValidated(userInput)
            isDevidableBy1000(userInput)
            userInput.toInt() / 1000
        }
        catch (e: Exception){
            println(e.message)
            getlottoTicketsNum()
        }
    }


    fun getwinningLottoInfo(): Lotto {
        return try{
            val userInput = getUserInput()
            isLottoAndValidated(userInput)
            Lotto(userInput.split(",").map { it.toInt() }.toList())
        }
        catch (e: Exception){
            println(e.message)
            getwinningLottoInfo()
        }
    }

    fun getbonusInfo(): Int {
        return try{
            val userInput = getUserInput()
            isIntAndValidated(userInput)
            userInput.toInt()
        }
        catch (e: Exception){
            println(e.message)
            getbonusInfo()
        }
    }


}

