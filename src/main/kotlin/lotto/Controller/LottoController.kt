package lotto.Controller

import LottoGameView.inputHowManyBuyLotto
import LottoGameView.inputLottoBonusNumbers
import LottoGameView.inputLottoNumbers
import LottoGameView.printLottoResult
import LottoGameView.printWinningLottoNumbers
import lotto.Model.Lotto
import lotto.Model.LottoGameModel
import lotto.Model.LottoGameModel.checkUserLottoScore
import lotto.Model.LottoGameModel.getScore

object LottoController {
    val lottoGameModel = LottoGameModel
    var howManyBuyLotto : Int = 0
    lateinit var lottoList : List<Lotto>
    lateinit var inputLotto : Lotto
    var inputBonus : Int = 0

    fun gameStart() {
        buyLotto()
        lottoGame()
    }

    fun buyLotto(){
        howManyBuyLotto = inputHowManyBuyLotto()
        lottoList = lottoGameModel.createRandomLottoNumbers(howManyBuyLotto)
        printWinningLottoNumbers(lottoList)
    }

    fun lottoGame(){
        inputLotto = inputLottoNumbers()
        inputBonus = inputLottoBonusNumbers(inputLotto)
        getScore(lottoList,inputLotto, inputBonus)
        printLottoResult(checkUserLottoScore, howManyBuyLotto)
    }

}
