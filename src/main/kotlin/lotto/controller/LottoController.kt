package lotto.controller

import lotto.model.Lotto
import lotto.model.User
import lotto.view.InputView
import lotto.view.OutputView
import camp.nextstep.edu.missionutils.Randoms

class LottoController {

    private val inputView = InputView()
    private val outputView = OutputView()
    private var lottoQuantity =0

    fun startGame() {
        val inputPurchaseAmount = inputView.promptPurchaseAmount()
        val user = User(inputPurchaseAmount)
        lottoQuantity = user.purchaseAmount/1000

        println("${lottoQuantity}개를 구매했습니다.")
        val lottos = createLottos(lottoQuantity)
        for(i in lottos){
            println(i.getLotto())
        }
        val inputWinningNum = inputView.promptWinningNum().split(',')
        val inputBonusNum = inputView.promptBonusNum().toInt()
    }
    private fun createLottos(lottoQuantity: Int): List<Lotto> {
        val lottos = mutableListOf<Lotto>()
        for (i in 1..lottoQuantity) {
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            lottos.add(lotto)
        }
        return lottos
    }

}