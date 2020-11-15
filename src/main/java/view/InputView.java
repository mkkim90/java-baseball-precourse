package view;

import java.util.List;
import java.util.Scanner;

import domain.BaseballGameStatus;
import domain.BaseballNumbers;

public class InputView {
	private static final String INPUT_NUMBER_MESSAGE = "���ڸ� �Է����ּ���";
	private static final String INPUT_ASK_RESTART_MESSAGE = "������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���";
	private static final Scanner SCANNER = new Scanner(System.in);
	
	public static BaseballNumbers getBaseballNumbers() {
		try {
			System.out.println(INPUT_NUMBER_MESSAGE);
			return new BaseballNumbers(SCANNER.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getBaseballNumbers();
		}
	}
	
	public static BaseballGameStatus getGameStatus() {
		try {
			System.out.println(INPUT_ASK_RESTART_MESSAGE);
			return BaseballGameStatus.get(SCANNER.nextLine());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return getGameStatus();
		}
	}
	
}
