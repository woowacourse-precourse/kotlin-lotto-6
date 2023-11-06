package lotto

import lotto.domain.*

fun main() {
    val pos = PointOfSales()
    val store = Store(IO.getInstance(), pos)
    val person = Person(store)

    person.startTravelToBuyLotto()
}
