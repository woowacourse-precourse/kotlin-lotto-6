package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView = InputView(),private val outPutView : OutputView = OutputView()) {

    fun run(){
        outPutView.printInputPrice()
        val price = inputView.inputPrice()
        outPutView.printBuyLotto(price)
        //TODO 구입 금액으로 로또 생성
        //TODO 당첨번호 입력
        //TODO 보너스 번호 입력
        //TODO 당첨 통계 구현
    }
}