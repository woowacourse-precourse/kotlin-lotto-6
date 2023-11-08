package lotto.util

import lotto.model.Lotto

interface LottosGenerator {
    fun generate(cnt: Int): List<Lotto>

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 45
    }
}
