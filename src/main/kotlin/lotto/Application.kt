package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.repository.LottoRepositoryImpl
import lotto.ui.presenter.LottoPresenter
import lotto.ui.view.ConsoleLottoView

fun main() {
    val view = ConsoleLottoView()
    val repository = LottoRepositoryImpl(randomNumberDataSource = Randoms::pickUniqueNumbersInRange)
    val presenter = LottoPresenter(view = view, repository = repository)

    LottoSimulator(view = view, presenter = presenter).start()
}
