package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println(makeLotto().toString())
}

fun getMoney(): Int {
    println("구입금액을 입력해 주세요.")
    return Console.readLine().trim().toInt()
}

fun makeLotto(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers.sorted())
