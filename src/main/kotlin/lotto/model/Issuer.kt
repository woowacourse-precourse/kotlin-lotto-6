package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.global.Config

data class Issuer(
	var numbers: MutableSet<Int> = mutableSetOf()
) {
	init {
		while (this.numbers.size < Config.NUMBER_DRAW.value) {
			val randomNumber = Randoms.pickNumberInRange(1, Config.LOTTO_RANGE.value)
			if(!this.numbers.contains(randomNumber)) {
				this.numbers.add(randomNumber)
			}
		}
		this.numbers = numbers.toSortedSet()
	}
}