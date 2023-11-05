package lotto

class LotteryGame {

    init {
        println("구입금액을 입력해 주세요.")
    }

    fun gameStart() {

        try {
            val bullet = readLine()!!.toInt()
            println(bullet)
        }
        catch (e: IllegalArgumentException) {
            println("[ERROR] 금액은 숫자로만 입력해주십시오.")
        }


    }

}