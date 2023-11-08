package lotto

import lotto.domain.*

fun main() {
    val calculator = Calculator()
    val analyzer = Analyzer(calculator)
    val pos = PointOfSales(analyzer)
    val store = Store(IO.getInstance(), calculator, pos)
    val person = Person(store)

    person.startTravelToBuyLotto()
}
