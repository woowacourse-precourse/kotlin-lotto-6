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

        LottoGameView.inputLottoBonusNumbers()

        lottoGameModel!!.checkWinnings()
    }
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
