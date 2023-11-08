package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class LottoStatus {
    var countOfLotto: Int = 0
    var myLottos = mutableListOf<Lotto>()
    fun buyUntilValid() {
        var isValidPrice = false
        while (!isValidPrice) {
            isValidPrice = true
            try {
                inputPrice()
            } catch (e: IllegalArgumentException) {
                isValidPrice = false
            }
        }
        pickLotto()
    }
    fun pickLotto() {
        for (i in 0 until countOfLotto) {
            val currentLottoNumbers = pickRandomNumbersForLotto()
            val currentLotto = Lotto(currentLottoNumbers)
            myLottos.add(currentLotto)
            println(currentLotto.getLottoFormat())
        }
        println()
    }
    private fun pickRandomNumbersForLotto(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(
            LottoResource.MIN_LOTTO_NUMBER,
            LottoResource.MAX_LOTTO_NUMBER,
            LottoResource.LOTTO_SIZE
        )
    }
    private fun inputPrice() {
        println(LottoResource.PRICE_INPUT_MESSAGE)
        val inputPrice = Console.readLine()
        countOfLotto = validatePrice(inputPrice) / LottoResource.LOTTO_PRICE
        println()
        println("$countOfLotto" + LottoResource.COUNT_OF_LOTTO_OUTPUT_MESSAGE)
    }

    fun validatePrice(inputPrice: String): Int {
        require(inputPrice.toIntOrNull() != null) {
            Error.printErrorMessage(Error.PRICE_TYPE_IS_NOT_INT)
        }
        val realPrice = inputPrice.toInt()
        require(realPrice >= LottoResource.LOTTO_PRICE) {
            Error.printErrorMessage(Error.PRICE_IS_UNDER_1000)
        }
        require(realPrice % LottoResource.LOTTO_PRICE == 0) {
            Error.printErrorMessage(Error.PRICE_IS_NOT_PRODUCT_OF_1000)
        }
        return realPrice
    }
}