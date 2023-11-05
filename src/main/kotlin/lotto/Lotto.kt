package lotto

class Lotto(private val numbers: List<Int>) { // 파라미터로 당첨 번호를 받자
    val ticket = User().ticket
    var count3 = 0
    var count4 = 0
    var count5 = 0
    var count5_2 = 0
    var count6 = 0

    init {
        require(numbers.size == 6)
    }

    fun compare(bonusNumber: Int) {
        for (ticketNumbers in ticket) {
            val matchedCount = ticketNumbers.intersect(numbers).count()
            when (matchedCount) {
                3 -> count3++
                4 -> {
                    if (ticketNumbers.contains(bonusNumber)) count5_2++
                    else count4++
                }
                5 -> count5++
                6 -> count6++
            }
        }
    }


}
