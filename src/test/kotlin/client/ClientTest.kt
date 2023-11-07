package client

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClientTest {

    @Test
    fun formatNumber() {
        val result = Client().formatNumber(2221.284F)
        assertEquals(result, "2,221.3")
    }

}