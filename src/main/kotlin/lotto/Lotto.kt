package lotto

// 로또 번호를 관리하는 Lotto 클래스 정의
class Lotto(private val numbers: List<Int>) {
    init { // Lotto 클래스가 인스턴스될 때 호출되는 초기화 블록
        require(numbers.size == 6) { "로또 숫자는 반드시 6개여야 합니다." }
    }

    // 당첨 번호와 몇 개가 일치하는 지 여부
    // numbers 리스트에서 당첨 번호 숫자 개수 확인
    fun matches(winningNums: Set<Int>): Int {
        return numbers.count { winningNums.contains(it) }
    }

    // 보너스 번호가 이 로또 번호 안에 있는지 여부
    // numbers 리스트에서 보너스 숫자 있는지 여부
    fun contains(bonusNum: Int): Boolean {
        return bonusNum in numbers
    }

    // 객체가 문자열일 때 사용
    override fun toString(): String = numbers.toString()
}