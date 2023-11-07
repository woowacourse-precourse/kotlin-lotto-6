package lotto

import kotlin.text.toInt

// import camp.nextstep.edu.missionutils.Randoms // pickUniqueNumbersInRange()
// import camp.nextstep.edu.missionutils.Console // readLine()

fun main() {
    
    println("구입금액을 입력해 주세요.")
    
    var stopPoint = 1
    lateinit var price: String

    while (stopPoint == 1) {
        try {
            price = readLine()!!
            stopPoint = priceCheck(price)
        } catch (e: IllegalArgumentException) {
            println(e)
        }
    }

    
    println(price)

}

fun priceCheck(price: String): Int {
    
    val temp =price.toInt()
    if (temp % 1000 == 0) {
        return 0
    } else {
        throw IllegalArgumentException("[ERROR] 구입금액을 잘못 입력하였습니다.")
    }
}