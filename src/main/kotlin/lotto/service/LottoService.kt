package lotto.service

import lotto.controller.LottoController
import lotto.model.LottoModel
import lotto.view.LottoView

class LottoService {
    private val model = LottoModel()
    private val view = LottoView()
    private val control = LottoController(model,view)
    fun start(){
        control.run()
    }
}