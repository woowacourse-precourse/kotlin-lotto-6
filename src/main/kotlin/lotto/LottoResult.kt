package lotto

data class LottoResult(
        val threeContains: MutableList<Any> = mutableListOf(),
        val fourContains: MutableList<Any> = mutableListOf(),
        val fiveContains: MutableList<Any> = mutableListOf(),
        val fiveBonusContains: MutableList<Any> = mutableListOf(),
        val sixContains: MutableList<Any> = mutableListOf(),
)