package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInitializer {
    var purchaseAmount: Int = 0
    val prizeCounts = IntArray(5)
    var lottoPurchaseCount: Int = 0
    fun initializeLotto(): Tuple {
        inputPurchaseAmount()

        lottoPurchaseCount = purchaseAmount / 1000
        println("\n${lottoPurchaseCount}${MessageConstants.PURCHASE_COMPLETED}")
        return Tuple(purchaseAmount, lottoPurchaseCount, prizeCounts)
    }

    fun inputPurchaseAmount() {
        while (true) {
            println(MessageConstants.INPUT_PURCHASE_AMOUNT)
            try {
                purchaseAmount = Console.readLine().toInt()
                if (validatePurchaseAmount(purchaseAmount))
                    break
            } catch (e: NumberFormatException) {
                println(MessageConstants.ERROR_NOT_A_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun validatePurchaseAmount(purchaseAmount: Int) : Boolean {
        if (purchaseAmount < 1000) {
            throw IllegalArgumentException(MessageConstants.ERROR_AMOUNT_LESS_THAN_1000)
        } else if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException(MessageConstants.ERROR_NOT_A_MULTIPLE_OF_1000)
        }
        return true
    }
}