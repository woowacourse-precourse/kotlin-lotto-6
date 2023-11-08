package lotto.model.seller

import lotto.model.Lotto

class Ticket(private val lottos: List<Lotto>, val cost: Money) {

    val lottoCount: Int get() = lottos.size

    fun read(block: (Lotto) -> Unit) = lottos.forEach(block)

    override fun toString(): String = buildString {
        lottos.forEach { lotto -> appendLine(lotto.toStringNumbers()) }
    }.removeSuffix(SUFFIX)

    companion object {
        private const val SUFFIX = "\n"
    }
}