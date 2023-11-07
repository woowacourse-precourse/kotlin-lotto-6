package lotto

class LotteryGame {

    enum class won(var count: Int) {
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
        val win_num = enterWinningNumber()
        val bonus: Int = enterBonusNumber()

        for (i in tickets) {
            check(i.round(win_num, bonus))
        }

        printResult()
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

    private fun enterWinningNumber(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        var win_input: List<String> = readLine()!!.split(",")
        val numbers = mutableListOf<Int>()

        for (i in 0..win_input.size - 1) {
            numbers.add(win_input[i].toInt())
        }

        return numbers.distinct().sorted()
    }

    private fun enterBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        return readLine()!!.toInt()
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

    private fun check(count: Int) {
        when(count) {
            1 -> won.FIRST.count++
            2 -> won.SECOND.count++
            3 -> won.THIRD.count++
            4 -> won.FOURTH.count++
            5 -> won.FIFTH.count++
        }
    }

    private fun printResult() {
        println("당첨 통계")
        println("---")
        println("3개 일치 (5,000원) - " + won.FIFTH.count.toString() + "개")
        println("4개 일치 (50,000원) - " + won.FOURTH.count.toString() + "개")
        println("5개 일치 (1,500,000원) - " + won.THIRD.count.toString() + "개")
        println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + won.SECOND.count.toString() + "개")
        println("6개 일치 (2,000,000,000원) - " + won.FIRST.count.toString() + "개")
    }

}