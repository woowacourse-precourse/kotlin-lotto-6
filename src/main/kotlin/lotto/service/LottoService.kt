package lotto.service

import lotto.model.LottoModel
import lotto.view.LottoView
import lotto.controller.LottoController
class LottoService {
    private val model = LottoModel()
    private val view = LottoView()
    private val controller = LottoController(view = view, model = model)
    fun run() {
        controller.run()
    }
}