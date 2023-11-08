package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoMessage.INPUT_BONUS_NUMBER
import lotto.LottoMessage.INPUT_LOTTO_NUMBER
import lotto.LottoMessage.PURCHASE_PRICE
import lotto.UserInput.getUserInput

object LottoInput {

    fun getInput() {
        val purchasePrice = getPurchasePrice()
        println()
        LottoData.purchasePrice = purchasePrice
        LottoData.purchaseLottoAmount = purchasePrice / 1000

        println("${LottoData.purchaseLottoAmount}개를 구매했습니다.")
        generateLotto()
        println()

        val lottoNumbers = getUserLottoNumber()
        LottoData.myLottoNumber = lottoNumbers
        println()

        val bonusNumber = getBonusNumber()
        LottoData.myBonusNumber = bonusNumber
        println()

    }

    private fun getPurchasePrice(): Int {
        while (true) {
            try {
                println(PURCHASE_PRICE)
                val purchasePrice = getUserInput()
                Validation.validatePurchasePrice(purchasePrice)

                return purchasePrice.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getUserLottoNumber(): List<Int> {
        while (true) {
            try {
                println(INPUT_LOTTO_NUMBER)
                val lottoNumber = getUserInput()
                Validation.validateLottoNumber(lottoNumber)

                return convertStringListToInt(lottoNumber)

            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun getBonusNumber(): Int {
        while (true) {
            try {
                println(INPUT_BONUS_NUMBER)
                val bonusNumber = getUserInput()
                Validation.validateBonusNumber(bonusNumber)

                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun generateLotto() {
        repeat(LottoData.purchaseLottoAmount) {
            val lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(lottoNumber).printLottoNumber()
        }
    }

    private fun convertStringListToInt(lottoNumber: String): List<Int> {
        return lottoNumber.split(",").mapNotNull { it.toIntOrNull() }
    }
}