package domain;

import java.util.List;
import java.util.Objects;

import view.InputView;

public class BaseballGame {
	private final BaseballNumberRepository baseballNumberRepository;
	private final static int MAX_STRIKE_COUNT = 3;
	private boolean isEnd = false;
	
	public BaseballGame(BaseballNumberRepository baseballNumberRepository) {
		this.baseballNumberRepository = Objects.requireNonNull(baseballNumberRepository);
	}
	
	public void play() {
		while(!isEnd) {
			List<BaseballNumber> randomNumbers = baseballNumberRepository.randomNumbers();
			result(randomNumbers);
			askRestartGame();
		}
	}
	
	private void result(List<BaseballNumber> randomNumbers) {
		int countStrike = 0;
		int countBall = 0;
		while(!isAnswer(countStrike)) {
			BaseballNumbers baseballNumbers = InputView.getBaseballNumbers();
			countStrike = baseballNumbers.countStrike(randomNumbers);
			countBall = baseballNumbers.countBall(randomNumbers);
			if (countStrike > 0) {
				System.out.println(countStrike + "��Ʈ����ũ");
			}
			if (countBall > 0) {
				System.out.println(countBall + "��");
			}
		}
		System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ��������");
	}
	
	
	private boolean isAnswer(int countStrike) {
		return countStrike == MAX_STRIKE_COUNT;
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
