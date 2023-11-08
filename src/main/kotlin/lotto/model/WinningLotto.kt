package lotto.model

class WinningLotto(private val lottoWinningNumbers: Lotto, private val lottoBonusNumber: Int) {
    init {
        require(lottoBonusNumber !in lottoWinningNumbers.getLotto()) {"[ERROR] 보너스 번호가 당첨 번호와 중복 됩니다."}
    }

    fun getLottoWinningNumbers(): Lotto {
        return lottoWinningNumbers
    }

    fun getLottoBonusNumber(): Int {
        return lottoBonusNumber
    }
}