package lotto

class Lotto(private val numbers: List<Int>) {

    private var bonusNumber: Int = -1

    init {
        require(numbers.size == 6)
        checkLottoNumber(numbers)
        checkDuplicationNumber(numbers)
    }

    internal fun inputBonusNumber(value: Int) {
        bonusNumber = value
        checkBonusNumber(value)
    }

    internal fun result(randomLottoNumbers: List<List<Int>>): List<Place> {
        val places = mutableListOf<Place>()
        randomLottoNumbers.forEach { randomLottoNumber ->
            val intersection = randomLottoNumber - numbers.toSet()
            if (intersection.isEmpty()) {
                places.add(Place.FIRST)
            }
            if (intersection.size == 1 && !intersection.contains(bonusNumber)) {
                places.add(Place.SECOND)
            }
            if (intersection.size == 1) {
                places.add(Place.THIRD)
            }
            if (intersection.size == 2) {
                places.add(Place.FOURTH)
            }
            if (intersection.size == 3) {
                places.add(Place.FIFTH)
            }
        }
        return places
    }

    private fun checkLottoNumber(numbers: List<Int>) {
        val lottoNumberRange = 1..45
        numbers.forEach {
            if (!lottoNumberRange.contains(it)) {
                throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
            }
        }
    }

    private fun checkBonusNumber(number: Int) {
        val lottoNumberRange = 1..45
        if (!lottoNumberRange.contains(number)) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.")
        }
    }

    private fun checkDuplicationNumber(numbers: List<Int>) {
        if (numbers.size != numbers.toSet().size) {
            throw IllegalArgumentException("[ERROR] 로또 번호는 중복 될 수 없습니다.")
        }
    }
}
