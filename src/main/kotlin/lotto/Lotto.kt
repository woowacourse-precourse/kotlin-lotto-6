package lotto

class Lotto(private val numbers: List<Int>) { // 파라미터로 당첨 번호를 받자
    var count3 = 0
    var count4 = 0
    var count5 = 0
    var count5_2 = 0
    var count6 = 0

    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6) {throw IllegalArgumentException("${LottoMachine.ERROR_MESSAGE}로또 번호는 1부터 45 사이의 중복되지 않는 숫자여야 합니다.") }
    }

    fun compare(ticket: MutableList<List<Int>>, bonusNumber: Int): Int {
        for ((index, ticketNumbers) in ticket.withIndex()) {
            val matchedCount = ticketNumbers.intersect(numbers).count()
            when (matchedCount) {
                3 -> count3++
                4 -> count4++
                5 -> {
                    if (ticketNumbers.contains(bonusNumber)) count5_2++
                    else count5++
                }

                6 -> count6++
            }
        }
        return count3
    }


}
