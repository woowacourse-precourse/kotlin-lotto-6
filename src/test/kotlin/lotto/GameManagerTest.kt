package lotto

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GameManagerTest {
    val gameManager = GameManager()
    @Test
    fun `getRandomNumbers()가 중복되는 숫자를 반환하지 않는가`() {
        val numbers = gameManager.getRandomNumbers()
        val numbersToSet = numbers.toSet()
        Assertions.assertEquals(6, numbers.size, "중복된 숫자가 있습니다.")
    }
}