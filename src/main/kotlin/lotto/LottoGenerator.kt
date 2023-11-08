package lotto

class LottoGenerator {
    companion object {
        private const val NUMBER_COUNT = 6
        private const val MAX_LOTTO_NUMBER = 45

        fun generateNumbers(): List<Int> {
            return (1..MAX_LOTTO_NUMBER).shuffled().take(NUMBER_COUNT).sorted()
        }

        fun generateMultipleSets(count: Int): List<Lotto> {
            return List(count) { Lotto(generateNumbers()) }
        }

    }
}