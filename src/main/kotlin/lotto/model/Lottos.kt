package lotto.model

class Lottos {
    private val lottos = mutableListOf<Lotto>()

    fun add(lotto: Lotto) = lottos.add(lotto)
}