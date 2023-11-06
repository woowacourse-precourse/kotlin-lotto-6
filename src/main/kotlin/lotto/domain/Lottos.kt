package lotto.domain

class Lottos(private val _lottos: List<Lotto>) {
    fun getLottos() = _lottos
    fun getPrice() = _lottos.size * 1000

    fun getMatchingCount(lotto: Lotto, winningLotto: WinningLotto): Int {
        return winningLotto.getWinningNumbers().count { lotto.hasNumber(it) }
    }

    fun isBonusMatch(lotto: Lotto, winningLotto: WinningLotto): Boolean {
        return lotto.hasNumber(winningLotto.getBonusNumber())
    }

    override fun toString(): String {
        return _lottos.joinToString("\n")
    }
}