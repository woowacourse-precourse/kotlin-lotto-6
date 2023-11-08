package lotto.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IssuerTest {
	@Test
	fun `d`() {
		assertThrows<IllegalArgumentException> {
			Lotto(listOf(1,2,3,4,5,6,7))
		}
	}
}