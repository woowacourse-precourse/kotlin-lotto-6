package lotto.global

enum class Prize(val rank: Int, val amount: Int) {
	FIRST(1, 2000000000),
	SECOND(2, 30000000),
	THIRD(3, 1500000),
	FOURTH(4, 50000),
	FIFTH(5, 5000);

	fun calculation(number: Int) = amount * number

	companion object {
		private val map = Prize.values().associateBy { it.rank }
		fun from(rank: Int) = Prize.values().first { it.rank == rank }
	}
}