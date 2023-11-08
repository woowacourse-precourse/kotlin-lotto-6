package lotto

import lotto.view.Msg

class PrintLotto(private val count:Int, private val lottos:List<Lotto>) {
    fun showLotto() {
        println(StringBuilder(count.toString()).append(Msg.OUTPUT_LOTTO_NUMBER.msg).toString())
        for (lotto in lottos) {
            println(lotto.numbers)
        }
    }
}