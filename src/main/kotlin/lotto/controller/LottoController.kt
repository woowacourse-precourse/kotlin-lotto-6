package lotto.controller

import lotto.model.User
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView = InputView(),private val outPutView : OutputView = OutputView()) {

    private val user = User()
    fun run(){
        outPutView.printInputPrice()
        val price = inputView.inputPrice()
        outPutView.printBuyLotto(price)
        user.buyLotto(price)
        outPutView.printUserLotto(user.lottoes)
        //TODO 당첨번호 입력
        //TODO 보너스 번호 입력
        //TODO 당첨 통계 구현
    }
}