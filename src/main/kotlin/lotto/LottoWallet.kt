package lotto

class LottoWallet(private val lottoList: MutableList<Lotto> = mutableListOf()) {

    fun addLotto(lotto: Lotto) {
        lottoList.add(lotto)
    }
}