package lotto.domain

class Person(
    private val io: IO,
    private val store: Store,
) : RetryUntilSuccess() {
    fun startTravelToBuyLotto() {
        val tickets = doUntilSuccess { store.buyLotto() }
    }
}