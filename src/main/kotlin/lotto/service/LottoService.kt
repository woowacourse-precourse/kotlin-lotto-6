package lotto.service

import lotto.control.LottoControl
import lotto.model.LottoAllocate
import lotto.view.LottoView

class LottoService {
    private val model = LottoAllocate()
    private val view = LottoView()
    private val control = LottoControl(model,view)
    fun start(){
        control.run()
    }
}