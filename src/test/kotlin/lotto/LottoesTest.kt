package lotto.model

import org.junit.jupiter.api.BeforeEach

class LottoesTest {

    private lateinit var lottoes: Lottoes

    @BeforeEach
    fun setUp() {
        lottoes = Lottoes(setOf(1, 2, 3, 4, 5, 6), 7, "1000")
    }


}