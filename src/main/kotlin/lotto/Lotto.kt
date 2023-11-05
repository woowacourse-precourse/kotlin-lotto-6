package lotto

class Lotto(private val numbers: List<Int>) { // 파라미터로 당첨 번호를 받자
    val ticket = User().ticket

    init {
        require(numbers.size == 6)
    }

    fun compare() {
        for ((index, value) in ticket.withIndex()) {

        }
        //var sameNumber = ticket.wiintersect(numbers).count()
    }


}
