package lotto
// val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

// 제공된 Lotto 클래스를 활용해 구현해야 한다.
// numbers의 접근 제어자인 private을 변경할 수 없다.
// Lotto에 필드를 추가할 수 없다.
// Lotto의 패키지 변경은 가능하다.
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
}
