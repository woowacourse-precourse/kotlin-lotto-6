package lotto
import camp.nextstep.edu.missionutils.Randoms
import lottoViewModel.CreateNumbers
import lottoViewModel.ValidInput
import java.lang.IllegalArgumentException

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }


}
