import lotto.Exceptions.Exceptions
import lotto.Model.Lotto
import lotto.Model.LottoGameModel
import lotto.Model.Score
import java.util.EnumMap

object LottoGameView {
    fun inputHowManyBuyLotto(): Int {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val lottoPrice = readLine()
            try {
                return Exceptions.howManyBuyLottoIsValid(lottoPrice)
            } catch (e: IllegalArgumentException) {
                println("${e.message}\n")
            }
        }
    }

    fun inputLottoNumbers() : Lotto {
        while (true){
            printInputLottoNumberMessage()
            val inputLotto = readLine()
            try{
                return Exceptions.checkInputLottoNumbersAreValid(inputLotto)
            }catch (e: IllegalArgumentException) {
                println("${e.message}")
            }
        }
    }

    fun printInputLottoNumberMessage(){
        println("\n당첨 번호를 입력해 주세요.")
    }

    fun printWinningLottoNumbers(lottoList: List<Lotto>){
        printHowManyBuyLotto(lottoList.size)
        lottoList.forEach { _lotto -> println(_lotto.getLottoNumbers()) }
        println()
    }

    fun printHowManyBuyLotto(howManyBuyLotto : Int){
        println("\n${howManyBuyLotto}개를 구매했습니다.")
    }

    fun inputLottoBonusNumbers(inputLotto: Lotto): Int {
        while (true){
            val bonusNumber = printInputBonusNumberMessage()
            try {
                return Exceptions.checkInputLottoBonusNumberIsValid(bonusNumber, inputLotto)
            }catch (e:Exception){
                println("${e.message}")
            }
        }
    }

    fun printInputBonusNumberMessage() : String? {
        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = readLine()
        return bonusNumber
    }

    fun printLottoResult(checkUserLotto: EnumMap<Score, Int>, howManyBuyLotto: Int){
        printProfitRateMessage()
        printLottoMatchCount()
        printProfitRate(checkUserLotto,howManyBuyLotto)
    }

    fun printProfitRateMessage(){
        println("\n당첨 통계\n---")
    }

    fun printLottoMatchCount(){
        Score.values().forEach {_score ->
            println("${_score.message}${LottoGameModel.checkUserLottoScore.getOrDefault(_score,0)}개")
        }
    }

    fun printProfitRate(checkUserLotto: EnumMap<Score, Int>, howManyBuyLotto: Int){
        val profitRate = getProfitRate(checkUserLotto,howManyBuyLotto)
        println("총 수익률은  ${profitRate}%입니다.")
    }

    private fun calculateTotalPrize(userLottoMap: EnumMap<Score, Int>): Int {
        return userLottoMap.entries.sumBy { (prize, numbers) -> prize.score * numbers }
    }

    private fun roundToTwoDecimalPlaces(value: Double): Double {
        return "%.2f".format(value).toDouble()
    }

    fun getProfitRate(checkUserLotto : EnumMap<Score,Int>, howManyBuyLotto: Int) : Double{
        val totalPrize = calculateTotalPrize(checkUserLotto)
        val profitRate = (totalPrize / howManyBuyLotto.toDouble()) * 100.0
        return roundToTwoDecimalPlaces(profitRate)
    }
}
