package view;

public class OutputView {
	private static final String OUTPUT_SUCCESS_MESSAGE = "3���� ���ڸ� ��� �����̽��ϴ�! ��������";
	private static final String OUTPUT_EXIT_MESSAGE = "������ ����Ǿ����ϴ�. �����մϴ�.";
		
	public static void successMessage() {
		System.out.println(OUTPUT_SUCCESS_MESSAGE);
	}
	
	public static void exitMessage() {
		System.out.println(OUTPUT_EXIT_MESSAGE);
	}
	
	public static void show(String message) {
		System.out.println(message);
	}
	
}
