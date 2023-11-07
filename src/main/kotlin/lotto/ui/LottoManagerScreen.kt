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
        println("당첨 통계")
        println("---")
        println("${ConstString.Three_Corresponding} (${ConstString.Three_Lotto_Amount}원) - ${lottoResult.three}개")
        println("${ConstString.Four_Corresponding} (${ConstString.Four_Lotto_Amount}원) - ${lottoResult.four}개")
        println("${ConstString.Five_Corresponding} (${ConstString.Five_Lotto_Amount}원) - ${lottoResult.five}개")
        println("${ConstString.Five_Bonus_Corresponding} (${ConstString.Five_Bonus_Lotto_Amount}원) - ${lottoResult.bonus}개")
        println("${ConstString.Six_Corresponding} (${ConstString.Six_Lotto_Amount}원) - ${lottoResult.six}개")
        println("총 수익률은 ${revenue}%입니다.")


    }


}