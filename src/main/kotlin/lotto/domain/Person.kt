package lotto.domain

class Person(
    private val store: Store,
) : RetryUntilSuccess() {

    fun startTravelToBuyLotto() {
        val tickets = doUntilSuccess { store.buyLotto() }
        store.checkWinningLotto(tickets)
    }
}