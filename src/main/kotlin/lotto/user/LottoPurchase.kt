package lotto.user

import camp.nextstep.edu.missionutils.Console
import lotto.util.LottoView

enum class PurchaseErrorCode(val message: String){
    ERROR_MESSAGE("[ERROR] 잘못된 숫자 입력입니다."),
    ERROR_NOT_BUY("[ERROR] 1000원 단위로 입력하세요.")
}

class LottoPurchase {

    fun validatePurchase(cost: String) : Boolean {
        if(cost.isBlank() || !cost.all{it.isDigit()}){
            throw IllegalArgumentException(PurchaseErrorCode.ERROR_MESSAGE.message)
        } else if(cost.toInt() % 1000 != 0){
            throw IllegalArgumentException(PurchaseErrorCode.ERROR_NOT_BUY.message)
        }
        return true
    }

    private fun checkPurchase(cost: String) : Boolean {
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