package lotto.domain;

public class MatchedNumber {
	private static final int WINNER_MIN_BOUNDARY_VALUE = 3;
	private final int matchedNumber;

	public MatchedNumber(int matchedNumber) {
		this.matchedNumber = matchedNumber;
	}

	public int value() {
		return matchedNumber;
	}

	public boolean isWinner() {
		return matchedNumber >= WINNER_MIN_BOUNDARY_VALUE;
	}
}
