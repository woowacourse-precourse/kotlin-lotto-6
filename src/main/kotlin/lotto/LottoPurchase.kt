package lotto

import camp.nextstep.edu.missionutils.Console

class LottoPurchase {
    companion object {
        private const val ERROR_MESSAGE = "[ERROR] 잘못된 숫자 입력입니다."
    }
    fun validatePurchase(cost: String) : Boolean {
        if(cost.isBlank() || !cost.all{it.isDigit()}){
            throw IllegalArgumentException(ERROR_MESSAGE)
        }
        return true
    }

    private fun checkPurchase(cost: String) : Boolean{
        return try {
            validatePurchase(cost)
            true
        } catch (e:IllegalArgumentException){
            println(e.message)
            false
        }
    }

    private fun purchaseValid(): String {
        var validInput = false
        var cost:String
        LottoView().purchaseView()
        do{
            cost = Console.readLine()
            validInput = checkPurchase(cost)
        } while(!validInput)
        return cost
    }

    fun purchaseCheck(): Int {
        val cost = purchaseValid()
        LottoView().buyView(cost.toInt()/1000)
        return cost.toInt()
    }
}