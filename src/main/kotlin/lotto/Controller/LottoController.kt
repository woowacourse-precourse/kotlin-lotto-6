package lotto.Controller

import LottoGameView
import lotto.Model.LottoGameModel

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
