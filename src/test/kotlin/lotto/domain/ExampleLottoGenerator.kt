package lotto.domain

class ExampleLottoGenerator : RandomGenerator {
    override fun pickNumberInRange(startNum: Int, endNum: Int, size: Int): List<Int> {
        return listOf(8, 21, 23, 41, 42, 43)
    }
}