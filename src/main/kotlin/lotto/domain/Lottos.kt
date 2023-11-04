package lotto.domain

class Lottos(private val lottos: List<Lotto>) {
    fun <T> forEach(action: (T) -> Unit) {
        lottos.forEach { action }
    }

    fun size(): Int = lottos.size
}