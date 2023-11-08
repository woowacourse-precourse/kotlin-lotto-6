package lotto

import lotto.model.LottoGenerator
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    private val lottoGenerator = LottoGenerator()

    @Test
    fun `입력받은 개수만큼의 로또를 생성해야 한다`(){
        assert( lottoGenerator.getLottos(10).size == 10)
    }

}