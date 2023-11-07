package lotto

class LotteryGame {

    enum class won(val count: Int) {
        FIRST(0),
        SECOND(0),
        THIRD(0),
        FOURTH(0),
        FIFTH(0);
    }

    init {
        println("구입금액을 입력해 주세요.")
    }

    fun gameStart() {
        val count: Int = insertAmount() / 1000
        if (count == 0) return

        val tickets = makeTickets(count)

        val win_num = makeWinningNumber()
        val bonus: Int = readLine()!!.toInt()

        for (i in tickets) {

        }

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

    private fun makeTickets(count: Int): MutableList<Lotto> {
        val tickets = mutableListOf<Lotto>()
        val generator = NumberGenerator()

        println("$count" + "개를 구매했습니다.")

        for (i in 1..count) {
            tickets.add(Lotto(generator.numberGenerate()))
        }

        return tickets
    }


}