package lotto

import lotto.constant.OutputMessage
import lotto.domain.LottoSet

object Output {
    fun printLottoCount(lottoCount: Int) {
        println("")
        println(lottoCount.toString() + OutputMessage.MESSAGE_PRINT_LOTTO_COUNT)
    }
    fun printLottoNumber(lottoSet: LottoSet) {

        val lottoSetList = lottoSet.getLottoSet()

        for(i in lottoSetList.indices) {
            println(lottoSetList[i].getNumberPerLotto().joinToString(separator=", ",prefix="[",postfix="]"))
        }
    }

}