package lotto

import lotto.CheckData.checkBonusNum
import lotto.CheckData.checkInputMoney
import lotto.CheckData.checkLottoNum
import lotto.LottoCalculating.calculateEarnings
import lotto.LottoCalculating.calculateStats
import lotto.LottoData.bonusNum
import lotto.LottoData.lottoNums
import lotto.LottoData.lottoResult
import lotto.LottoData.profitRatio
import lotto.LottoData.purchaseNum
import lotto.LottoData.stats
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*



object LottoController {

    fun lottoPurchase(): Int {
        while (true) {
            try {
                println("구입금액을 입력해주세요.")
                val inputMoney = Console.readLine()
                checkInputMoney(inputMoney)

                val lottoCount = inputMoney.toInt() / 1000
                println("$lottoCount 개를 구매했습니다.")

                return lottoCount
            } catch (e: IllegalArgumentException) {
                println("예외 발생: ${e.message} 다시 입력해주세요.")
            }
        }
    }

    fun lottoDraw() {
        repeat(LottoData.purchaseNum) {
            val lottoNum = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            Lotto(lottoNum).printNumbers()
        }
    }


}
