package lotto.domain

class WinningDetails(winningLotto: WinningLotto, lottoWallet: LottoWallet) {
    private var prize: Map<LottoResult, Int> = LottoResult.values().associateWith { 0 }
    var earnedMoney = 0.0

    init {
        prize += lottoWallet.compareWithWinningLotto(winningLotto).groupingBy { it }.eachCount()
        prize.forEach {
            earnedMoney += it.key.prize * it.value
        }
    }

    override fun toString(): String {
        var message = "\n당첨 통계\n---\n"
        prize.forEach {
            if (it.key.name != LottoResult.NONE.name)
                message += "${it.key.toMessage()}${it.value}개\n"
        }
        return message
    }
}