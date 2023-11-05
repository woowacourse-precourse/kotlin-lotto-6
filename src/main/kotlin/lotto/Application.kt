package lotto

import lotto.domain.*

fun main() {
    val validator = Validator()
    val io = IO(validator)
    val pos = PointOfSales()
    val store = Store(io, pos)
    val person = Person(io, store)

    person.startTravelToBuyLotto()
}
