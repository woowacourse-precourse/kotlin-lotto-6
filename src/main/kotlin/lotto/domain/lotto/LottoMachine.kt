package lotto.domain.lotto

object LottoMachine {

    fun buyLotto(lottoCount: Int): LottoWallet {
        val lotteries = mutableListOf<Lotto>()
        repeat(lottoCount) {
            lotteries.add(LottoGenerator.generateLottoNumber())
        }
        return LottoWallet(lotteries)
    }
}