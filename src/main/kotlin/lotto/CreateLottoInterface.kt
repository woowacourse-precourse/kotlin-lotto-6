package lotto

interface CreateLottoInterface {
    fun getLotto(): Lotto
    fun getLottos(count: Int): List<Lotto>
}