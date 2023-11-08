package lotto.domain

class Person(
    private val store: Store,
) : RetryStrategy() {

    fun startTravelToBuyLotto() {
        val tickets = doUntilSuccess { store.buyLotto() }
        store.checkResult(tickets)
    }
}