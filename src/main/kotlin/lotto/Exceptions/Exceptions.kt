package lotto.Exceptions

import lotto.Controller.LottoController
import lotto.Controller.checkValidationBonusLottoNumbers
import lotto.Controller.howManyBuyLotto
import lotto.Controller.parseLottoNumbers
import lotto.Model.LottoGameModel

object Exceptions {

    fun checkHowManyBuyLottoIsValid(lottoPrice : String?){
        if (lottoPrice != null) {
            val numberOfLottoTickets = howManyBuyLotto(lottoPrice)
            println("\n$numberOfLottoTickets 개를 구매했습니다.")
            LottoController.lottoGameModel = LottoGameModel(numberOfLottoTickets)
        }
    }

    fun checkInputLottoNumbersAreValid(winningNumbers : String?){
        if (winningNumbers != null) {
            val parsedWinningNumbers = parseLottoNumbers(winningNumbers)
            LottoController.lottoGameModel?.setWinningNumbers(parsedWinningNumbers)
        }
    }

    fun checkInputLottoBonusNumberIsValid(bonusNumber : String?){
        if (bonusNumber != null) {
            val bonus = checkValidationBonusLottoNumbers(bonusNumber)
            LottoController.lottoGameModel?.setBonusNumber(bonus)
        }
    }
}