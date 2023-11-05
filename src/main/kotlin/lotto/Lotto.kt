package lotto

//로또 번호를 생성하고, 입력된 로또 번호와 당첨 번호를 비교하여 당첨 정보를 반환하는 역할을 합니다.
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    // TODO: 추가 기능 구현
}
