package lotto

class Lottos{
    var lottos: MutableList<Lotto> = mutableListOf()

    fun add(lotto: Lotto) {
        lottos.add(lotto)
    }

    fun print() {
        lottos.forEach{
            println(it)
        }
    }
}