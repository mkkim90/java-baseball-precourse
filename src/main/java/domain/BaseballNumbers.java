package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BaseballNumbers {
	private static final String VALID_NUMBER_MESSAGE = "����(����)�� �Է� �����մϴ�.";
	private static final String OUT_OF_NUMBER_LENGTH_MESSAGE = "���ڸ� ������ �Է����ּ���.";
	private static final int TOTAL_NUMBER_LENGTH = 3;

	private final List<BaseballNumber> baseballNumbers;

	public BaseballNumbers(String baseballNumbers) {
		validateBaseballNumbers(baseballNumbers);
		this.baseballNumbers = convertBaseballNumbersType(baseballNumbers);
	}

	private List<BaseballNumber> convertBaseballNumbersType(String baseballNumbers) {
		List<String> baseballNumbersList = Arrays.asList(baseballNumbers.split(""));
		List<BaseballNumber> convertBaseballNumbers = new ArrayList<>();
		for (String baseballNumber : baseballNumbersList) {
			convertBaseballNumbers.add(new BaseballNumber(Integer.parseInt(baseballNumber)));
		}
		return convertBaseballNumbers;
	}

	private void validateBaseballNumbers(String baseballNumbers) {
		Objects.requireNonNull(baseballNumbers);
		validateNumber(baseballNumbers);
		validateLength(baseballNumbers);
	}

	private void validateNumber(String baseballNumbers) {
		if (!isNumber(baseballNumbers)) {
			throw new IllegalArgumentException(VALID_NUMBER_MESSAGE);
		}

	}

	private void validateLength(String baseballNumbers) {
		if (baseballNumbers.length() != TOTAL_NUMBER_LENGTH) {
			throw new IllegalArgumentException(OUT_OF_NUMBER_LENGTH_MESSAGE);
		}
	}

	private boolean isNumber(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public int countStrike(List<BaseballNumber> randomNumbers) {
		int countStrike = 0;
		for (int i = 0; i < TOTAL_NUMBER_LENGTH; i++) {
			countStrike += getStrikeCount(i, randomNumbers.get(i));
		}
		return countStrike;
	}

	private int getStrikeCount(int i, BaseballNumber randomNumber) {
		if (isStrike(i, randomNumber)) {
			return 1;
		}
		return 0;
	}

	public boolean isStrike(int i, BaseballNumber randomNumber) {
		return baseballNumbers.get(i).equals(randomNumber);
	}

	public int countBall(List<BaseballNumber> randomNumbers) {
		int countBall = 0;
		for (int i = 0; i < TOTAL_NUMBER_LENGTH; i++) {
			countBall += getBallCount(i, randomNumbers);
		}
		return countBall;
	}

	private int getBallCount(int i, List<BaseballNumber> randomNumbers) {
		if (isBall(i, randomNumbers)) {
			return 1;
		}
		return 0;
	}

	public boolean isBall(int i, List<BaseballNumber> randomNumbers) {
		return !isStrike(i, randomNumbers.get(i)) && randomNumbers.contains(baseballNumbers.get(i));
	}

	public Score score(List<BaseballNumber> randomNumbers) {
		int strikeCount = countStrike(randomNumbers);
		int ballCount = countBall(randomNumbers);
		return new Score(strikeCount, ballCount);
	}
}
