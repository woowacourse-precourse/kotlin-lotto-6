package lotto

import camp.nextstep.edu.missionutils.Console

class LottoInitializer {
    private var purchaseAmount: Int = 0
    private val prizeCounts = IntArray(5)
    private var lottoPurchaseCount: Int = 0
    companion object {
        private const val LOTTO_UNIT = 1000
        private const val ZERO = 0
    }
    fun initializeLotto(): Tuple {
        inputPurchaseAmount()

        lottoPurchaseCount = purchaseAmount / LOTTO_UNIT
        println("\n${lottoPurchaseCount}${MessageConstants.PURCHASE_COMPLETED}")
        return Tuple(purchaseAmount, lottoPurchaseCount, prizeCounts)
    }

    fun inputPurchaseAmount() {
        while (true) {
            println(MessageConstants.INPUT_PURCHASE_AMOUNT)
            try {
                purchaseAmount = Console.readLine().toInt()
//                if (validatePurchaseAmount(purchaseAmount))
//                    break
                if (PurchaseAmount().validateLottoNumbers(purchaseAmount))
                    break
            } catch (e: NumberFormatException) {
                println(MessageConstants.ERROR_NOT_A_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

//    fun validatePurchaseAmount(purchaseAmount: Int) : Boolean {
//        if (purchaseAmount < LOTTO_UNIT) {
//            throw IllegalArgumentException(MessageConstants.ERROR_AMOUNT_LESS_THAN_1000)
//        } else if (purchaseAmount % LOTTO_UNIT != ZERO) {
//            throw IllegalArgumentException(MessageConstants.ERROR_NOT_A_MULTIPLE_OF_1000)
//        }
//        return true
//    }
}