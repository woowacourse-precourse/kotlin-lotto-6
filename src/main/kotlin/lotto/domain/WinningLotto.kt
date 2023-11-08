package lotto.domain

import lotto.domain.LottoRank.*

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: List<Int>) {

  init {
    require(winningNumbers.size == 6)
    require(winningNumbers.size == winningNumbers.toSet().size)
    require(bonusNumber.size == 1)
    require(!winningNumbers.any{ number -> number == bonusNumber[0] })
  }

  fun compareLottos(lotto: Lotto) {
    val lottoNumbers = lotto.getLottoNumbers().toSet()
    val winningNumbers = this.winningNumbers.toSet()
    val intersection = lottoNumbers.intersect(winningNumbers)

    when (intersection.size) {
      3 -> FIFTH.addCount()
      4 -> FOURTH.addCount()
      5 -> {
        if (bonusNumber[0] in lottoNumbers) {
          SECOND.addCount()
        } else {
          THIRD.addCount()
        }
      }
      6 -> FIRST.addCount()
    }
  }

  fun calculateProfitRate() {

  }
}