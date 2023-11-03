package lotto
import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        if (numbers.size != 6) {
            throw IllegalArgumentException("[ERROR] 6개의 숫자를 입력하세요.")
        }

        require(numbers.size == 6)

        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException("[ERROR] 중복되는 숫자가 없어야 합니다.")
        }

        if (numbers.any { it < 1 || it > 45 }) {
            throw IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자만 입력하세요.")
        }

    }
}
