package lotto.domain.lotto

class Lottos(private val lottos: List<Lotto>) {
    fun forEach(action: (Lotto) -> Unit) = lottos.forEach { action(it) }
    fun joinToString(separator: CharSequence): String = lottos.joinToString(separator)
    fun size(): Int = lottos.size
}