package lotto

// 로또 번호를 관리하는 Lotto 클래스 정의
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "로또 번호의 개수는 6개여야 합니다."
        }
        require(numbers.toSet().size == 6) {
            "로또 번호에 중복된 숫자가 있습니다."
        }
    }
    // Lotto 내부 번호에 접근
    fun getNumbers(): List<Int> {
        return numbers
    }

    fun contains(number: Int): Boolean {
        return number in numbers
    }
    // 객체가 문자열일 때 사용
    override fun toString(): String = numbers.joinToString(separator = ", ")

}

// 로또 등수 설정
enum class Rank(val matchNum: Int, val winningMoney: Long) {
    Rank1(6, 2_000_000_000),
    Rank2(5, 30_000_000), // 보너스 번호 일치 시
    Rank3(5, 1_500_000), // 보너스 번호 불일치 시
    Rank4(4, 50_000),
    Rank5(3, 5_000),
    None(2, 0);

    // 보너스 번호 일치에 따라 등수 반환하는 함수
    companion object {
        fun valueOf(matchNum: Int, matchBonus: Boolean): Rank {
            return when {
                matchNum == 6 -> Rank1
                matchNum == 5 && matchBonus -> Rank2
                matchNum == 5 -> Rank3
                matchNum == 4 -> Rank4
                matchNum == 3 -> Rank5
                else -> None
            }
        }
    }
}
