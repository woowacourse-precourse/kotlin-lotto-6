package lotto

class OutputView {
    fun printOneLotto(oneLotto: List<Int>) {
        println("[${oneLotto.joinToString(", ")}]")
    }
}