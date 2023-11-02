package lotto.io.input

import lotto.model.Lotto

class InputConverter {
    fun convertLotto(lottoWithComma: String) =
         Lotto(lottoWithComma.split(",").map { it.toInt() })
}