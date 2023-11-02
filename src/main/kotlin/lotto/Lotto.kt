package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        {
            "[ERROR] 6개의 숫자가 필요합니다."
        }

        require(numbers.toSet().size == 6)
        {
            "[ERROR] 중복된 숫자가 존재해서는 안됩니다."
        }

        numbers.forEach {
            require(it in 1..45)
            {
                "[ERROR] 1부터 45까지의 숫자만 사용가능합니다."
            }
        }
    }

    // TODO: 추가 기능 구현
}
