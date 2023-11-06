package ui

import domain.Lotto
import model.Winning

class OutputManager {
    fun promptPurchaseAmount() = println(OutputMessages.PROMPT_PURCHASE_AMOUNT)
    fun invalidPurchaseAmount() = println("${OutputMessages.INVALID_PURCHASE_AMOUNT} ${OutputMessages.RE_TRY}")
    fun invalidLottoNumbers() = println("${OutputMessages.INVALID_LOTTO_NUMBERS} ${OutputMessages.RE_TRY}")
    fun invalidBonusNumber() = println("${OutputMessages.INVALID_BONUS_NUMBER} ${OutputMessages.RE_TRY}")
    fun purchaseLottoCount(lottoCount: Int) = println(OutputMessages.PURCHASE_LOTTO_COUNT.toString().format(lottoCount))
    fun lottoNumbers(lottoNumber: List<Lotto>) { lottoNumber.forEach { println(it.getSortedNumbers()) } }
    fun promptJackpotNumbers() = println(OutputMessages.PROMPT_JACKPOT_NUMBERS)
    fun promptBonusNumber() = println(OutputMessages.PROMPT_BONUS_NUMBER)
    fun prizeResult(prize: Array<Int>) {
        Winning.values().forEachIndexed { index, winning ->
            println("$winning${prize[index]}개")
        }
    }
    fun lottoStats() = println(OutputMessages.LOTTO_STATS)
    fun rateOfReturn(lottoRateOfReturn: String) = println(OutputMessages.RATE_OF_RETURN.toString().format(lottoRateOfReturn))
}

enum class OutputMessages(private val message: String) {
    ERROR("[ERROR]"),
    INVALID_PURCHASE_AMOUNT("$ERROR 유효하지 않은 금액입니다."),
    INVALID_LOTTO_NUMBERS("$ERROR 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("$ERROR 보너스 번호는 당첨번호와 중복되면 안됩니다."),
    PROMPT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PROMPT_JACKPOT_NUMBERS("\n당첨 번호를 입력해 주세요."),
    PROMPT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    PURCHASE_LOTTO_COUNT("\n%d개를 구매했습니다."),
    RE_TRY("다시 입력해주세요."),
    LOTTO_STATS("\n당첨 통계\n---"),
    RATE_OF_RETURN("총 수익률은 %s입니다.");

    override fun toString(): String = message
}
