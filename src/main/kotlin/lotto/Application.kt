package lotto

import kotlin.text.toInt
import java.util.Random
import lotto.Lotto

// import camp.nextstep.edu.missionutils.Randoms // pickUniqueNumbersInRange()
// import camp.nextstep.edu.missionutils.Console // readLine()
enum class Rank {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    BOOM
}
fun main() {
    
    println("구입금액을 입력해 주세요.")
    
    lateinit var inputPrice: String
    var price  = 0
    
    while (price == 0) {
        try {
            inputPrice = readLine()!!
            price = priceCheck(inputPrice)
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    var lottoList = mutableListOf<Lotto>()
    val randomValues = listOf<Int>(1,2,3,4,5,6)

    for(i in 1..price / 1000) {
        lottoList.add(Lotto(randomValues))
    }
    
    val result = Array(6) { 0 }
    val test1 = setOf<Int>(1, 2, 3, 4, 5)
    val test2 = setOf<Int>(12, 23, 41, 13, 6)

    val test3 = test1 + test2
    
    print("set size : ${test3.size}")
    println(lottoList.size)

}

fun priceCheck(inputPrice: String): Int {
    
    val result =inputPrice.toInt()
    if (result % 1000 == 0) {
        return result
    } else {
        throw IllegalArgumentException("[ERROR] 구입금액을 잘못 입력하였습니다.")
    }
}

