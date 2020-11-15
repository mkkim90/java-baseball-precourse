package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {

	@Test
	@DisplayName("nullüũ")
	void testBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers(null))
        .isInstanceOf(NullPointerException.class);
	}
	
	@Test
	@DisplayName("���� üũ")
	void testvalidNumberBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123ff"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("���� üũ")
	void testvalidIntegerBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("123.111"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("�ڸ��� üũ")
	void testvalidLengthBaseballNumbers() {
		assertThatThrownBy(() -> new BaseballNumbers("1234"))
        .isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	@DisplayName("��Ʈ����ũ���� Ȯ��")
	void testIsStrikeBaseballNumbers() {
		BaseballNumbers baseballNumbers = new BaseballNumbers("123");
		assertThat(baseballNumbers.isStrike(0, new BaseballNumber(1))).isEqualTo(true);
		assertThat(baseballNumbers.isStrike(0, new BaseballNumber(2))).isEqualTo(false);
		assertThat(baseballNumbers.isStrike(1, new BaseballNumber(2))).isEqualTo(true);
		assertThat(baseballNumbers.isStrike(2, new BaseballNumber(3))).isEqualTo(true);
	}

}
