package lotto

class LottoStore {

    fun startSellLotto() {
        val seller = LottoSeller(2000).generateLottoNumbers()

        for (lotto in seller) {
            val lottoNumbers = lotto.generate()
            println(lottoNumbers)
        }
    }
}


/*
val seller = LottoSeller(2).generateLottoNumbers()

    for (lottoGenerator in seller) {
        val lottoNumbers = lottoGenerator.generate()
        println(lottoNumbers)
    }
 */