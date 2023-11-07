package lotto

class LotteryGame {

    init {
        println("구입금액을 입력해 주세요.")
    }

    fun gameStart() {
        val count: Int = insertAmount() / 1000
        if (count == 0) return
        val lotto = Lotto(makeWinningNumber())
        val bonus: Int = readLine()!!.toInt()

        lotto.roundStart(bonus, count)


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
            throw IllegalArgumentException("[ERROR] 금액은 숫자로만 입력해주십시오.")
            return 0
        }
        return bullet
    }

    private fun makeWinningNumber(): List<Int> {
        var win_input: List<String> = readLine()!!.split(",")
        val numbers = mutableListOf<Int>()
        for (i in 0..win_input.size - 1) {
            numbers.add(win_input[i].toInt())
        }
        return numbers.distinct().sorted()
    }


}