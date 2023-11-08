package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.toSet().size == 6) { "로또 번호에 중복된 숫자가 있으면 예외가 발생합니다." }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1에서 45 사이여야 합니다." }

    }

    fun printNumbers() : List<Int> // 오름차순 정렬
    {
        return numbers.sorted()
    }

    fun getMatchedNumbers(winningNumbers: List<Int>): Int { // 몇 개 겹쳤는 지 확인
        return numbers.intersect(winningNumbers).count()
    }

    fun containsNumber(bonusNumber: Int): Boolean { // 보너스 숫자 확인
        return bonusNumber in numbers
    }
}
