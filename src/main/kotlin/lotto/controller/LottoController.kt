package lotto.controller

import lotto.view.InputView
import lotto.view.OutputView

class GameController(
    private val inputView: InputView=InputView(),
    private val outputView: OutputView=OutputView()
) {

    fun gameStarter(){
        outputView.lottoStartMessage()
    }

    fun gameProgress(){

    }
}