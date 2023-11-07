package lotto.Exceptions

import lotto.Controller.LottoController
import lotto.Controller.howManyBuyLotto
import lotto.Model.LottoGameModel

object Exceptions {

    fun checkHowManyLottoIsValid(lottoPrice : String?){
        if (lottoPrice != null) {
            try {
                val numberOfLottoTickets = howManyBuyLotto(lottoPrice)
                println("\n$numberOfLottoTickets 개를 구매했습니다.")
                LottoController.lottoGameModel = LottoGameModel(numberOfLottoTickets)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

}