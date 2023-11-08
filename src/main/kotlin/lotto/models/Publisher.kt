package lotto.models

class Publisher(private val publishingLottoCount: Int) {

    fun publishLottos(): List<Lotto> {
        val publishedLottos = mutableListOf<Lotto>()

        return publishedLottos
    }
}