package lotto

class LottoService {
    fun buyLotto(buyCount: Int): List<Lotto> {
        val buyLottos = mutableListOf<Lotto>()
        repeat(buyCount) {
            buyLottos.add(Lotto(lottoMaker()))
        }
        return buyLottos
    }
}
