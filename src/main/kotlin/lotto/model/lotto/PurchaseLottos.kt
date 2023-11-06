package lotto.model.lotto

class PurchaseLottos(private val lottos: List<Lotto>) {
    fun forEach(action: (Lotto) -> Unit) {
        lottos.forEach { lotto ->
            action(lotto)
        }
    }
}