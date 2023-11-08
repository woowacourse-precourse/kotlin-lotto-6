package lotto.Model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {"[ERROR] 로또 번호는 정확히 6개여야 합니다."}
        require(numbers.all {it in 1..45}){"[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다. "}
        if(numbers.toSet().size !=numbers.size) {
            throw IllegalArgumentException("로또 번호에 중복된 숫자가 없어야합니다.")
        }
    }

    fun getNumbers() : List<Int> {
        return numbers
    }
    fun match(winningNumber: List<Int>) :Int {
        return  numbers.count {it in winningNumber }
    }

    fun BonusNumber (bonusNumber: Int) : Boolean {
        return bonusNumber in numbers
    }
}

