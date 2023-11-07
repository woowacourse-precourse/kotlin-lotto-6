package lotto

class LotteryGame {

    init {
        println("구입금액을 입력해 주세요.")
    }

    fun gameStart() {
        var count = 0

        do {
            count = insertAmount()
        } while (count == 0)

        println(makeAnswer())

    }

    private fun insertAmount(): Int {
        var bullet: Int = 0
        try {
            bullet = readLine()!!.toInt()
            println(bullet)
        } catch (e: IllegalArgumentException) {
            println("[ERROR] 금액은 숫자로만 입력해주십시오.")
        }

        if (bullet % 1000 != 0){
            println("[ERROR] 금액은 1,000원 단위로만 입력해주십시오.")
            throw IllegalArgumentException()
            return 0
        }
        return bullet
    }


}