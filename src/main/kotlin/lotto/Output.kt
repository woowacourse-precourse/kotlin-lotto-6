package lotto

import lotto.constant.OutputMessage

object Output {
    fun printLottoCount(lottoCount: Int) {
        println("")
        println(lottoCount.toString() + OutputMessage.MESSAGE_PRINT_LOTTO_COUNT)
    }

}