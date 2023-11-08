package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.IssueLotto
import lotto.view.Input

fun main() {
    //val a = IssueLotto()
    //val m = a.issue(3)
    //println(m)

    val a = Input().buyLotto()
    println(a)
}
