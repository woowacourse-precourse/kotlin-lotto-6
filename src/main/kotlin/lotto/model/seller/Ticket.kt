package lotto.model.seller

import lotto.model.Lotto

class Ticket(val cost: Money) {

    private val lottos = arrayListOf<Lotto>()

    val lottoCount: Int get() = lottos.size

    fun record(lotto: Lotto): Boolean = lottos.add(lotto)

    fun read(block: (Lotto) -> Unit) = lottos.forEach(block)

    override fun toString(): String = buildString {
        lottos.forEach { lotto -> appendLine(lotto.toStringNumbers()) }
    }.removeSuffix("\n")
}