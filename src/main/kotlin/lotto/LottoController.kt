import CheckData.checkBonusNum
import CheckData.checkInputMoney
import CheckData.checkLottoNum
import LottoCalculating.calculateEarnings
import LottoCalculating.calculateStats
import LottoData.bonusNum
import LottoData.lottoNums
import LottoData.lottoResult
import LottoData.profitRatio
import LottoData.purchaseNum
import LottoData.stats
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


}
