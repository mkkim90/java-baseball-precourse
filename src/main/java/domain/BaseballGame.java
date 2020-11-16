package domain;

import java.util.List;
import java.util.Objects;

import view.InputView;

public class BaseballGame {
	private final BaseballNumberRepository baseballNumberRepository;
	private boolean isEnd = false;

	public BaseballGame(BaseballNumberRepository baseballNumberRepository) {
		this.baseballNumberRepository = Objects.requireNonNull(baseballNumberRepository);
	}

	public void play() {
		while (!isEnd) {
			List<BaseballNumber> randomNumbers = baseballNumberRepository.randomNumbers();
			result(randomNumbers);
			askRestartGame();
		}
	}

	private void result(List<BaseballNumber> randomNumbers) {
		boolean isMaxStrikeCount = false;
		while (!isMaxStrikeCount) {
			BaseballNumbers baseballNumbers = InputView.getBaseballNumbers();
			Score score = baseballNumbers.score(randomNumbers);
			System.out.println(score.message());
			isMaxStrikeCount = score.isMaxStrikeCount();
		}
		System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ��������");
	}

	private void askRestartGame() {
		BaseballGameStatus baseballGameStatus = InputView.getGameStatus();
		if (BaseballGameStatus.EXIT.equals(baseballGameStatus)) {
			System.out.println("������ ����Ǿ����ϴ�. �����մϴ�.");
			isEnd = true;
			return;
		}
	}
}
