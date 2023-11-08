package lotto
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    LottoGame().play()
}

data class Tuple(val amount: Int, val lottoPurchaseCount: Int, val prizeCounts: IntArray)

