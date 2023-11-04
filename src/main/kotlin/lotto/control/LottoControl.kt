package lotto.control

import lotto.Lotto
import lotto.model.LottoAllocate
import lotto.view.LottoView

class LottoControl(private val model: LottoAllocate,private val view : LottoView) {
    fun run(){
        view
    }
}