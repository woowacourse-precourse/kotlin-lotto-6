package lotto.domain

import lotto.domain.lotto.LottoResult
import lotto.domain.lotto.LottoWallet
import lotto.util.LOTTO_PRICE

class WinningDetails(winningLotto: WinningLotto, lottoWallet: LottoWallet) {
    private var prize: Map<LottoResult, Int> = LottoResult.values().associateWith { 0 }
    private var earnedMoney = 0.0
    private var earningRate = 0.0

    init {
        prize += lottoWallet.compareWithWinningLotto(winningLotto).groupingBy { it }.eachCount()
        prize.forEach {
            earnedMoney += it.key.prize * it.value
        }
        earningRate = earnedMoney / (lottoWallet.lottoCount * LOTTO_PRICE) * 100
    }

    override fun toString(): String {
        var message = "\n당첨 통계\n---\n"
        prize.forEach {
            if (it.key.name != LottoResult.NONE.name)
                message += "${it.key.toMessage()}${it.value}개\n"
        }
        message += "총 수익률은 ${String.format("%.1f", earningRate)}%입니다.\n"
        return message
    }
}