package lotto

import lotto.domain.*

fun main() {
    val pos = PointOfSales()
    val store = Store(IO.getInstance(Validator.getInstance()), pos)
    val person = Person(IO.getInstance(Validator.getInstance()), store)

    person.startTravelToBuyLotto()
}
