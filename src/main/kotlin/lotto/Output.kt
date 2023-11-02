package lotto

import lotto.constant.OutputMessage
import lotto.domain.LottoSet
import lotto.domain.Winning

object Output {
    fun printLottoCount(lottoCount: Int) {
        println("")
        println(lottoCount.toString() + OutputMessage.MESSAGE_PRINT_LOTTO_COUNT)
    }
    fun printLottoNumber() {

        val lottoSetList = LottoSet.getLottoSet()

        for(i in lottoSetList.indices) {
            println(lottoSetList[i].getNumberPerLotto().joinToString(separator=", ",prefix="[",postfix="]"))
        }
    }

}