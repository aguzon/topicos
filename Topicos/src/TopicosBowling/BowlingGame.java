package TopicosBowling;

public class BowlingGame {
	/**
	 * @author Agustin
	 *
	 */
	int[] rolls;
	int currentRoll;

	public BowlingGame() {
		this.rolls = new int[10];
	}

	public void roll(int p) {
		rolls[currentRoll++] = p;
	}

	public int score() {
		int score = 0;
		int frame = 0;

		for (int i = 0; i < 10; i++) {
			/**
			 * si el primer roll (tiro) fue strike un pleno
			 */
			if (isStrike(frame)) {
				score += 10;
				frame++;
			} else if (isSpare(frame)) {
				score += 10;
				frame += 2;
			} else {
				score += sumOfRolls(frame);
				frame += 2;
			}
		}

		return score;
	}

	private boolean isStrike(int frame) {
		return rolls[frame] == 10;
	}

	private boolean isSpare(int frame) {
		return sumOfRolls(frame) == 10;
	}


	private int sumOfRolls(int frame) {
		return rolls[frame] + rolls[frame+1];
	}
}
