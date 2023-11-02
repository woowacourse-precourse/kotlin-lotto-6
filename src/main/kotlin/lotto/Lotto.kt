package lotto
import camp.nextstep.edu.missionutils.Randoms
import lottoViewModel.ValidInput
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun createRandomNumber(): List<Int> {
        val randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
       return randomNumbers+numbers
    }
    fun reCreateRandomNumber(count: Int): List<List<Int>> {
        val generatedNumbers = mutableListOf<List<Int>>()
        for (generate in 0 until count) {
            val randomNumbers = createRandomNumber()
            generatedNumbers.add(randomNumbers)
        }
        return generatedNumbers
    }

}
