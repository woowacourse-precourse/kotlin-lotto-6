package lotto.model

data class Lottos(
    val lottoNumbers: List<Lotto>
) {
    override fun toString(): String {
        return lottoNumbers.joinToString("\n")
    }
}