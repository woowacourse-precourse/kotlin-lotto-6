package lotto.ui

import lotto.data.ConstString
import lotto.data.LottoResult
import java.math.BigDecimal

class LottoManagerScreen(lottoResult: LottoResult, lottoRevenue: Double) {

    private var lottoResult : LottoResult = LottoResult()
    private var revenue  : Double


    init {
        this.lottoResult = lottoResult
        this.revenue = lottoRevenue
    }

    fun printLottoResult() {
        println(ConstString.LOTTO_STATISTICS)
        println("---")
        println("${ConstString.THREE_CORRESPONDING} (${ConstString.THREE_LOTTO_AMOUNT}원) - ${lottoResult.three}개")
        println("${ConstString.FOUR_CORRESPONDING} (${ConstString.FOUR_LOTTO_AMOUNT}원) - ${lottoResult.four}개")
        println("${ConstString.FIVE_CORRESPONDING} (${ConstString.FIVE_LOTTO_AMOUNT}원) - ${lottoResult.five}개")
        println("${ConstString.FIVE_BONUS_CORRESPONDING} (${ConstString.FIVE_BONUS_LOTTO_AMOUNT}원) - ${lottoResult.bonus}개")
        println("${ConstString.SIX_CORRESPONDING} (${ConstString.SIX_LOTTO_AMOUNT}원) - ${lottoResult.six}개")
        println(ConstString.REVENUE_MESSAGE.format(revenue))


    }


}