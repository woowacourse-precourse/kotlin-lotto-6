package lotto.model

class LottoPaper(lottoLineCount: Int) {
    private var lottoNum: List<Lotto> = mutableListOf()

    init {
        lottoNum = createLottoPaper(lottoLineCount)
    }

    private fun createLottoPaper(lottoLineCount: Int): List<Lotto> {
        val createdLottoNum = mutableListOf<Lotto>()
        val lottoNumbersFactory = LottoNumbersFactory()
        for (i in 0 until lottoLineCount) {
            val lottoNumbers = lottoNumbersFactory.createLottoNumbers()
            createdLottoNum.add(lottoNumbers)
        }
        return createdLottoNum
    }

    fun getLottoPaper(): List<Lotto> = lottoNum
}