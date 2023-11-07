package lotto.Controller

import LottoGameView
import lotto.Model.LottoGameModel
import lotto.Utils.InputLottoNumsException
import lotto.Utils.LottoException

fun howManyBuyLotto(lottoPrice: String): Int {
    try {
        val price = lottoPrice.toInt()

        if (price % 1000 == 0) {
            return price / 1000
        } else {
            throw IllegalArgumentException(LottoException.BUY_LOTTO_PRICE_1000)
        }
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(LottoException.BUY_LOTTO_PRICE_INVALIDATE_NUMBER)
    }
}

object LottoController {
    var lottoGameModel: LottoGameModel? = null

    fun gameStart() {
        LottoGameView.inputHowManyBuyLotto()

        lottoGameModel?.run {
            printLottoNumbers()
        }

        LottoGameView.inputLottoNumbers()

        println("\n보너스 번호를 입력해 주세요.")

        val bonusNumber = readLine()

        if (bonusNumber != null) {
            try {
                val bonus = checkValidationBonusLottoNumbers(bonusNumber)
                lottoGameModel?.setBonusNumber(bonus)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }

        lottoGameModel!!.checkWinnings()
    }
}

fun parseLottoNumbers(input: String?): List<Int> {
    if (input == null) {
        throw IllegalArgumentException(LottoException.INPUT_NULL)
    }

    val numbers = input.split(",").map { it.trim() }.filter { it.isNotEmpty() }

    if (numbers.size != 6) {
        throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_6NUMBERS)
    }

    val lottoNumbers = numbers.map {
        try {
            val number = it.toInt()
            if (number < 1 || number > 45) {
                throw IllegalArgumentException(LottoException.INPUT_LOTTO_1TO45)
            }
            number
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_INVALID_TYPE)
        }
    }

    if (lottoNumbers.distinct().size != 6) {
        throw IllegalArgumentException(InputLottoNumsException.INPUT_LOTTO_ISDUPLICATED)
    }

    return lottoNumbers
}

fun checkValidationBonusLottoNumbers(bonusNumber: String?): Int{
    if (bonusNumber == null) {
        throw IllegalArgumentException(LottoException.INPUT_NULL)
    }

    try {
        val number = bonusNumber.toInt()
        if (number < 1 || number > 45) {
            throw IllegalArgumentException(LottoException.INPUT_LOTTO_1TO45)
        }
        return number
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException(LottoException.INPUT_LOTTO_INVALID_TYPE)
    }
}
