package lotto
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.")
        }

        require(numbers.size == 6)

        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException("[ERROR] 중복된 숫자가 없어야 합니다.")
        }
    }
}
