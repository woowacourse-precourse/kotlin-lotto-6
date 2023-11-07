package lotto.data

import lotto.model.LottoResult
import lotto.model.PlayLottoState
import lotto.resources.Lotto.INIT_DOUBLE_VALUE
import lotto.resources.Lotto.INIT_VALUE

data class LottoData(
    var winningNumbers: List<Int> = emptyList(),
    var purchaseAmount : Double = INIT_DOUBLE_VALUE,
    var bonusNumber : Int = INIT_VALUE,
    var currentState : PlayLottoState = PlayLottoState.IDLE
) {
    var lotteries: List<List<Int>> = emptyList()
        set(value) {
            value.forEach(::println)
            field = value
        }

    var lottoResults : List<LottoResult> =
        LottoMatchInfo.entries.dropLast(1).map { lottoMatchInfo ->
            LottoResult(lottoMatchInfo = lottoMatchInfo)
        }
}